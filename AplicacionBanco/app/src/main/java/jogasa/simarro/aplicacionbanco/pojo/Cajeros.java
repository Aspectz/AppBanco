package jogasa.simarro.aplicacionbanco.pojo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.adaptadores.CajerosCursorAdapter;
import jogasa.simarro.aplicacionbanco.bd.Constantes;
import jogasa.simarro.aplicacionbanco.dao.CajeroDAO;

public class Cajeros extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private CajeroDAO cajeroDAO;
    private CajerosCursorAdapter cajeroCursorAdapter;
    private Cursor cursor;
    private TextView txtSinDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cajeros);
        listView=(ListView)findViewById(R.id.listaCajeros);
        cajeroDAO=new CajeroDAO(this);
        try{

            cajeroDAO.open();
            cursor=cajeroDAO.getCursor();
            startManagingCursor(cursor);
            cajeroCursorAdapter = new CajerosCursorAdapter(this,cursor);
            listView.setAdapter(cajeroCursorAdapter);

            if(cursor.getCount()>0){
                txtSinDatos=(TextView)findViewById(R.id.txtSinDatos);
                txtSinDatos.setVisibility(View.INVISIBLE);
                txtSinDatos.invalidate();
            }
            Toast.makeText(this, "base de datos creada", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "Couldnt open the database u little faggot", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(Cajeros.this,GestionCajerosActivity.class);
        intent.putExtra(Constantes.C_MODO,Constantes.C_VISUALIZAR);
        intent.putExtra(Constantes.FIELD_CAJEROS_ID,id);
        startActivityForResult(intent,Constantes.C_VISUALIZAR);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cajeros,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        Intent i;
        if(id==R.id.menu_crear){
            i=new Intent(Cajeros.this,GestionCajerosActivity.class);
            i.putExtra(Constantes.C_MODO,Constantes.C_CREAR);
            startActivityForResult(i,Constantes.C_CREAR);

            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Toast.makeText(this, String.valueOf(requestCode), Toast.LENGTH_SHORT).show();
        if(requestCode==Constantes.C_CREAR){
            if(resultCode==RESULT_OK){
                recargar_lista();
            }
        }
        if(requestCode==Constantes.C_VISUALIZAR){
            if(resultCode==RESULT_OK){
                recargar_lista();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void recargar_lista() {

        CajeroDAO cajeroDAO=new CajeroDAO(getBaseContext());
        cajeroDAO.open();
        CajerosCursorAdapter cajerosCursorAdapter=new CajerosCursorAdapter(this,cajeroDAO.getCursor());
        listView.setAdapter(cajerosCursorAdapter);
    }


}