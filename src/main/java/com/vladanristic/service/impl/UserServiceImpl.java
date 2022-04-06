package com.vladanristic.service.impl;

import com.vladanristic.dtos.UserDTO;
import com.vladanristic.repository.UserRepository;
import com.vladanristic.entities.User;
import com.vladanristic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Not found!");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        //authorities.add(new SimpleGrantedAuthority("admin"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public User updateWholeUser(User oldUser, User newUser) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        oldUser.setEmail(newUser.getEmail());
        oldUser.setName(newUser.getName());
        oldUser.setLastName(newUser.getLastName());

        UserDTO newDtoUser = (UserDTO) newUser;

        if(newDtoUser.getCurrentPassword() != null && !newDtoUser.getCurrentPassword().equals("")) {
            if(passwordEncoder.matches(newDtoUser.getCurrentPassword(), oldUser.getPassword())) {
                oldUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            } else {
                throw new Exception("Wrong user password provided!");
            }
        }
        return this.userRepository.save(oldUser);
    }

    @Override
    public User updateUserAsAdmin(User currentUser, User updatedUser) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        updatedUser.setEmail(currentUser.getEmail());
        updatedUser.setName(currentUser.getName());
        updatedUser.setLastName(currentUser.getLastName());
        updatedUser.setRole(currentUser.getRole());

        if(!currentUser.getPassword().isEmpty()) {
            updatedUser.setPassword(passwordEncoder.encode(currentUser.getPassword()));
        }

        return this.userRepository.save(updatedUser);
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User createNewUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUser(long userId) {
        return this.userRepository.getById(userId);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllActiveRegularUsers() {
        return this.userRepository.getAllByDeletedAtIsNullAndRoleLikeOrRoleLike("USER", "ADMIN");
    }

    @Override
    public List<User> getAllBannedUsers() {
        return this.userRepository.getAllByDeletedAtIsNotNull();
    }

    @Override
    public boolean deleteUser(long userId) {
        try {
            this.userRepository.delete(this.userRepository.getById(userId));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public User unbanUser(long userId) {
        User currentUser = this.userRepository.getById(userId);
        currentUser.setDeletedAt(null);
        this.userRepository.save(currentUser);
        return currentUser;
    }

    public boolean checkIfUserIsBanned(String email) {

        String databaseName = "vladanristic";
        String url = "jdbc:mysql://localhost:3306/vladanristic";
        String userName = "root";
        String password = "";

        Connection con = null;
        Statement st = null;
        ResultSet res = null;
        String query = "";

        try {
            // Register the jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            // open a connection to database
            con = DriverManager.getConnection(url, userName,
                    password);
            // set auto commit false
            con.setAutoCommit(false);
            st = con.createStatement();
            // lets checkout our DB again
            query = "Select * from users WHERE email LIKE '" + email + "' AND deleted_at IS NULL";
            res = st.executeQuery(query);
            while (res.next()) {
                return true;
            }
            con.rollback();
            return false;
        }
        catch (ClassNotFoundException e) {
            System.out.println("Driver Error");
            e.printStackTrace();
        }
        catch (SQLException e) {
            System.out.println("Connection Error");
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
