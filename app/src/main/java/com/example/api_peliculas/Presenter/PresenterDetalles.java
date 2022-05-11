package com.example.api_peliculas.Presenter;

import com.example.api_peliculas.Interface.InterfazInteractorDetalles;
import com.example.api_peliculas.Interface.InterfazPresenterDetalles;
import com.example.api_peliculas.Interface.InterfazViewDetalles;
import com.example.api_peliculas.Model.InteractorDetalles;

public class PresenterDetalles implements InterfazPresenterDetalles {
        private InterfazInteractorDetalles interactorDetalles;
        private InterfazViewDetalles interfazViewDetalles;

    public PresenterDetalles(InterfazViewDetalles interfazViewDetalles) {
        this.interactorDetalles = new InteractorDetalles(this);
        this.interfazViewDetalles = interfazViewDetalles;
    }

    @Override
    public void enviarHabilidades(String stringHabilidades) {
        interfazViewDetalles.mostrarHabilidades(stringHabilidades);
    }

    @Override
    public void solicitarHabilidades(String tit) {
        interactorDetalles.enviarHabilidades(tit);
    }

    @Override
    public void enviarStats(String stringStats) {
        interfazViewDetalles.mostrarStats(stringStats);
    }

    @Override
    public void solicitarStats(String tit) {
        interactorDetalles.enviarStats(tit);
    }

    @Override
    public void enviarElemental(String stringElemental) {
        interfazViewDetalles.mostrarElemental(stringElemental);
    }

    @Override
    public void solicitarElemental(String tit) {
        interactorDetalles.enviarElemental(tit);
    }


}
