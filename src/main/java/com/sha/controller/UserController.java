package com.sha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sha.model.Role;
import com.sha.security.UserPrincipal;
import com.sha.service.UserService;

@RestController
@RequestMapping("api/user")//pre-path
public class UserController
{
    @Autowired
    private UserService userService;

    @PutMapping("change/{role}")//api/user/change/{role}
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrinciple, @PathVariable Role role)
    {
        userService.changeRole(role, userPrinciple.getUsername());

        return ResponseEntity.ok(true);
    }
}