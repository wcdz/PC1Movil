package com.javajhon.repaso.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javajhon.repaso.R;


public class RecyclerDatosAdapter extends RecyclerView.Adapter<RecyclerDatosAdapter.Contenedor> {
    Context contexto;
    String[] signos, descrip;

    public RecyclerDatosAdapter(Context contexto, String[] signos, String[] descrip) {
        this.contexto = contexto;
        this.signos = signos;
        this.descrip = descrip;
    }

    @NonNull
    @Override
    public Contenedor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View view = inflater.inflate(R.layout.recycler_datos,parent,false);
        return new Contenedor(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Contenedor holder, int position) {
        holder.titulo.setText(signos[position]);
        holder.descripcion.setText(descrip[position]);
    }

    @Override
    public int getItemCount() {
        return signos.length;
    }

    public class Contenedor extends RecyclerView.ViewHolder{
        TextView titulo,descripcion;

        public Contenedor(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.recycler_signo);
            descripcion = itemView.findViewById(R.id.recycler_descripcion);
        }
    }
}
