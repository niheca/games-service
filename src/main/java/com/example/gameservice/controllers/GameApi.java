package com.example.gameservice.controllers;

import com.example.gameservice.commons.constants.ApiPathVariables;
import com.example.gameservice.commons.entities.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//-> /v1/games
@RequestMapping(ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public interface GameApi {

    @PostMapping()
    ResponseEntity<Game> saveGame(@RequestBody Game game);

    @GetMapping("/{id}")
    ResponseEntity<Game> getGameById(@PathVariable String id);

    @GetMapping
    ResponseEntity<List<Game>> getAllGames();
}
