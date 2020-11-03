package jogasa.simarro.aplicacionbanco.pojo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jogasa.simarro.aplicacionbanco.AdapterCuentas;
import jogasa.simarro.aplicacionbanco.AdapterMovimientos;
import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.bd.MiBancoOperacional;

public class Movimientos extends AppCompatActivity {
    Cuenta recodiga;
    ListView listaMovimientosView;
    MiBancoOperacional mbo;
    AdapterMovimientos<Movimiento> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimientos);

        mbo= MiBancoOperacional.getInstance(this);
        listaMovimientosView=(ListView)findViewById(R.id.listaMovimientos);
        recodiga=(Cuenta)getIntent().getSerializableExtra("Cuenta");
        ArrayList<Movimiento> listaMovimientos=mbo.getMovimientos(recodiga);
        adaptador =
                new AdapterMovimientos<Movimiento>(this, listaMovimientos);

        listaMovimientosView.setAdapter(adaptador);
    }
}