package com.example.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {

    private final static List<UserDetails> APPLICATIO_USER = Arrays.asList(
            new User(
                    "mdmehedi03@gmail.com",
                    "mehedi",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),
            new User(
                    "mehedi@cellosco.pe",
                    "mehedi",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );

    public UserDetails findUserByEmail(String email){
        return APPLICATIO_USER
                .stream()
                .filter(user -> user.getUsername().equals(email))
                .findFirst()
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found with this email")
                );
    }
}
