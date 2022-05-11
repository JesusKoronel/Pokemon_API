package com.example.api_peliculas.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.api_peliculas.Interface.InterfazPresenterDetalles;
import com.example.api_peliculas.Interface.InterfazViewDetalles;
import com.example.api_peliculas.Presenter.PresenterDetalles;
import com.example.api_peliculas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DetallesPokemon extends AppCompatActivity implements InterfazViewDetalles{
    private ImageView imagen;
    private TextView titulo;
    private TextView habilidades;
    private TextView stats;
    private TextView tipoelemental;
    private InterfazPresenterDetalles presenterDetalles;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_pokemon);
        imagen = findViewById(R.id.imagen);
        titulo = findViewById(R.id.titulo);
        habilidades = findViewById(R.id.habilidades);
        stats = findViewById(R.id.stats);
        tipoelemental = findViewById(R.id.tipoelemental);
        presenterDetalles = new PresenterDetalles(this);
        constraintLayout = findViewById(R.id.constraint);

        inicializarValores();
        solicitarStats();
        solicitarHabilidades();
        solicitarElemental();
        
    }

    @Override
    public void mostrarHabilidades(String stringHabilidades){
        habilidades.setText(stringHabilidades);
    }

    @Override
    public void solicitarHabilidades() {
        String title = String.valueOf(titulo.getText());
        presenterDetalles.solicitarHabilidades(title);
    }

    @Override
    public void mostrarStats(String stringStats) {
        stats.setText(stringStats);
    }

    @Override
    public void solicitarStats() {
        String title = String.valueOf(titulo.getText());
        presenterDetalles.solicitarStats(title);
    }

    @Override
    public void mostrarElemental(String stringElemental) {
        tipoelemental.setText(stringElemental);
    }

    @Override
    public void solicitarElemental() {
        String title = String.valueOf(titulo.getText());
        presenterDetalles.solicitarElemental(title);
    }

    private void inicializarValores() {
        Bundle extras = getIntent().getExtras();
        String pokemonNombre = extras.getString("nombre");
        String link = extras.getString("url");
        titulo.setText(pokemonNombre.toUpperCase());
        Picasso.with(this)
                .load(link)
                .into(imagen);
        imagen.setDrawingCacheEnabled(true);
        imagen.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        imagen.layout(0, 0, imagen.getMeasuredWidth(), imagen.getMeasuredHeight());
        imagen.buildDrawingCache(true);

        if(imagen.getDrawingCache()!=null) {
            Bitmap bitmap = Bitmap.createBitmap(imagen.getDrawingCache());
            imagen.setDrawingCacheEnabled(false);
            if (bitmap.getHeight() == 4){
                inicializarValores();
            }else {
                int color = getDominantColor(bitmap);
                constraintLayout.setBackgroundColor(color);
            }
        }
    }
    public static int getDominantColor(Bitmap bitmap) {
        List<Palette.Swatch> swatchesTemp = Palette.from(bitmap).generate().getSwatches();
        List<Palette.Swatch> swatches = new ArrayList<>(swatchesTemp);
        Collections.sort(swatches, (swatch1, swatch2) -> swatch2.getPopulation() - swatch1.getPopulation());
        return swatches.size() > 0 ? swatches.get(0).getRgb() : 0;
    }
}