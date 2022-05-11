package com.example.api_peliculas.Interface.Service;

import com.example.api_peliculas.Model.HabilidadesRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HabilidadesService {
    @GET("{tit}")
    Call<HabilidadesRespuesta> getHabilidades(@Path("tit") String tit);
}
