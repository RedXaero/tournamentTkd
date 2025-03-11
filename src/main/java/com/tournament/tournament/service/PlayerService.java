package com.tournament.tournament.service;

import com.tournament.tournament.entities.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerService {

     Player savePlayer(Player player);

     List<Player> getAllPlayers();

     Optional<Player> getPlayerById(UUID id);

     boolean deletePlayer(UUID id);

     Optional<Player> updateById(UUID id, Player player);

     Optional<List<Player>> findByGender(String gender);

}
