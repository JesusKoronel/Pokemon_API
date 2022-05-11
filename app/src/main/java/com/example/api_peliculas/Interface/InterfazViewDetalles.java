package com.example.api_peliculas.Interface;

import com.example.api_peliculas.Model.Objects.Habilidades;

import java.util.ArrayList;

public interface InterfazViewDetalles {
    void mostrarHabilidades(String stringHabilidades);
    void solicitarHabilidades();

    void mostrarStats(String stringStats);
    void solicitarStats();

    void mostrarElemental(String stringElemental);
    void solicitarElemental();
}
