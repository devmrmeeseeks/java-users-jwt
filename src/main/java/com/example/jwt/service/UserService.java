package com.example.jwt.service;

import com.example.jwt.service.domain.RoleData;
import com.example.jwt.service.domain.UserData;
import com.example.jwt.api.model.user.types.UserModel;
import com.example.jwt.repo.IRoleRepository;
import com.example.jwt.repo.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional @Slf4j
public class UserService implements IUserService{
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserModel createUser(UserData user) {
        log.info("Store new user {} to the database", user.getUserName());
        UserData storedUser = userRepository.save(user);
        return modelMapper.map(storedUser, UserModel.class);
    }

    @Override
    public RoleData createRole(RoleData role) {
        log.info("Store new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void createRoleAssignation(String userName, String roleName) {
        log.info("Assign role {} to user {}", roleName, userName);
        UserData user = userRepository.findByUserName(userName);
        RoleData role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public UserData getUser(String userName) {
        log.info("Get user by username {}", userName);
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<UserData> getUsers() {
        log.info("Get all users");
        return userRepository.findAll();
    }
}
