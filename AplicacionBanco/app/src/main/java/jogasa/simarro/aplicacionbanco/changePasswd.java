package jogasa.simarro.aplicacionbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class changePasswd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_passwd);

        Button btnAcceder=(Button)findViewById(R.id.btnchangecontrasena);


        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(changePasswd.this,mainAppActivity.class);
                startActivity(intent);
                Toast.makeText(changePasswd.this, getText(R.string.contraseñaActualizada), Toast.LENGTH_SHORT).show();
            }
        });
    }
}