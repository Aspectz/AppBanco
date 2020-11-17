package jogasa.simarro.actividad13fragments.adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import jogasa.simarro.actividad13fragments.R;
import jogasa.simarro.actividad13fragments.pojo.Cancion;
import jogasa.simarro.actividad13fragments.pojo.Disco;

public class AdaptadorCanciones extends ArrayAdapter {
    Activity context;
    ArrayList<Cancion> canciones;

    public AdaptadorCanciones(Fragment context, ArrayList<Cancion> canciones){
        super(context.getActivity(), R.layout.layout_elemento_lista_detalle,canciones);
        this.context=context.getActivity();
        this.canciones=canciones;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.layout_elemento_lista_detalle, null);
        TextView nombre = (TextView) item.findViewById(R.id.NombreCancion);
        nombre.setText(canciones.get(position).getNomCancion());
        TextView duracion = (TextView) item.findViewById(R.id.Duracion);
        duracion.setText(canciones.get(position).getDuracion());
        TextView tipo = (TextView) item.findViewById(R.id.Tipo);
        tipo.setText(canciones.get(position).getTipo());
        return (item);
    }
}
