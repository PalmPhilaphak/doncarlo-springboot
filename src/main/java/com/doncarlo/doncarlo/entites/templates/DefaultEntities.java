package com.doncarlo.doncarlo.entites.templates;


import com.doncarlo.doncarlo.entites.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@MappedSuperclass
@Getter
public class DefaultEntities {
    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    @JoinColumn(name = "createdBy", nullable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @Setter
    private User createdBy;

    @JoinColumn(name = "updatedBy" ,nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @Setter
    private User updatedBy;

    public User getCreatedByDetail() {
        return this.createdBy;
    }

    @JsonIgnore
    public User getCreatedByUser() {
        return this.createdBy;
    }

    @JsonIgnore
    public User getUpdatedByUser() {
        return this.updatedBy;
    }

}
