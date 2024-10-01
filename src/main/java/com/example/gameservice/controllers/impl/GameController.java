package com.example.gameservice.controllers.impl;

import com.example.gameservice.commons.entities.Game;
import com.example.gameservice.controllers.GameApi;
import com.example.gameservice.services.GameService;
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

    //GUARDAR JUEGO
    @Override
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        var gameCreated = this.gameService.saveGame(game);
        return ResponseEntity.ok(gameCreated);
    }

    //OBTENER JUEGO BY ID
    @Override
    public ResponseEntity<Game> getGameById(String id) {
        return ResponseEntity.ok(this.gameService.getGameById(id));
    }

    //OBTENER TODOS LOS JUEGOS
    @Override
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(this.gameService.getAllGames());
    }

    //ACTUALIZAR JUEGO
    @Override
    public ResponseEntity<Game> updateGame(String id, Game game) {
        return ResponseEntity.ok(this.gameService.updateGame(id,game));
    }

    //BORRAR JUEGO BY ID
    @Override
    public ResponseEntity<Void> deleteGame(String id) {
       this.gameService.deleteGame(id);
       return ResponseEntity.noContent().build();
    }

}
