package jogasa.simarro.aplicacionbanco.dao;

import android.content.ContentValues;
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
    public Cursor getRegistro(long id){
        String condicion=Constantes.FIELD_CAJEROS_ID +"="+id;
        Cursor c=db.query(true,C_TABLA,Constantes.CAMPOS_CAJEROS,condicion,null,null,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public long insert(ContentValues reg){
        if(db==null){
            open();
        }
        return db.insert(C_TABLA,null,reg);
    }
    public long update(ContentValues reg){
        long result=0;
        long id=0;
        if(db==null){
            open();
        }
        if(reg.containsKey(Constantes.FIELD_CAJEROS_ID)){
            id=reg.getAsLong(Constantes.FIELD_CAJEROS_ID);
            reg.remove(Constantes.FIELD_CAJEROS_ID);
        }
        result=db.update(C_TABLA,reg,"_id="+id,null);
        return result;
    }
    public long delete(long id){
        long result=0;
        if(db==null){
            open();
        }
        result=db.delete(C_TABLA,"_id="+id,null);
        return result;
    }

}
