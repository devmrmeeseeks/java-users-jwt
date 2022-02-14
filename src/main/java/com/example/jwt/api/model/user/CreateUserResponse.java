package com.example.jwt.api.model.user;

import com.example.jwt.api.model.user.types.UserModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateUserResponse {
    private UserModel user;

    public CreateUserResponse(UserModel user) {
        this.user = user;
    }
}
