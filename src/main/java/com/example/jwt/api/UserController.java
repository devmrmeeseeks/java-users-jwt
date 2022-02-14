package com.example.jwt.api;

import com.example.jwt.domain.RoleData;
import com.example.jwt.domain.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jwt.service.IUserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    
    @PostMapping("/user/create")
    public ResponseEntity<UserData>CreateUser(@RequestBody UserData user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/create").toUriString());
        return ResponseEntity.created(uri).body(userService.createUser(user));
    }

    @PostMapping("/role/create")
    public ResponseEntity<RoleData>CreateRole(@RequestBody RoleData role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/create").toUriString());
        return ResponseEntity.created(uri).body(userService.createRole(role));
    }
}
