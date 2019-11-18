package com.ifi.tp.pokemon_type_api.controller;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ifi.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {

    private PokemonTypeService pokemonTypeService;

    public PokemonTypeController(PokemonTypeService service) {
        pokemonTypeService = service;
    }
    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@PathVariable int id){
        return pokemonTypeService.getPokemonType(id);
    }

    @RequestMapping(value = "/", params = "name")
    PokemonType getPokemonTypeFromName(@RequestParam(required = false) String name){
        return pokemonTypeService.getPokemonType(name);
    }
    @RequestMapping(value = "/", params = "types")
    public List<PokemonType> getPokemonTypeFromType(@RequestParam(required = false) List<String> types){
        //System.out.println(type);
        //String[] pokemons = type.split(",");

        return pokemonTypeService.getPokemonTypeByType(types);
    }
    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return pokemonTypeService.getAllPokemonTypes();
    }
}
