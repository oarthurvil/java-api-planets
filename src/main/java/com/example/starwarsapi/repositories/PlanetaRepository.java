package com.example.starwarsapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.starwarsapi.models.Planeta;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Long> {

    Optional<Planeta> findByNome(String nome);

}
