package jogasa.simarro.aplicacionbanco.fragments;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.adaptadores.AdapterMovimientos;
import jogasa.simarro.aplicacionbanco.bd.MiBancoOperacional;
import jogasa.simarro.aplicacionbanco.pojo.Cuenta;
import jogasa.simarro.aplicacionbanco.pojo.DialogoMovimientos;
import jogasa.simarro.aplicacionbanco.pojo.Movimiento;

public class Activiy_Fragment_Movimientos extends Fragment implements AdapterView.OnItemClickListener {
    public ListView movimientosList;
    MiBancoOperacional mbo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movimientos, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mbo = MiBancoOperacional.getInstance(this.getContext());
        movimientosList = (ListView) getView().findViewById(R.id.LstMovimientos);
        movimientosList.setOnItemClickListener(this);

    }

    public void mostrarMovimientos(Cuenta cuenta) {
        ArrayList<Movimiento> movimientos = mbo.getMovimientos(cuenta);
        movimientosList.setAdapter(new AdapterMovimientos(this, movimientos));
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DialogoMovimientos dialogoAlerta = new DialogoMovimientos();
        dialogoAlerta.movimiento = (Movimiento) movimientosList.getAdapter().getItem(position);
        dialogoAlerta.show(getFragmentManager(), "Alerta");
    }
}
