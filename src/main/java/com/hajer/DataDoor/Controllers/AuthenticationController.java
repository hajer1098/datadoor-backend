package com.hajer.DataDoor.Controllers;


import com.hajer.DataDoor.Config.JwtUtils;
import com.hajer.DataDoor.Dto.AuthenticationRequest;
import com.hajer.DataDoor.Dto.AuthenticationResponse;
import com.hajer.DataDoor.Dto.UserDto;
import com.hajer.DataDoor.Repositories.UserRepository;
import com.hajer.DataDoor.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final UserService service;
    private final AuthenticationManager authManager;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> Register(
            @RequestBody UserDto user){
        return ResponseEntity.ok(service.register(user));


    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request){


           return  ResponseEntity.ok(service.authenticate(request));
        
    }


}
