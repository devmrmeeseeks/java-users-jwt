package com.example.jwt.service;

import com.example.jwt.domain.RoleData;
import com.example.jwt.domain.UserData;

import java.util.List;

public interface IUserService {
    UserData createUser(UserData user);
    RoleData createRole(RoleData role);
    void createRoleAssignation(String userName, String roleName);
    UserData getUser(String userName);
    List<UserData> getUsers();
}
