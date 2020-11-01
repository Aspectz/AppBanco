package jogasa.simarro.aplicacionbanco.pojo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.bd.MiBancoOperacional;

public class Movimientos extends AppCompatActivity {
    Cuenta recodiga;
    ListView listaMovimientosView;
    MiBancoOperacional mbo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimientos);
        mbo= MiBancoOperacional.getInstance(this);
        listaMovimientosView=(ListView)findViewById(R.id.listaMovimientos);
        recodiga=(Cuenta)getIntent().getSerializableExtra("Cuenta");
        ArrayList<Movimiento> listaMovimientos=mbo.getMovimientos(recodiga);
        ArrayList<String> movimientos=new ArrayList<String>();

        for(int i=0;i<=listaMovimientos.size()-1;i++){
            String pepe=listaMovimientos.get(i).toString();
            movimientos.add(listaMovimientos.get(i).toString());
        }
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movimientos);

        listaMovimientosView.setAdapter(adaptador);
    }
}