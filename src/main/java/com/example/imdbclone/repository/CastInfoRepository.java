package com.example.imdbclone.repository;

import com.example.imdbclone.model.CastInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastInfoRepository extends JpaRepository<CastInfo, Long> {
}
