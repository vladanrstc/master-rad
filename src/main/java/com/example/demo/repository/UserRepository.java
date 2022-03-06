package com.example.demo.repository;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> getAllByDeletedAtIsNullAndRoleLikeOrRoleLike(String role1, String role2);
    List<User> getAllByDeletedAtIsNotNull();
}
