package com.ifi.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {
    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = this.getClass().getResourceAsStream("/pokemons.json");

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);
        Optional<PokemonType> findPokemon = pokemons.stream().filter(pokemon -> pokemon.getId() == id).findFirst();
        return findPokemon.orElse(null);
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);

        Optional<PokemonType> findPokemon = pokemons.stream().filter(pokemon -> pokemon.getName().equals(name)).findFirst();
        return findPokemon.orElse(null);
    }

    @Override
    public List<PokemonType> findPokemonTypeByType(List<String> types) {
        System.out.println(types.toString());
        return pokemons.stream().filter(pokemon ->
            pokemon.getTypes().containsAll(types)
        ).collect(Collectors.toList());
    }


    @Override
    public List<PokemonType> findAllPokemonType() {

        return new ArrayList<>(pokemons);
    }
}
