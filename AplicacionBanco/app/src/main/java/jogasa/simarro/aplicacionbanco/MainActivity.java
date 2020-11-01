package jogasa.simarro.aplicacionbanco;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import jogasa.simarro.aplicacionbanco.bd.MiBD;
import jogasa.simarro.aplicacionbanco.bd.MiBancoOperacional;
import jogasa.simarro.aplicacionbanco.pojo.Cliente;
import jogasa.simarro.aplicacionbanco.pojo.Cuenta;
import jogasa.simarro.aplicacionbanco.pojo.Movimiento;

public class MainActivity extends AppCompatActivity {
    MiBancoOperacional mbo;
    Cliente a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mbo=MiBancoOperacional.getInstance(this);
        //MiBancoOperacional mbo = MiBancoOperacional.getInstance(this);
        Toast.makeText(this, "SHOW", Toast.LENGTH_SHORT).show();
        final EditText txtdatos=(EditText) findViewById(R.id.editUsuario);
        final EditText txtContrasena=(EditText) findViewById(R.id.editContrasena);
        ImageButton btnAcceder=(ImageButton)findViewById(R.id.btnAcceder);


        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(MainActivity.this,mainAppActivity.class);
                //startActivity(intent);
                a = new Cliente();

                a.setNif(txtdatos.getText().toString());
                a.setClaveSeguridad(txtContrasena.getText().toString());
                a = mbo.login(a);

                if(a!=null){
                    Intent intent=new Intent(MainActivity.this,mainAppActivity.class);
                    intent.putExtra("Cliente",a);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Usuario/Contraseña incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    protected void onDestroy(){

        super.onDestroy();//MiBD.closeDB();
    }
}