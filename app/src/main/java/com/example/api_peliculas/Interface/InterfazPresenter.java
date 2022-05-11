package com.example.api_peliculas.Interface;

import com.example.api_peliculas.Model.Objects.Pokemon;

import java.util.ArrayList;

public interface InterfazPresenter {
    void enviarResultado(ArrayList<Pokemon> pokemones);
    void solicitarPokemones();
}
