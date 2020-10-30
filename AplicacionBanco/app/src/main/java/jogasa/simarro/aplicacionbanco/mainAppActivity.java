package jogasa.simarro.aplicacionbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.Serializable;

import jogasa.simarro.aplicacionbanco.pojo.Cliente;

public class mainAppActivity extends AppCompatActivity  implements Serializable {
    Cliente recogido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        ImageButton btnAcceder=(ImageButton)findViewById(R.id.btnContrasena);
        Button btnSalir=(Button)findViewById(R.id.btnSalir);
        ImageButton btnCuentas=(ImageButton)findViewById(R.id.btnCuentas);

        ImageButton btnTransferencias=(ImageButton)findViewById(R.id.btnTransferencias);
        recogido=(Cliente)getIntent().getSerializableExtra("Cliente");
        Toast.makeText(this, "Bienvenido "+recogido.getNombre(), Toast.LENGTH_SHORT).show();
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainAppActivity.this,changePasswd.class);
                intent.putExtra("Cliente",recogido);
                startActivity(intent);
            }
        });
        btnCuentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainAppActivity.this,Cuentas.class);
                intent.putExtra("Cliente",recogido);
                startActivity(intent);
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainAppActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnTransferencias.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v){
              Intent newintent=new Intent(mainAppActivity.this, Transferencias.class);
              startActivity(newintent);
          }
        });

    }
}