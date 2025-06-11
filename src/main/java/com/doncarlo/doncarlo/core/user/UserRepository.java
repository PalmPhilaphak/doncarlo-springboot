package com.doncarlo.doncarlo.core.user;

import com.doncarlo.doncarlo.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.deletedAt is null")
    Optional<User> findByEmail(@Param("email") String email);
}
