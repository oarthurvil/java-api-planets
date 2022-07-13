package com.example.starwarsapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.starwarsapi.models.Planeta;
import com.example.starwarsapi.repositories.PlanetaRepository;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;

    public List<Planeta> listarTodosPlanetas() {
        return planetaRepository.findAll();
    }

    public Optional<Planeta> buscarPlanetaPorID(Long id) {
        return planetaRepository.findById(id);
    }

    public Optional<Planeta> buscarPlanetaPorNome(String nome) {
        String nomeSemUnderline = nome.replace("_", " ");
        return planetaRepository.findByNome(nomeSemUnderline);
    }

    public Planeta adicionarPlaneta(Planeta planeta) {
        return planetaRepository.save(planeta);
    }

    public Planeta editarPlaneta(Long id, Planeta planeta) {

        Optional<Planeta> planetaEditar = buscarPlanetaPorID(id);

        planetaEditar.get().setNome(planeta.getNome());
        planetaEditar.get().setClima(planeta.getClima());
        planetaEditar.get().setTerreno(planeta.getTerreno());

        return planetaRepository.save(planetaEditar.get());
    }

    public void deletarPlaneta(Long id) {
        planetaRepository.deleteById(id);
    }

}
