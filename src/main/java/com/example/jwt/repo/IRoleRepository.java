package com.example.jwt.repo;

import com.example.jwt.service.domain.RoleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleData, Long> {
    RoleData findByName(String name);
}
