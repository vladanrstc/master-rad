package com.example.demo.controllers.admin;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AdminUserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public User createNewUser(@RequestBody User user) {
        return this.userService.createNewUser(user);
    }

    @PatchMapping("/users/{userId}")
    public User updateUser(@PathVariable(required = false, name = "userId") long userId, @RequestBody User user) {
        try {
            return this.userService.updateUserAsAdmin(user, this.userService.getUser(userId));
        } catch (Exception exception) {
            return null;
        }
    }

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

    @GetMapping(value = "users/unban/{userId}")
    public User unbanUser(@PathVariable(required = false, name = "userId") long userId) {
        return this.userService.unbanUser(userId);
    }

    @DeleteMapping(value = "users/{userId}")
    public boolean deleteUser(@PathVariable(required = false, name = "userId") long userId) {
        return this.userService.deleteUser(userId);
    }

}
