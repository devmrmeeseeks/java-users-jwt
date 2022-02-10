package com.example.jwt.api;

import com.example.jwt.domain.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jwt.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
     private final IUserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserData>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
}
