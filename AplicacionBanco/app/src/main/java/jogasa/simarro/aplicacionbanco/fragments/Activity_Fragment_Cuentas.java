package jogasa.simarro.aplicacionbanco.fragments;

import android.icu.util.LocaleData;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.adaptadores.AdapterCuentas;
import jogasa.simarro.aplicacionbanco.bd.MiBancoOperacional;
import jogasa.simarro.aplicacionbanco.pojo.Cliente;
import jogasa.simarro.aplicacionbanco.pojo.Cuenta;
import jogasa.simarro.aplicacionbanco.pojo.DialogoMovimientos;


public class Activity_Fragment_Cuentas extends Fragment implements AdapterView.OnItemClickListener {
    Cliente recogida;
    private CuentasListener cuentasListener;
    private ListView movimientosList;
    MiBancoOperacional mbo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mbo= MiBancoOperacional.getInstance(this.getContext());
        return inflater.inflate(R.layout.fragment_cuentas,container,false);

    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recogida=(Cliente)getActivity().getIntent().getSerializableExtra("Cliente");
        ArrayList<Cuenta> cuentas=mbo.getCuentas(recogida);
        movimientosList=(ListView)getView().findViewById(R.id.LstCuentas);
        movimientosList.setAdapter(new AdapterCuentas(this,cuentas));
        movimientosList.setOnItemClickListener(this);
    }

    public void setCuentasListener(CuentasListener cuentas){
        this.cuentasListener=cuentas;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(cuentasListener!=null){
                cuentasListener.onCuentaSeleccionada((Cuenta)movimientosList.getAdapter().getItem(position));

        }
    }
}
