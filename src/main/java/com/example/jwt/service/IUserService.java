package com.example.jwt.service;

import com.example.jwt.domain.RoleData;
import com.example.jwt.domain.UserData;

import java.util.List;

public interface IUserService {
    UserData CreateUser(UserData user);
    RoleData CreateRole(RoleData role);
    void CreateRoleAssignation(String userName, String roleName);
    UserData getUser(String userName);
    List<UserData> getUsers();
}
