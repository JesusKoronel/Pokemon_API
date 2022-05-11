package com.example.api_peliculas.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.api_peliculas.Model.Objects.Pokemon;
import com.example.api_peliculas.Presenter.PresenterDetalles;
import com.example.api_peliculas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> implements View.OnClickListener{

    private List<Pokemon> dataset;
    private List<Pokemon> buscarPokemon;
    private Context context;
    private View.OnClickListener listener;
    private PresenterDetalles presenterDetalles;

    public PokemonAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
        this.buscarPokemon = new ArrayList<>();
        buscarPokemon.addAll(dataset);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cada_pokemon, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pokemon p = dataset.get(position);
        holder.tvNombre.setText(p.getName());
        String id = p.getNumber();
        if (id.length()==1)
            id = "00"+id;
        else if (id.length()==2)
            id = "0"+id;
        else
            id = id;
        String urlCompleta = "https://img.pokemondb.net/artwork/" + p.getName().toLowerCase() + ".jpg";
        String linkPokemon = "https://raw.githubusercontent.com/ZeChrales/PogoAssets/master/pokemon_icons/pokemon_icon_"+id+"_00_shiny.png";
        Picasso.with(context)
                .load(urlCompleta)
                .into(holder.ivFoto);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetallesPokemon.class);
                intent.putExtra("nombre", p.getName());
                intent.putExtra("url", linkPokemon);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void filtroBusqueda(String stringBusqueda) {
        buscarPokemon.addAll(dataset);
        if(stringBusqueda.length() == 0){
            dataset.clear();
            dataset.addAll(buscarPokemon);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                dataset.clear();
                List<Pokemon> lista = buscarPokemon.stream()
                        .filter(i -> i.getName().toLowerCase().contains(stringBusqueda.toLowerCase())).collect(Collectors.toList());
                dataset.addAll(lista);
            }else{
                dataset.clear();
                for (Pokemon p: buscarPokemon
                     ) {
                    if (p.getName().toLowerCase().contains(stringBusqueda.toLowerCase())){
                        dataset.add(p);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFoto;
        private TextView tvNombre;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.ivFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
        }
    }
}

