package com.example.api_peliculas.Model;

import android.util.Log;

import com.example.api_peliculas.Interface.InterfazInteractorDetalles;
import com.example.api_peliculas.Interface.InterfazPresenterDetalles;
import com.example.api_peliculas.Interface.Service.ElementalService;
import com.example.api_peliculas.Interface.Service.HabilidadesService;
import com.example.api_peliculas.Interface.Service.StatsService;
import com.example.api_peliculas.Model.Objects.Elemental;
import com.example.api_peliculas.Model.Objects.Habilidades;
import com.example.api_peliculas.Model.Objects.Stats;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InteractorDetalles implements InterfazInteractorDetalles {
    private InterfazPresenterDetalles presenterDetalles;

    public InteractorDetalles(InterfazPresenterDetalles presenterDetalles) {
        this.presenterDetalles = presenterDetalles;
    }

    @Override
    public void enviarHabilidades(String tit) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/pokemon/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HabilidadesService habilidadesService = retrofit.create(HabilidadesService.class);
        Call<HabilidadesRespuesta> habilidadesRespuestaCall = habilidadesService.getHabilidades(tit.toLowerCase());
        habilidadesRespuestaCall.enqueue(new Callback<HabilidadesRespuesta>() {
            @Override
            public void onResponse(Call<HabilidadesRespuesta> call, Response<HabilidadesRespuesta> response) {
                if (response.isSuccessful()) {
                    HabilidadesRespuesta habilidadesRespuesta = response.body();
                    ArrayList<Habilidades> listaHabilidades = habilidadesRespuesta.getAbilities();
                    String resultado = "";
                    for (Habilidades h : listaHabilidades) {
                        resultado += "Habilidad: " + h.getAbility().getName() + "\n\n";
                        habilidadesExito(resultado);
                    }
                } else {
                    Log.e("ENTRO", "Error: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<HabilidadesRespuesta> call, Throwable t) {
                Log.e("NO ENTRO A HABILIDADES", t.getMessage());
            }
        });
    }

    @Override
    public void habilidadesExito(String stringHabilidades) {
        presenterDetalles.enviarHabilidades(stringHabilidades);
    }

    @Override
    public void enviarStats(String tit) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/pokemon/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        StatsService statsService = retrofit.create(StatsService.class);
        Call<StatsRespuesta> statsRespuestaCall = statsService.getStats(tit.toLowerCase());
        statsRespuestaCall.enqueue(new Callback<StatsRespuesta>() {
            @Override
            public void onResponse(Call<StatsRespuesta> call, Response<StatsRespuesta> response) {
                if (response.isSuccessful()) {
                    StatsRespuesta statsRespuesta = response.body();
                    ArrayList<Stats> listaStats = statsRespuesta.getStats();
                    String resultado = "";
                    for (Stats s : listaStats) {
                        resultado += s.getStat().getName() + "\n";
                        resultado += "Estadistica basica: " + s.getBase_stat() + "\n\n\n";
                        statsExito(resultado);
                    }
                } else {
                    Log.e("ENTRO", "Error: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<StatsRespuesta> call, Throwable t) {
                Log.e("NO ENTRO",t.getMessage());
            }
        });
    }

    @Override
    public void statsExito(String stringStats) {
        presenterDetalles.enviarStats(stringStats);
    }

    @Override
    public void enviarElemental(String tit) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/pokemon/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ElementalService elementalService = retrofit.create(ElementalService.class);
        Call<ElementalRespuesta> elementalRespuestaCall = elementalService.getElemental(tit.toLowerCase());
        elementalRespuestaCall.enqueue(new Callback<ElementalRespuesta>() {
            @Override
            public void onResponse(Call<ElementalRespuesta> call, Response<ElementalRespuesta> response) {
                if (response.isSuccessful()) {
                    ElementalRespuesta elementalRespuesta = response.body();
                    ArrayList<Elemental> listaelemental = elementalRespuesta.getTypes();
                    String resultado = "\n";
                    for (Elemental e : listaelemental) {
                        resultado += "Tipo Elemental: " + e.getType().getName() + "\n\n";
                        elementalExito(resultado);
                    }
                } else {
                    Log.e("ENTRO", "Error: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ElementalRespuesta> call, Throwable t) {
                Log.e("NO ENTRO", t.getMessage());
            }
        });
    }

    @Override
    public void elementalExito(String stringElemental) {
        presenterDetalles.enviarElemental(stringElemental);
    }
}
