package com.acevedo.tenisapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acevedo.tenisapp.R;
import com.acevedo.tenisapp.clases.Partido;

import java.util.List;

public class PartidoAdapter extends RecyclerView.Adapter<PartidoAdapter.PartidoHolder> {

    Context context;
    List<Partido> partidoList;

    public PartidoAdapter(Context context, List<Partido> partidoList) {
        this.context = context;
        this.partidoList = partidoList;
    }

    @NonNull
    @Override
    public PartidoAdapter.PartidoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.partido_item, parent, false);
        return new PartidoHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull PartidoAdapter.PartidoHolder holder, int position) {
        Partido partido = partidoList.get(position);
        holder.setFecha(partido.getFechaPartido());
        holder.setHora(partido.getHoraPartido());
        holder.setCancha(partido.getCancha());
        holder.setJugador1(partido.getJugador1());
        holder.setJugador2(partido.getJugador2());
    }

    @Override
    public int getItemCount() {
        return partidoList.size();
    }

    public class PartidoHolder extends RecyclerView.ViewHolder {

        TextView tvFecha, tvHora, tvCancha, tvJugador1, tvJugador2;

        public PartidoHolder(@NonNull View itemView) {
            super(itemView);
            tvFecha = itemView.findViewById(R.id.tvFechaPartido);
            tvHora = itemView.findViewById(R.id.tvHoraPartido);
            tvCancha = itemView.findViewById(R.id.tvCancha);
            tvJugador1 = itemView.findViewById(R.id.tvJugador1);
            tvJugador2 = itemView.findViewById(R.id.tvJugador2);
        }

        public void setFecha(String fechaPartido) {
            tvFecha.setText(fechaPartido);
        }

        public void setHora(String horaPartido) {
            tvHora.setText(horaPartido);
        }

        public void setCancha(int cancha) {
            tvCancha.setText(cancha+"");
        }

        public void setJugador1(String jugador1) {
            tvJugador1.setText(jugador1);
            tvJugador1.setSelected(true);
        }

        public void setJugador2(String jugador2) {
            tvJugador2.setText(jugador2);
            tvJugador2.setSelected(true);
        }
    }
}
