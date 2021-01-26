package jogasa.simarro.aplicacionbanco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Locale;

import jogasa.simarro.aplicacionbanco.pojo.Cajeros;
import jogasa.simarro.aplicacionbanco.pojo.Cliente;
import jogasa.simarro.aplicacionbanco.pojo.Cuentas;
import jogasa.simarro.aplicacionbanco.pojo.SettingsActivity;
import jogasa.simarro.aplicacionbanco.pojo.Transferencias;

public class mainAppActivity extends AppCompatActivity  implements Serializable {
    Cliente recogido;
    TextView bienvenido;
    public Button btnSalir;
    public SharedPreferences sharedPreferences;
   // public String firstLanguage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        sharedPreferences = getSharedPreferences("preferenciasbancarias", Context.MODE_PRIVATE);

        Toolbar toolbar=(Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        bienvenido=(TextView)findViewById(R.id.bienvenido);


        ImageButton btnAcceder=(ImageButton)findViewById(R.id.btnContrasena);
        btnSalir=(Button)findViewById(R.id.btnSalir);
        ImageButton btnCuentas=(ImageButton)findViewById(R.id.btnCuentas);
        ImageButton btnTransferencias=(ImageButton)findViewById(R.id.btnTransferencias);
        ImageButton btnOpciones=(ImageButton)findViewById(R.id.btnOpciones);
        recogido=(Cliente)getIntent().getSerializableExtra("Cliente");
        bienvenido.setText("Bienvenido "+recogido.getNombre());
        Toast.makeText(this, "Bienvenido "+recogido.getNombre(), Toast.LENGTH_SHORT).show();

        //CHANGE PASSWD
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainAppActivity.this,changePasswd.class);
                intent.putExtra("Cliente",recogido);
                startActivity(intent);
            }
        });
        //CUENTAS
        btnCuentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainAppActivity.this, Cuentas.class);
                intent.putExtra("Cliente",recogido);
                startActivity(intent);
            }
        });
        //EXIT


        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainAppActivity.this, Cajeros.class);
                startActivity(intent);
            }
        });
        //TRANSFERS
        btnTransferencias.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v){
              Intent newintent=new Intent(mainAppActivity.this, Transferencias.class);
              newintent.putExtra("Cliente",recogido);
              startActivity(newintent);
          }
        });
        btnOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings=new Intent(mainAppActivity.this, SettingsActivity.class);
                startActivity(settings);
            }
        });
        /*SharedPreferences pref=getSharedPreferences("preferenciasbancarias",Context.MODE_PRIVATE);
        firstLanguage=pref.getString("idioma","");*/
       // languageFirst();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //languageResume();

        btnSalir.setBackgroundColor(Color.parseColor(sharedPreferences.getString("color", "#ffffff")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_transfer:
                Intent intentTransfers=new Intent(mainAppActivity.this, Transferencias.class);
                intentTransfers.putExtra("Cliente",recogido);
                startActivity(intentTransfers);
                return true;
            case R.id.action_accounts:
                Intent intentAcc=new Intent(mainAppActivity.this, Cuentas.class);
                intentAcc.putExtra("Cliente",recogido);
                startActivity(intentAcc);
                return true;
            case R.id.action_income:
                return true;
            case R.id.action_passwd:
                Intent intentPasswd=new Intent(mainAppActivity.this,changePasswd.class);
                intentPasswd.putExtra("Cliente",recogido);
                startActivity(intentPasswd);
                return true;
            case R.id.action_settings:
                Intent settings=new Intent(mainAppActivity.this, SettingsActivity.class);
                startActivity(settings);
                return true;
            case R.id.action_support:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /*
    public void setLocale(Locale loc){
        Resources res=getResources();
        Configuration config=res.getConfiguration();
        config.locale=loc;
        res.updateConfiguration(config,res.getDisplayMetrics());
    }
    public void languageFirst(){
        switch (firstLanguage){
            case "esp":
                Locale espanol=new Locale("es","ES");
                setLocale(espanol);
                break;
            case "eng":
                Toast.makeText(this, "first", Toast.LENGTH_SHORT).show();
                Locale eng=new Locale("en","EN");
                setLocale(eng);
                break;
        }
    }
    public void languageResume(){
        SharedPreferences pref=getSharedPreferences("preferenciasbancarias", Context.MODE_PRIVATE);
        String language=pref.getString("idioma","ESP");
        Toast.makeText(this, "ACTUAL"+language+",FIRST"+firstLanguage, Toast.LENGTH_SHORT).show();
        if(!firstLanguage.equals(language)){
            switch (language){
                case "esp":
                    Toast.makeText(this, "ESP", Toast.LENGTH_SHORT).show();
                    Locale espanol=new Locale("es","ES");
                    setLocale(espanol);
                    recreate();
                    break;
                case "eng":
                    Toast.makeText(this, "juan", Toast.LENGTH_SHORT).show();
                    Locale eng=new Locale("en","EN");
                    setLocale(eng);
                    recreate();
                    break;
            }
        }
    }*/


    }
