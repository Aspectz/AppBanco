package jogasa.simarro.aplicacionbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class mainAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        ImageButton btnAcceder=(ImageButton)findViewById(R.id.btnContrasena);
        Button btnSalir=(Button)findViewById(R.id.btnSalir);
        ImageButton btnTransferencias=(ImageButton)findViewById(R.id.btnTransferencias);
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainAppActivity.this,changePasswd.class);
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