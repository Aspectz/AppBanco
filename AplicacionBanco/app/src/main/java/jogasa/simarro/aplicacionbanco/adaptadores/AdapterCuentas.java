package jogasa.simarro.aplicacionbanco.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.pojo.Cuenta;
import jogasa.simarro.aplicacionbanco.pojo.Cuentas;
import jogasa.simarro.aplicacionbanco.pojo.DialogoMovimientos;

public class AdapterCuentas extends ArrayAdapter<Cuenta> {

    Activity context;
    ArrayList<Cuenta> cuentas;
    FragmentManager fragmentManager;

    public AdapterCuentas(Fragment context, ArrayList<Cuenta> cuentas){
        super(context.getActivity(),R.layout.activity_cuentas_adapter,cuentas);
        this.context=context.getActivity();
        this.cuentas=cuentas;
    }
    public View getView(int posicion, View convertView, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        View item=inflater.inflate(R.layout.activity_cuentas_adapter,null);
        TextView cuentaNumtxt=(TextView)item.findViewById(R.id.text1);
        cuentaNumtxt.setText(cuentas.get(posicion).getNumeroCuenta());
        TextView cuentaSaldotxt=(TextView)item.findViewById(R.id.text2);
        cuentaSaldotxt.setText(String.valueOf(cuentas.get(posicion).getSaldoActual()));
        if(cuentas.get(posicion).getSaldoActual()>0){
            cuentaSaldotxt.setTextColor(ContextCompat.getColor(getContext(),R.color.textGreen));
        }else{
            cuentaSaldotxt.setTextColor(ContextCompat.getColor(getContext(),R.color.textRed));
        }

        return (item);

    }








    /*public AdapterCuentas(Context context, List<T> objects) {
        super(context, 0,objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listItemView=convertView;
        if(null==convertView){
            listItemView=inflater.inflate(
                    R.layout.activity_cuentas_adapter,
                    parent,
                    false);
        }
       TextView cuentaNumtxt=(TextView)listItemView.findViewById(R.id.text1);
        TextView cuentaSaldotxt=(TextView)listItemView.findViewById(R.id.text2);
        Cuenta item=(Cuenta)getItem(position);
       cuentaNumtxt.setText("Nº Cuenta:"+item.getNumeroCuenta());
       cuentaSaldotxt.setText(String.valueOf(item.getSaldoActual()));
       if(item.getSaldoActual()>0){
           cuentaSaldotxt.setTextColor(ContextCompat.getColor(getContext(),R.color.textGreen));
       }else{
           cuentaSaldotxt.setTextColor(ContextCompat.getColor(getContext(),R.color.textRed));
       }

        return listItemView;
    }*/

}
