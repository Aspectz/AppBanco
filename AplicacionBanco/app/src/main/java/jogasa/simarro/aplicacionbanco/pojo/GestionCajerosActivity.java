package jogasa.simarro.aplicacionbanco.pojo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.bd.Constantes;
import jogasa.simarro.aplicacionbanco.dao.CajeroDAO;

public class GestionCajerosActivity extends AppCompatActivity {
    private CajeroDAO cajeroDAO;
    private Cursor cursor;
    private int mode;
    private long id;

    private EditText direccion;
    private EditText latitud;
    private EditText longitud;
    private EditText zoom;
    private EditText cajeros;


    private Button botonGuardar, botonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_cajeros);

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        if (extra == null) {
            return;
        }
        direccion = (EditText) findViewById(R.id.direccion);
        latitud = (EditText) findViewById(R.id.latitud);
        longitud = (EditText) findViewById(R.id.longitud);
        zoom = (EditText) findViewById(R.id.zoom);
        cajeros = (EditText) findViewById(R.id.cajeros);

        botonCancelar = (Button) findViewById(R.id.boton_cancelar);
        botonGuardar = (Button) findViewById(R.id.boton_guardar);

        cajeroDAO = new CajeroDAO(this);
        try {
            cajeroDAO.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Obtenemos el id del registro
        if (extra.containsKey(Constantes.FIELD_CAJEROS_ID)) {
            id = extra.getLong(Constantes.FIELD_CAJEROS_ID);
            consultar(id);
        }
        establecerModo(extra.getInt(Constantes.C_MODO));

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar();
            }
        });


    }

    private void consultar(long id) {
        cursor = cajeroDAO.getRegistro(id);

        direccion.setText(cursor.getString(cursor.getColumnIndex(Constantes.FIELD_DIRECCION)));
        longitud.setText(cursor.getString(cursor.getColumnIndex(Constantes.FIELD_LNG)));
        latitud.setText(cursor.getString(cursor.getColumnIndex(Constantes.FIELD_LAT)));
        cajeros.setText(cursor.getString(cursor.getColumnIndex(Constantes.CAJEROS_TABLE)));
        zoom.setText(cursor.getString(cursor.getColumnIndex(Constantes.FIELD_ZOOM)));


    }

    private void establecerModo(int m) {
        this.mode = m;

        if (mode == Constantes.C_VISUALIZAR) {
            this.setTitle(direccion.getText().toString());
            this.setEdicion(false);
            botonCancelar.setEnabled(false);
            botonGuardar.setEnabled(false);

        } else if (mode == Constantes.C_CREAR) {
            this.setTitle(R.string.cajero_crear_titulo);
            this.setEdicion(true);
        } else if (mode == Constantes.C_EDITAR) {
            this.setTitle(R.string.cajero_editar_titulo);
            this.setEdicion(true);
            botonCancelar.setEnabled(true);
            botonGuardar.setEnabled(true);
        }
    }

    private void setEdicion(boolean opcion) {
        direccion.setEnabled(opcion);
        zoom.setEnabled(opcion);
        latitud.setEnabled(opcion);
        longitud.setEnabled(opcion);
        cajeros.setEnabled(opcion);


    }

    private void guardar() {
        ContentValues reg = new ContentValues();
        reg.put(Constantes.FIELD_DIRECCION, direccion.getText().toString());
        reg.put(Constantes.FIELD_LAT, latitud.getText().toString());
        reg.put(Constantes.FIELD_LNG, longitud.getText().toString());
        reg.put(Constantes.FIELD_ZOOM, zoom.getText().toString());
        reg.put(Constantes.CAJEROS_TABLE,cajeros.getText().toString());

        if (mode == Constantes.C_CREAR) {
            cajeroDAO.insert(reg);
            Toast.makeText(this, "Hipoteca creada correctamente", Toast.LENGTH_SHORT).show();
        }
        if (mode == Constantes.C_EDITAR) {
            reg.put(Constantes.FIELD_CAJEROS_ID, id);
            cajeroDAO.update(reg);
        }
        setResult(RESULT_OK);
        finish();
    }

    private void cancelar() {
        setResult(RESULT_CANCELED, null);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opcionescajeros, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_editar) {
            establecerModo(Constantes.C_EDITAR);
            return true;
        }
        if (item.getItemId() == R.id.menu_eliminar) {
            cajeroDAO.delete(id);
            setResult(RESULT_OK);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}