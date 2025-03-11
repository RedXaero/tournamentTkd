package com.tournament.tournament.repository;

import com.tournament.tournament.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {


    //@Query("SELECT p FROM Player p WHERE p.sexo = ?1")
    List<Player> findBySexo(String gender);
}
