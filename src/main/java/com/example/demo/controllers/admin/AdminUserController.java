package com.example.demo.controllers.admin;

import com.example.demo.entities.Section;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllActiveRegularUsers() {
        List<User> users = this.userService.getAllActiveRegularUsers();
        users.forEach(user -> {user.setUserCourseStartedList(null);});
        return users;
    }

    @GetMapping(value = "/users-banned")
    public List<User> getBannedUsers() {
        List<User> users = this.userService.getAllBannedUsers();
        users.forEach(user -> {user.setUserCourseStartedList(null);});
        return users;
    }

    @DeleteMapping(value = "users/ban/{userId}")
    public User banUser(@PathVariable(required = false, name = "userId") long userId) {
        User currentUser = this.userService.getUser(userId);
        currentUser.setDeletedAt(new Date());
        return this.userService.saveUser(currentUser);
    }

}
