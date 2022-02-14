package com.example.jwt.service;

import com.example.jwt.service.domain.RoleData;
import com.example.jwt.service.domain.UserData;
import com.example.jwt.api.model.user.types.UserModel;

import java.util.List;

public interface IUserService {
    UserModel createUser(UserData user);
    RoleData createRole(RoleData role);
    void createRoleAssignation(String userName, String roleName);
    UserData getUser(String userName);
    List<UserData> getUsers();
}
