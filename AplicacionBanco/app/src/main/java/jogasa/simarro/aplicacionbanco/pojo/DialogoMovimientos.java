package jogasa.simarro.aplicacionbanco.pojo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;

import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.bd.MiBancoOperacional;

public class DialogoMovimientos extends DialogFragment {
    @NonNull
    public Movimiento movimiento;
    public TextView texto;
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View layout=inflater.inflate(R.layout.layout_dialogfragment,null);

        texto=(TextView)layout.findViewById(R.id.textDialog);
        texto.setText(movimiento.toString());
        builder.setView(layout)
                .setTitle("MOVIMIENTO").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }

}
