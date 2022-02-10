package com.example.jwt.repo;

import com.example.jwt.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserData, Long> {
    UserData findByUserName(String userName);
}
