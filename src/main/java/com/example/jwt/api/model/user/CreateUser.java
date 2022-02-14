package com.example.jwt.api.model.user;

import com.example.jwt.api.model.IResponse;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateUser implements IResponse<CreateUserResponse> {
    private String name;
    private String userName;
}