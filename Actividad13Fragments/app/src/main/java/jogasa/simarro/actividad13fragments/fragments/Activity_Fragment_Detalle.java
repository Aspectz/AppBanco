package jogasa.simarro.actividad13fragments.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import jogasa.simarro.actividad13fragments.R;
import jogasa.simarro.actividad13fragments.adaptador.AdaptadorCanciones;
import jogasa.simarro.actividad13fragments.pojo.Disco;

public class Activity_Fragment_Detalle extends Fragment {
    public ListView cancionesList;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_detalle, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cancionesList=(ListView)getView().findViewById(R.id.LstDetalle);
    }

    public void mostrarDetalle(Disco canciones) {
        cancionesList.setAdapter(new AdaptadorCanciones(this, canciones.getCanciones()));
    }
}
