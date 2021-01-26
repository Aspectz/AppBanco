package jogasa.simarro.aplicacionbanco.adaptadores;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.bd.Constantes;
import jogasa.simarro.aplicacionbanco.dao.CajeroDAO;

public class CajerosCursorAdapter extends CursorAdapter {
    private CajeroDAO cajeroDAO=null;
    public CajerosCursorAdapter(Context context, Cursor c) {
        super(context,c,0);
        cajeroDAO=new CajeroDAO(context);
        cajeroDAO.open();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.support_simple_spinner_dropdown_item,viewGroup,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv=(TextView)view;
        //Obtenemos el indicne de la columna
        int i=cursor.getColumnIndex(Constantes.FIELD_DIRECCION);
        tv.setText(cursor.getString(i));
    }
}
