package jogasa.simarro.aplicacionbanco.pojo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.adaptadores.CajerosCursorAdapter;
import jogasa.simarro.aplicacionbanco.dao.CajeroDAO;

public class Cajeros extends AppCompatActivity {
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
}