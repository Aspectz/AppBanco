package jogasa.simarro.aplicacionbanco.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import jogasa.simarro.aplicacionbanco.bd.Constantes;
import jogasa.simarro.aplicacionbanco.bd.MiBDCajeros;

public class CajeroDAO {
    public static final String C_TABLA="cajeros";


    private Context context;
    private MiBDCajeros dbHelper;
    private SQLiteDatabase db;


    public CajeroDAO(Context con){
        this.context=con;
    }
    public CajeroDAO open(){
        dbHelper=new MiBDCajeros(context);
        db=dbHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        db.close();
    }

    public Cursor getCursor(){
        Cursor c=db.query(true,C_TABLA, Constantes.CAMPOS_CAJEROS,null,null,null,null,null,null);
        return c;
    }

}
