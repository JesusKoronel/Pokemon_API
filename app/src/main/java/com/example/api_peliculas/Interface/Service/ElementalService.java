package com.example.api_peliculas.Interface.Service;

import com.example.api_peliculas.Model.ElementalRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ElementalService {
    @GET("{tit}")
    Call<ElementalRespuesta> getElemental(@Path("tit") String tit);
}
