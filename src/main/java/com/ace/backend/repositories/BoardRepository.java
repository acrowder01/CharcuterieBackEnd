package com.ace.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ace.backend.models.board;

@Repository
public interface BoardRepository extends JpaRepository <board, Integer>{

}
