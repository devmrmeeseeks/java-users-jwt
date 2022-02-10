package com.example.jwt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class UserData {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String userName;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleData> roles = new ArrayList<>();
}
