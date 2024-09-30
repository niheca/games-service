package com.example.gameservice.repositories;

import com.example.gameservice.commons.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long>{
}
