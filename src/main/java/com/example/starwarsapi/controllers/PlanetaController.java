package com.example.starwarsapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.starwarsapi.models.Planeta;
import com.example.starwarsapi.services.PlanetaService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @GetMapping
    public List<Planeta> listarTodosPlanetas() {
        return planetaService.listarTodosPlanetas();
    }

    @GetMapping(value = "/id={id}")
    public Optional<Planeta> buscarPlanetaPorID(@PathVariable(name = "id") Long id) {
        return planetaService.buscarPlanetaPorID(id);
    }

    @GetMapping(value = "/nome={nome}")
    public Optional<Planeta> buscarPlanetaPorNome(@PathVariable(name = "nome") String nome) {
        return planetaService.buscarPlanetaPorNome(nome);
    }

    @PostMapping(path = "/criar")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Planeta adicionarPlaneta(@RequestBody Planeta planeta) {
        return planetaService.adicionarPlaneta(planeta);
    }

    @PutMapping(value="/editar/id={id}")
    public Planeta editarPlaneta(@PathVariable Long id, @RequestBody Planeta planeta) {      
        return planetaService.editarPlaneta(id, planeta);
    }
    
    @DeleteMapping(value = "/deletar/id={id}")
    public void deletarPlaneta(@PathVariable Long id) {
        planetaService.deletarPlaneta(id);
    }
}
