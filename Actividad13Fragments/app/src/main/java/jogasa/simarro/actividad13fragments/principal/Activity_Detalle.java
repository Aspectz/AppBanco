package jogasa.simarro.actividad13fragments.principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import jogasa.simarro.actividad13fragments.R;
import jogasa.simarro.actividad13fragments.fragments.Activity_Fragment_Detalle;
import jogasa.simarro.actividad13fragments.pojo.Disco;

public class Activity_Detalle extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_detalle);

        Activity_Fragment_Detalle detalle=(Activity_Fragment_Detalle)getSupportFragmentManager().findFragmentById(R.id.FrgDetalle);
        detalle.mostrarDetalle((Disco) getIntent().getExtras().get("Texto"));
    }


}