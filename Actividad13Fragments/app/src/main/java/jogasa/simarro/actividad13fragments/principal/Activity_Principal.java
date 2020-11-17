package jogasa.simarro.actividad13fragments.principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import jogasa.simarro.actividad13fragments.R;
import jogasa.simarro.actividad13fragments.fragments.Activity_Fragment_Detalle;
import jogasa.simarro.actividad13fragments.fragments.Activity_Fragment_Lista;
import jogasa.simarro.actividad13fragments.fragments.DiscosListener;
import jogasa.simarro.actividad13fragments.pojo.Disco;

public class Activity_Principal extends AppCompatActivity implements DiscosListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_principal);

        Activity_Fragment_Lista frgLista= (Activity_Fragment_Lista)getSupportFragmentManager().findFragmentById(R.id.FrgListado);
        Activity_Fragment_Detalle frgDetalle=(Activity_Fragment_Detalle)getSupportFragmentManager().findFragmentById(R.id.FrgDetalle);
        frgLista.setDiscosListener(this);

    }

    @Override
    public void onDiscoSeleccionado(Disco c) {
        boolean  hayDetalle=(getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)!=null);
        if(hayDetalle){
          ((Activity_Fragment_Detalle)getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)).mostrarDetalle(c);

        }else{
            Intent i=new Intent(this, Activity_Detalle.class);
            i.putExtra("Texto",c);
            startActivity(i);
        }
    }

}