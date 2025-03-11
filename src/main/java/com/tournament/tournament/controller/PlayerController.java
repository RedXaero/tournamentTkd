package com.tournament.tournament.controller;

import com.tournament.tournament.entities.Player;
import com.tournament.tournament.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tournament/api/v1")
public class PlayerController {

    private static final Logger log = LoggerFactory.getLogger(PlayerController.class);
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/")
    public ResponseEntity createPlayer(@RequestBody Player player) {
        try{
            return new ResponseEntity(this.playerService.savePlayer(player), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/all/")
    public ResponseEntity<List<Player>> getPlayer() {
        return new  ResponseEntity(this.playerService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/{idPlayer}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("idPlayer") UUID id) {
        Optional<Player> player = this.playerService.getPlayerById(id);
        if(player.isPresent()) {
            return new ResponseEntity(player.get(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{idPlayer}")
    public ResponseEntity deletePlayer(@PathVariable("idPlayer") UUID id) {
        Boolean wasDeleted = this.playerService.deletePlayer(id);
        if(wasDeleted){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{idPlayer}")
    public ResponseEntity updatePlayer(@PathVariable("idPlayer") UUID id, @RequestBody Player player) {

        Optional<Player> playerOptional = this.playerService.updateById(id, player);
        if(playerOptional.isPresent()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/genero/{gender}")
    public ResponseEntity<List<Player>> getPlayerByGender(@PathVariable("gender") String gender) {
        Optional<List<Player>> playerByGender;
        try{
             playerByGender = this.playerService.findByGender(gender);

            if(playerByGender.isPresent()) {
                return new ResponseEntity(playerByGender.get(), HttpStatus.OK);
            }
        }
        catch(Exception e){
            log.info(e.getMessage());
        }


        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }


}
