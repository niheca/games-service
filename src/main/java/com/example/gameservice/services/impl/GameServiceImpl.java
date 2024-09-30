package com.example.gameservice.services.impl;

import com.example.gameservice.commons.entities.Game;
import com.example.gameservice.commons.exceptions.GameException;
import com.example.gameservice.repositories.GameRepository;
import com.example.gameservice.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {

        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game gameRequest) {
        return this.gameRepository.save(gameRequest);
    }

    @Override
    public Game getGameById(String id) {
        return this.gameRepository.findById(Long.valueOf(id))
                .orElseThrow(()-> new GameException(HttpStatus.NOT_FOUND,"Error finding game"));
    }

    @Override
    public List<Game> getAllGames() {
        return this.gameRepository.findAll();
    }
}
