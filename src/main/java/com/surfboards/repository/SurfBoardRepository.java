package com.surfboards.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surfboards.entity.Surfboard;

public interface SurfBoardRepository extends JpaRepository<Surfboard, Long> {

}
