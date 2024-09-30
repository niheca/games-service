package com.example.gameservice.controllers.impl;

import com.example.gameservice.commons.entities.Game;
import com.example.gameservice.controllers.GameApi;
import com.example.gameservice.services.GameService;
import com.example.gameservice.services.impl.GameServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController implements GameApi {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        var gameCreated = this.gameService.saveGame(game);
        return ResponseEntity.ok(gameCreated);
    }

    @Override
    public ResponseEntity<Game> getGameById(String id) {
        return ResponseEntity.ok(this.gameService.getGameById(id));
    }

    @Override
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(this.gameService.getAllGames());
    }

}
