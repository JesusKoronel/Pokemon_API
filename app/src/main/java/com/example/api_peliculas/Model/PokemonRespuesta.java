package com.example.api_peliculas.Model;

import com.example.api_peliculas.Model.Objects.Pokemon;

import java.util.ArrayList;

public class PokemonRespuesta {

    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
