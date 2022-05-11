package com.example.api_peliculas.Interface.Service;

import android.os.Bundle;

import com.example.api_peliculas.Model.StatsRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StatsService {

    @GET("{tit}")
    Call<StatsRespuesta> getStats(@Path("tit") String tit);
}

