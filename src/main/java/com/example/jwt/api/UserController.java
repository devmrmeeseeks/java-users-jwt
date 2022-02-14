package com.example.jwt.api;

import com.example.jwt.api.model.user.CreateUser;
import com.example.jwt.api.model.user.CreateUserResponse;
import com.example.jwt.service.IUserService;
import com.example.jwt.service.domain.RoleData;
import com.example.jwt.service.domain.UserData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
     private final IUserService userService;
     private final ModelMapper modelMapper;

    @Autowired
    public UserController(IUserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserData>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
    
    @PostMapping("/user/create")
    public ResponseEntity<CreateUserResponse>CreateUser(@RequestBody CreateUser request) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/create").toUriString());
        UserData user = modelMapper.map(request, UserData.class);
        CreateUserResponse response = new CreateUserResponse(userService.createUser(user));

        return ResponseEntity.created(uri).body(response);
    }

    @PostMapping("/role/create")
    public ResponseEntity<RoleData>CreateRole(@RequestBody RoleData role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/create").toUriString());
        return ResponseEntity.created(uri).body(userService.createRole(role));
    }
}
