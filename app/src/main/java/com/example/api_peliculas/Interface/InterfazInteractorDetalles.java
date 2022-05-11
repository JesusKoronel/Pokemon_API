package com.example.api_peliculas.Interface;

import com.example.api_peliculas.Model.Objects.Habilidades;

import java.util.ArrayList;

public interface InterfazInteractorDetalles {
    void enviarHabilidades(String tit);
    void habilidadesExito(String stringHabilidades);

    void enviarStats(String tit);
    void statsExito(String stringStats);

    void enviarElemental(String tit);
    void elementalExito(String stringElemental);
}
