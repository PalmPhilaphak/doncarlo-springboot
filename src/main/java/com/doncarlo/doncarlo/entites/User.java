package com.doncarlo.doncarlo.entites;

import com.doncarlo.doncarlo.entites.templates.DefaultEntities;
import com.doncarlo.doncarlo.http.user.dto.UserResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import java.sql.Timestamp;

@Entity
@Table(name = "users")
@SQLDelete(sql = "update users u set u.deletedAt = now() where u.id = ?")
@NoArgsConstructor
public class User extends DefaultEntities {

    public User(Long id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment
    @Column(nullable = false, updatable = false)
    private Long id;


    @Column(nullable = false, updatable = true)
    private String email;

    @JsonIgnore
    @Size(min = 8)
    @Column
    private String password;

    @Column(columnDefinition="TIMESTAMP DEFAULT NULL")
    private Timestamp deletedAt;

    public UserResponse toResponse() {
        return new UserResponse(this);
    }

}
