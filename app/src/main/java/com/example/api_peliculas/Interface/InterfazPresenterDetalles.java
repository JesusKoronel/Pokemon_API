package com.example.api_peliculas.Interface;

import com.example.api_peliculas.Model.Objects.Habilidades;

import java.util.ArrayList;

public interface InterfazPresenterDetalles {
    void enviarHabilidades(String stringHabilidades);
    void solicitarHabilidades(String tit);

    void enviarStats(String stringStats);
    void solicitarStats(String tit);

    void enviarElemental(String stringElemental);
    void solicitarElemental(String tit);
    }
