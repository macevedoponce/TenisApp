package com.acevedo.tenisapp.ui.partidos;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acevedo.tenisapp.R;
import com.acevedo.tenisapp.Util.Util;
import com.acevedo.tenisapp.adapter.PartidoAdapter;
import com.acevedo.tenisapp.clases.Partido;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class PartidosFragment extends Fragment {

    RecyclerView rvPartidos;
    List<Partido> partidoList;
    RequestQueue requestQueue;
    ProgressDialog progreso;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_partidos, container, false);
        rvPartidos = vista.findViewById(R.id.rvPartidos);
        rvPartidos.setHasFixedSize(true);
        rvPartidos.setLayoutManager(new LinearLayoutManager(getContext()));
        requestQueue = Volley.newRequestQueue(getContext());
        partidoList = new ArrayList<>();
        cargarPartidos();
        return vista;
    }

    private void cargarPartidos() {
        progreso = new ProgressDialog(getContext());
        progreso.setMessage("Buscando Partidos");
        progreso.setCancelable(false);
        progreso.show();

        String url = Util.RUTA_PARTIDOS;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progreso.dismiss();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        int id = jsonObject.getInt("id");
                        String fecha_partido = jsonObject.getString("fecha_partido");
                        String hora_partido = jsonObject.getString("hora_partido");
                        int cancha = jsonObject.getInt("cancha");
                        String jugador1 = jsonObject.getString("jugador1");
                        String jugador2 = jsonObject.getString("jugador2");
                        Partido partido = new Partido(id, fecha_partido, hora_partido, cancha, jugador1, jugador2);
                        partidoList.add(partido);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                PartidoAdapter adapter = new PartidoAdapter(getContext(), partidoList);


                rvPartidos.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progreso.hide();
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}