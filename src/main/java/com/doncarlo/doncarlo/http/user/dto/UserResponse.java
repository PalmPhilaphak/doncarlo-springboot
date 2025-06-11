package com.doncarlo.doncarlo.http.user.dto;

import com.doncarlo.doncarlo.entites.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private String CreatedBy;

    private String UpdatedBt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date updatedAt;

    public UserResponse(User user){
        this.id = user.toResponse().getId();

    }
}
