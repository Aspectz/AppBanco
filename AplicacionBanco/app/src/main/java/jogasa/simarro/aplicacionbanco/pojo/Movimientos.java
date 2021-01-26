package jogasa.simarro.aplicacionbanco.pojo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import jogasa.simarro.aplicacionbanco.fragments.Activiy_Fragment_Movimientos;
import jogasa.simarro.aplicacionbanco.R;

public class Movimientos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimientos);
        Activiy_Fragment_Movimientos movimientos=(Activiy_Fragment_Movimientos)getSupportFragmentManager().findFragmentById(R.id.FrgMovimientos);
        movimientos.mostrarMovimientos((Cuenta)getIntent().getExtras().get("Movimiento"));



    }

}