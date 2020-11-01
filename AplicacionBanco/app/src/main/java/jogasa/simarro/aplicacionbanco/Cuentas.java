package jogasa.simarro.aplicacionbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import jogasa.simarro.aplicacionbanco.bd.MiBancoOperacional;
import jogasa.simarro.aplicacionbanco.pojo.Cliente;
import jogasa.simarro.aplicacionbanco.pojo.Cuenta;
import jogasa.simarro.aplicacionbanco.pojo.Movimientos;

public class Cuentas extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    Cliente recogida;
    MiBancoOperacional mbo;
    AdapterCuentas<Cuenta> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas);

        mbo= MiBancoOperacional.getInstance(this);
        recogida=(Cliente)getIntent().getSerializableExtra("Cliente");
        lista=(ListView)findViewById(R.id.listaCuentas);
        ArrayList<Cuenta> cuentas=mbo.getCuentas(recogida);
        Log.d("PEPE",String.valueOf(cuentas.get(0).getSaldoActual()));
        adaptador=new AdapterCuentas<Cuenta>(this,cuentas);

        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cuenta cuenta=(Cuenta)adaptador.getItem(position);
        Intent intent=new Intent(Cuentas.this,Movimientos.class);
        intent.putExtra("Cuenta",cuenta);
        startActivity(intent);
    }
}