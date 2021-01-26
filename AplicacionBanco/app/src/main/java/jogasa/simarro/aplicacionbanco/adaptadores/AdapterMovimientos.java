package jogasa.simarro.aplicacionbanco.adaptadores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.pojo.Movimiento;

public class AdapterMovimientos extends ArrayAdapter {


    Activity context;
    ArrayList<Movimiento> movimientos;

    public AdapterMovimientos(Fragment context, ArrayList<Movimiento> movimientos) {
        super(context.getActivity(),R.layout.activity_adapter_movimientos,movimientos);
        this.context=context.getActivity();
        this.movimientos=movimientos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View item=inflater.inflate(R.layout.activity_adapter_movimientos,null);
        TextView cuentaOrigentxt=(TextView)item.findViewById(R.id.text1);
        TextView importeTxt=(TextView)item.findViewById(R.id.text2);
        TextView cuentaDestinotxt=(TextView)item.findViewById(R.id.text3);
        TextView descripcionOperacion=(TextView)item.findViewById(R.id.text4);
        TextView fechaTxt=(TextView)item.findViewById(R.id.text5);


        cuentaOrigentxt.setText("Cuenta origen :"+movimientos.get(position).getCuentaOrigen().getNumeroCuenta());
        cuentaDestinotxt.setText("Cuenta destino: "+movimientos.get(position).getCuentaDestino().getNumeroCuenta());
        importeTxt.setText("Importe: "+movimientos.get(position).getImporte());
        descripcionOperacion.setText("Descripcion "+movimientos.get(position).getDescripcion());
        fechaTxt.setText("Fecha Operacion: "+movimientos.get(position).getFechaOperacion());


        return item;
    }

    /*public AdapterMovimientos(Context context, List<T> objects) {
        super(context, 0,objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listItemView=convertView;
        if(null==convertView){
            listItemView=inflater.inflate(
                    R.layout.activity_adapter_movimientos,
                    parent,
                    false);
        }
        TextView cuentaOrigentxt=(TextView)listItemView.findViewById(R.id.text1);
        TextView importeTxt=(TextView)listItemView.findViewById(R.id.text2);
        TextView cuentaDestinotxt=(TextView)listItemView.findViewById(R.id.text3);
        TextView fechaTxt=(TextView)listItemView.findViewById(R.id.text4);
        Movimiento item=(Movimiento)getItem(position);

        cuentaOrigentxt.setText("Cuenta origen :"+item.getCuentaOrigen().getNumeroCuenta());
        cuentaDestinotxt.setText("Cuenta destino: "+item.getCuentaDestino().getNumeroCuenta());
        importeTxt.setText("Importe: "+item.getImporte());
        fechaTxt.setText("Fecha Operacion: "+item.getFechaOperacion().toString());

        return listItemView;
    }*/
}