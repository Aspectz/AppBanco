package jogasa.simarro.aplicacionbanco.pojo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.adaptadores.AdapterCuentas;
import jogasa.simarro.aplicacionbanco.bd.MiBancoOperacional;
import jogasa.simarro.aplicacionbanco.fragments.Activity_Fragment_Cuentas;
import jogasa.simarro.aplicacionbanco.fragments.Activiy_Fragment_Movimientos;
import jogasa.simarro.aplicacionbanco.fragments.CuentasListener;

public class Cuentas extends AppCompatActivity implements CuentasListener {
    //Cliente recogida;
    MiBancoOperacional mbo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas);

        mbo= MiBancoOperacional.getInstance(this);
        /*recogida=(Cliente)getIntent().getSerializableExtra("Cliente");
        ArrayList<Cuenta> cuentas=mbo.getCuentas(recogida);*/

        Activity_Fragment_Cuentas frgCuentas=(Activity_Fragment_Cuentas)getSupportFragmentManager().findFragmentById(R.id.FrgCuentas);

        frgCuentas.setCuentasListener(this);

    }

    @Override
    public void onCuentaSeleccionada(Cuenta c) {
        boolean hayMovimientos=(getSupportFragmentManager().findFragmentById(R.id.FrgMovimientos)!=null);
        if(hayMovimientos){
            ((Activiy_Fragment_Movimientos)getSupportFragmentManager().findFragmentById(R.id.FrgMovimientos)).mostrarMovimientos(c);
        }else{
            Intent i=new Intent(this,Movimientos.class);
            i.putExtra("Movimiento",c);
            startActivity(i);
        }
    }
}