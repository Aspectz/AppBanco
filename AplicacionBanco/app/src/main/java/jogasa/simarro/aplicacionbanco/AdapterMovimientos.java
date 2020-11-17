package jogasa.simarro.aplicacionbanco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import jogasa.simarro.aplicacionbanco.pojo.Movimiento;

public class AdapterMovimientos<T> extends ArrayAdapter {

    public AdapterMovimientos(Context context, List<T> objects) {
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
    }

}