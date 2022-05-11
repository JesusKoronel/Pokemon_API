package com.example.api_peliculas.Interface;

import com.example.api_peliculas.Model.Objects.Pokemon;

import java.util.ArrayList;

public interface InterfazView {
    void mostrarResultado(ArrayList<Pokemon> pokemon);
    void solicitarPokemones();
}
