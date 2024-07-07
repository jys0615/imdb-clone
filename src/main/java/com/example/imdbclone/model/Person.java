package com.example.imdbclone.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private String birthCountry;
    private int birthYear;
    private int deathYear;
    private String ageGroup;
    private String deathCause;
    private String heightGroup;

    @OneToMany(mappedBy = "person")
    private Set<CastInfo> castInfos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getDeathCause() {
        return deathCause;
    }

    public void setDeathCause(String deathCause) {
        this.deathCause = deathCause;
    }

    public String getHeightGroup() {
        return heightGroup;
    }

    public void setHeightGroup(String heightGroup) {
        this.heightGroup = heightGroup;
    }

    public Set<CastInfo> getCastInfos() {
        return castInfos;
    }

    public void setCastInfos(Set<CastInfo> castInfos) {
        this.castInfos = castInfos;
    }
}
