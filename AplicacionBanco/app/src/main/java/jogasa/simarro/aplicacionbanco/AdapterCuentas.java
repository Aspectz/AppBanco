package jogasa.simarro.aplicacionbanco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.util.List;

import jogasa.simarro.aplicacionbanco.pojo.Cuenta;

public class AdapterCuentas<T> extends ArrayAdapter {

    public AdapterCuentas(Context context, List<T> objects) {
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
    }

}
