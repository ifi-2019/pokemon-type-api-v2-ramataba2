package com.ifi.tp.pokemon_type_api.service;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ifi.tp.pokemon_type_api.repository.PokemonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    PokemonTypeRepository pokemonTypeRepository;

    @Autowired
    public PokemonTypeServiceImpl(PokemonTypeRepository repository){
        pokemonTypeRepository = repository;
    }

    @Override
    public PokemonType getPokemonType(int id) {
        return pokemonTypeRepository.findPokemonTypeById(id);
    }

    @Override
    public PokemonType getPokemonType(String name) {
        return pokemonTypeRepository.findPokemonTypeByName(name);
    }
    @Override
    public List<PokemonType> getPokemonTypeByType(List<String> types){
        System.out.println(types.toString());
        //List<PokemonType> popo = pokemonTypeRepository.findPokemonTypeByType(types);
        //System.out.println(popo);
        return pokemonTypeRepository.findPokemonTypeByType(types);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        return pokemonTypeRepository.findAllPokemonType();
    }


}