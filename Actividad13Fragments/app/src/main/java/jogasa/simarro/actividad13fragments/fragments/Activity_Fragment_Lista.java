package jogasa.simarro.actividad13fragments.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

import jogasa.simarro.actividad13fragments.R;
import jogasa.simarro.actividad13fragments.adaptador.AdaptadorDiscos;
import jogasa.simarro.actividad13fragments.pojo.Cancion;
import jogasa.simarro.actividad13fragments.pojo.Disco;

public class Activity_Fragment_Lista extends Fragment implements AdapterView.OnItemClickListener {
    private ArrayList<Disco> discos=new ArrayList<Disco>();
    private ArrayList canciones=new ArrayList();
    private ArrayList canciones1=new ArrayList();
    private ArrayList canciones2=new ArrayList();
    private DiscosListener discosListener;
    private ListView cancionesList;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_lista, container, false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cancionesList=(ListView)getView().findViewById(R.id.LstListado);
        canciones.add(new Cancion("Cancion 1","1 minuto","rock"));
        canciones.add(new Cancion("Cancion 1.2","2 minuto","pop"));
        canciones1.add(new Cancion("Cancion 1.3","6 minuto","clasica"));
        canciones1.add(new Cancion("Cancion 1.4","10 minuto","reggaaton"));
        canciones2.add(new Cancion("Cancion 1.5","3 minuto","electronica"));
        canciones2.add(new Cancion("Cancion 1.6","4 minuto","hardstyle"));
        discos.add(new Disco("Disco 1","Grupo1",canciones));
        discos.add(new Disco("Disco 2","Grupo1",canciones1));
        discos.add(new Disco("Disco 3","Grupo1",canciones2));

       cancionesList.setAdapter(new AdaptadorDiscos(this,discos));

        cancionesList.setOnItemClickListener(this);
    }
    public void setDiscosListener(DiscosListener listener){
        this.discosListener=listener;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(discosListener!=null){
            discosListener.onDiscoSeleccionado((Disco)cancionesList.getAdapter().getItem(position));
        }
    }

}
