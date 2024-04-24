package com.sha.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.sha.model.User;
import com.sha.security.UserPrincipal;
import com.sha.security.jwt.JwtProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
	   private final JwtProvider jwtProvider;
	    private final AuthenticationManager authenticationManager;
	    
	    @Override
	    public User signInAndReturnJWT(User signInRequest)
	    {
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
	        );

	        UserPrincipal userPrinciple = (UserPrincipal) authentication.getPrincipal();
	        String jwt = jwtProvider.generateToken(userPrinciple);

	        User signInUser = userPrinciple.getUser();
	        signInUser.setToken(jwt);

	        return signInUser;
	    }

}
