package com.example.api_peliculas.Model;

import android.util.Log;

import com.example.api_peliculas.Interface.InterfazInteractor;
import com.example.api_peliculas.Interface.InterfazPresenter;
import com.example.api_peliculas.Interface.Service.PokemonService;
import com.example.api_peliculas.Model.Objects.Pokemon;
import com.example.api_peliculas.View.PokemonAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InteractorPokemon implements InterfazInteractor {

    private InterfazPresenter presenter;
    private PokemonAdapter pokemonAdapter;

    public InteractorPokemon(InterfazPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void enviarResultado() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PokemonService service = retrofit.create(PokemonService.class);
        Call<PokemonRespuesta> pokemonRespuestaCall = service.getPokemon(1100, 0);
        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {

            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {

                if (response.isSuccessful()) {
                    PokemonRespuesta pokemonRespuesta = response.body();
                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();
                    consultaExitosa(listaPokemon);

                } else {
                    Log.e("ERROR ON RESPONSE", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Log.e("ERROR - NO ENTRO", " onResponse: " + t.getMessage());
            }
        });
    }

    @Override
    public void consultaExitosa(ArrayList<Pokemon> pokemones) {
        presenter.enviarResultado(pokemones);
    }
}
