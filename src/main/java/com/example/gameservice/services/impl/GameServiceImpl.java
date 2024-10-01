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
                .orElseThrow(()-> new GameException(HttpStatus.NOT_FOUND,"Error Finding Game"));
    }

    @Override
    public List<Game> getAllGames() {
        return this.gameRepository.findAll();
    }

    @Override
    public Game updateGame(String id, Game game) {
        Game oldGame =  getGameById(id);
        oldGame.setName(game.getName());
        return this.gameRepository.save(oldGame);
    }

    @Override
    public void deleteGame(String gameId) {
        Game gameToDelete = getGameById(gameId);
        this.gameRepository.delete(gameToDelete);
    }
}
