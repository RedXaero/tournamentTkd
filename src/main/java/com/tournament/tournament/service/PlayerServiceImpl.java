package com.tournament.tournament.service;

import com.tournament.tournament.entities.Player;
import com.tournament.tournament.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player savePlayer(Player player) {
        Player savedPlayer = new Player();

        savedPlayer.setName(player.getName());
        savedPlayer.setaPaterno(player.getaPaterno());
        savedPlayer.setaMaterno(player.getaMaterno());
        savedPlayer.setAltura(player.getAltura());
        savedPlayer.setPeso(player.getPeso());
        savedPlayer.setFechaNacimiento(player.getFechaNacimiento());
        savedPlayer.setSexo(player.getSexo());

        return this.playerRepository.save(savedPlayer);
    }

    @Override
    public List<Player> getAllPlayers() {

        return this.playerRepository.findAll();
    }

    @Override
    public Optional<Player> getPlayerById(UUID id) {
        Optional<Player> player = this.playerRepository.findById(id);

        return player;
    }

    @Override
    public boolean deletePlayer(UUID id) {
        if(this.playerRepository.findById(id).isPresent()) {
            this.playerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Player> updateById(UUID id, Player player) {

        if(this.playerRepository.findById(id).isPresent()) {
            Player updatedPlayer = this.playerRepository.findById(id).get();
            if(player.getName() != null) {
                updatedPlayer.setName(player.getName());
            }
            if(player.getaPaterno() != null) {
                updatedPlayer.setaPaterno(player.getaPaterno());
            }
            if(player.getaMaterno() != null) {
                updatedPlayer.setaMaterno(player.getaMaterno());
            }
            if(player.getAltura() != null) {
                updatedPlayer.setAltura(player.getAltura());
            }
            if(player.getPeso() != null) {
                updatedPlayer.setPeso(player.getPeso());
            }
            if(player.getFechaNacimiento() != null) {
                updatedPlayer.setFechaNacimiento(player.getFechaNacimiento());
            }

            return Optional.of(this.playerRepository.save(updatedPlayer));
        }

        return Optional.empty();
    }

    @Override
    public Optional<List<Player>> findByGender(String gender) {
        Optional<List<Player>> playerByGender = Optional.ofNullable(this.playerRepository.findBySexo(gender));

        return playerByGender;
    }
}
