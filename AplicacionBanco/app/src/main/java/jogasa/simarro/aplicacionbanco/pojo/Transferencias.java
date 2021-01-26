package jogasa.simarro.aplicacionbanco.pojo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import jogasa.simarro.aplicacionbanco.R;
import jogasa.simarro.aplicacionbanco.bd.MiBancoOperacional;

public class Transferencias extends AppCompatActivity {
    private GridView grdOpciones;
    private Spinner listaCuentas,divisas;
    private EditText amountTransfer;
    private Button btnOk,btnCancel;
    private CheckBox receiptCheck;
    private String gridText,listaText,divisaText;
    private Cliente recogido;
    private Cuenta cuentaOrigen,cuentaDestino;
    private MiBancoOperacional mbo;
    private int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tranferencias);
        listaCuentas=(Spinner)findViewById(R.id.spinnerOwn);
        divisas=(Spinner)findViewById(R.id.spinnerTypeMoney);
        grdOpciones=(GridView)findViewById(R.id.gridOpciones);
        btnOk=(Button)findViewById(R.id.btnSend);
        amountTransfer=(EditText)findViewById(R.id.amountTransfer);
        btnCancel=(Button)findViewById(R.id.btnCancel);
        receiptCheck=(CheckBox)findViewById(R.id.receiptCheck);
        mbo= MiBancoOperacional.getInstance(this);
        recogido=(Cliente)getIntent().getSerializableExtra("Cliente");
        final ArrayList<Cuenta> cuentasCliente=mbo.getCuentas(recogido);
        final ArrayList<String> cuentas=new ArrayList<String>();

        for(int i=0;i<cuentasCliente.size();i++){
            cuentas.add(cuentasCliente.get(i).getNumeroCuenta());
        }

        String divisasMoneda[]=new String[]{"EUR","DOLAR","RUBLOS","YENS","PESOS"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cuentas);
        ArrayAdapter<String> adaptadorMonedas =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, divisasMoneda);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        adaptadorMonedas.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        grdOpciones.setAdapter(adaptador);
        divisas.setAdapter(adaptadorMonedas);
        listaCuentas.setAdapter(adaptador);


        //BOTONES
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Cuenta cuenta : cuentasCliente){
                    if(cuenta.getNumeroCuenta()==gridText){
                        cuentaOrigen=cuenta;
                    }if(cuenta.getNumeroCuenta()==listaText){
                        cuentaDestino=cuenta;
                    }
                }
                id+=1;
                boolean checked=receiptCheck.isChecked();
                String amountText=amountTransfer.getText().toString();
                Date fecha= Calendar.getInstance().getTime();
                if(cuentaOrigen!=null && cuentaOrigen.getSaldoActual() >= Float.parseFloat(amountText) ){
                    Movimiento movimiento=new Movimiento(id, 0, fecha, "Descripcion del id "+id, Float.parseFloat(amountText), cuentaOrigen, cuentaDestino);
                    mbo.transferencia(movimiento);
                    amountTransfer.setText("");
                }else{
                    Toast.makeText(Transferencias.this, "No tienes suficiente dinero", Toast.LENGTH_SHORT).show();

                }



               // Toast.makeText(Transferencias.this, "Cuenta origen:"+gridText+",Cuenta destino:"+listaText+",Cantidad:"+amountText+",Divisa:"+divisaText+",Recibo:"+checked, Toast.LENGTH_SHORT).show();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaCuentas.setVisibility(View.INVISIBLE);
                amountTransfer.setText("");
                receiptCheck.setChecked(false);
                gridText="";
                divisaText="";

            }
        });

        //GET ITEMS
        grdOpciones.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent,
                                            android.view.View v, int position, long id) {
                    gridText=parent.getItemAtPosition(position).toString();


                }
    });

        listaCuentas.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        listaText=parent.getItemAtPosition(position).toString();

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        listaText="";
                    }
                });

        divisas.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        divisaText=parent.getItemAtPosition(position).toString();
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        divisaText="";
                    }
                });
}
}