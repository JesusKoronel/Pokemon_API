package com.example.api_peliculas.Presenter;

import com.example.api_peliculas.Interface.InterfazInteractor;
import com.example.api_peliculas.Interface.InterfazPresenter;
import com.example.api_peliculas.Interface.InterfazView;
import com.example.api_peliculas.Model.InteractorPokemon;
import com.example.api_peliculas.Model.Objects.Pokemon;

import java.util.ArrayList;

public class PresenterPokemon implements InterfazPresenter {
    private InterfazInteractor interactor;
    private InterfazView view;

    public PresenterPokemon(InterfazView view) {
        this.interactor = new InteractorPokemon(this);
        this.view = view;
    }

    @Override
    public void enviarResultado(ArrayList<Pokemon> pokemones) {
        view.mostrarResultado(pokemones);
    }

    @Override
    public void solicitarPokemones() {
        interactor.enviarResultado();
    }
}
