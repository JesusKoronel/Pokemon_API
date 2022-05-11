package com.example.api_peliculas.Interface.Service;

import com.example.api_peliculas.Model.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonService {
    @GET("pokemon")
    Call<PokemonRespuesta> getPokemon(@Query("limit") int limit, @Query("offset") int offset);
}
