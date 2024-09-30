package com.example.gameservice.services;

import com.example.gameservice.commons.entities.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {

    Game saveGame(Game game);

    Game getGameById(String gameId);

    List<Game> getAllGames();

    Game updateGame(String gameId, String newGameName);
}
