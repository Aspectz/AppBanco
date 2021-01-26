package jogasa.simarro.aplicacionbanco.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MiBDCajeros extends SQLiteOpenHelper {

    private static int version=1;
    private static String nombreBD="cajerosBD";
    private static SQLiteDatabase.CursorFactory factory=null;
    private String sqlCreacionTablaCajeros= "CREATE TABLE cajeros("+
            "_id INTEGER PRIMARY KEY,"+
            "direccion TEXT NOT NULL,"+
            "lat TEXT NOT NULL,"+
            "lng TEXT NOT NULL,"+
            "zoom TEXT NOT NULL,"+
            "cajeros TEXT)";

    private String sqlIndiceNombreCajeros="CREATE UNIQUE INDEX nombrecajeros ON cajeros(direccion ASC)";


    public MiBDCajeros(Context context){
        super(context,nombreBD,factory,version);
    }

    public MiBDCajeros(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, String sqlCreacionTablaCajeros) {
        super(context, name, factory, version);
        this.sqlCreacionTablaCajeros = sqlCreacionTablaCajeros;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreacionTablaCajeros);
        db.execSQL(sqlIndiceNombreCajeros);
        db.execSQL("INSERT INTO " + Constantes.CAJEROS_TABLE + " (rowid, " + Constantes.FIELD_CAJEROS_ID + "," + Constantes.FIELD_DIRECCION + "," + Constantes.FIELD_LAT + "," + Constantes.FIELD_LNG + "," + Constantes.FIELD_ZOOM + ") VALUES (null,null,'Carrer del Clariano, 1, 46021 Valencia, Valencia, España',39.47600769999999,-0.3524475000000393,'');");
        db.execSQL("INSERT INTO " + Constantes.CAJEROS_TABLE + " (rowid, " + Constantes.FIELD_CAJEROS_ID + "," + Constantes.FIELD_DIRECCION + "," + Constantes.FIELD_LAT + "," + Constantes.FIELD_LNG + "," + Constantes.FIELD_ZOOM + ") VALUES (null,null,'Avinguda del Cardenal Benlloch, 65, 46021 València, Valencia, España',39.4710366,-0.3547525000000178,'');");
        db.execSQL("INSERT INTO " + Constantes.CAJEROS_TABLE + " (rowid, " + Constantes.FIELD_CAJEROS_ID + "," + Constantes.FIELD_DIRECCION + "," + Constantes.FIELD_LAT + "," + Constantes.FIELD_LNG + "," + Constantes.FIELD_ZOOM + ") VALUES (null,null,'Av. del Port, 237, 46011 València, Valencia, España',39.46161999999999,-0.3376299999999901,'');");
        db.execSQL("INSERT INTO " + Constantes.CAJEROS_TABLE + " (rowid, " + Constantes.FIELD_CAJEROS_ID + "," + Constantes.FIELD_DIRECCION + "," + Constantes.FIELD_LAT + "," + Constantes.FIELD_LNG + "," + Constantes.FIELD_ZOOM + ") VALUES (null,null,'Carrer del Batxiller, 6, 46010 València, Valencia, España',39.4826729,-0.3639118999999482,'');");
        db.execSQL("INSERT INTO " + Constantes.CAJEROS_TABLE + " (rowid, " + Constantes.FIELD_CAJEROS_ID + "," + Constantes.FIELD_DIRECCION + "," + Constantes.FIELD_LAT + "," + Constantes.FIELD_LNG + "," + Constantes.FIELD_ZOOM + ") VALUES (null,null,'Av. del Regne de València, 2, 46005 València, Valencia, España',39.4647669,-0.3732760000000326,'');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
