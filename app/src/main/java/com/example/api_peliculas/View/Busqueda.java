package com.example.api_peliculas.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.api_peliculas.Interface.InterfazPresenter;
import com.example.api_peliculas.Interface.InterfazView;
import com.example.api_peliculas.Model.Objects.Pokemon;
import com.example.api_peliculas.Presenter.PresenterPokemon;
import com.example.api_peliculas.R;

import java.util.ArrayList;

import retrofit2.Retrofit;

public class Busqueda extends AppCompatActivity implements InterfazView, androidx.appcompat.widget.SearchView.OnQueryTextListener {
    private androidx.appcompat.widget.SearchView svBusqueda;
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;
    private InterfazPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        presenter = new PresenterPokemon(this);
        svBusqueda = findViewById(R.id.svBusqueda);
        recyclerView = findViewById(R.id.recyclerView);
        pokemonAdapter = new PokemonAdapter(this);
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        initListener();
        solicitarPokemones();
    }

    private void initListener(){
        svBusqueda.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        pokemonAdapter.filtroBusqueda(newText);
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    @Override
    public void mostrarResultado(ArrayList<Pokemon> pokemon) {
        pokemonAdapter = new PokemonAdapter(this);
        pokemonAdapter.adicionarListaPokemon(pokemon);
        recyclerView.setAdapter(pokemonAdapter);

    }

    @Override
    public void solicitarPokemones() {
        presenter.solicitarPokemones();
    }
}