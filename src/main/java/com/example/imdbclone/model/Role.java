package com.example.imdbclone.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @OneToMany(mappedBy = "role")
    private Set<CastInfo> castInfos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<CastInfo> getCastInfos() {
        return castInfos;
    }

    public void setCastInfos(Set<CastInfo> castInfos) {
        this.castInfos = castInfos;
    }
}
