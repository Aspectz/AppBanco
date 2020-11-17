package jogasa.simarro.aplicacionbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import jogasa.simarro.aplicacionbanco.bd.MiBancoOperacional;
import jogasa.simarro.aplicacionbanco.pojo.Cliente;

public class changePasswd extends AppCompatActivity {
    Cliente recogido;
    MiBancoOperacional mbo;
    EditText newPasswd,oldPasswd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_passwd);
        mbo=MiBancoOperacional.getInstance(this);
        recogido=(Cliente)getIntent().getSerializableExtra("Cliente");
        Button btnAcceder=(Button)findViewById(R.id.btnchangecontrasena);
        newPasswd=(EditText)findViewById(R.id.txtNewPasswd);
        oldPasswd=(EditText)findViewById(R.id.oldtxtPasswd);
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oldPasswd.getText().toString().compareTo(recogido.getClaveSeguridad())==0){
                   recogido.setClaveSeguridad(newPasswd.getText().toString());
                   mbo.changePassword(recogido);
                    Intent intent=new Intent(changePasswd.this,mainAppActivity.class);
                    intent.putExtra("Cliente",recogido);
                    startActivity(intent);
                    Toast.makeText(changePasswd.this, getText(R.string.contraseñaActualizada), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(changePasswd.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}