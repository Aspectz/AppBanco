package jogasa.simarro.aplicacionbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Transferencias extends AppCompatActivity {
    private GridView grdOpciones;
    private RadioButton ownAcc,otherAcc;
    private Spinner listaCuentas,divisas;
    private EditText recipientAcc,amountTransfer;
    private Button btnOk,btnCancel;
    private CheckBox receiptCheck;
    private String gridText,listaText,divisaText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tranferencias);
        ownAcc=(RadioButton)findViewById(R.id.ownAcc);
        otherAcc=(RadioButton)findViewById(R.id.otherAcc);
        listaCuentas=(Spinner)findViewById(R.id.spinnerOwn);
        divisas=(Spinner)findViewById(R.id.spinnerTypeMoney);
        grdOpciones=(GridView)findViewById(R.id.gridOpciones);
        recipientAcc=(EditText)findViewById(R.id.recipientAcc);
        btnOk=(Button)findViewById(R.id.btnSend);
        amountTransfer=(EditText)findViewById(R.id.amountTransfer);
        btnCancel=(Button)findViewById(R.id.btnCancel);
        receiptCheck=(CheckBox)findViewById(R.id.receiptCheck);

        String cuentas[]=new String[]{"ES0000000001","ES0000000002","ES0000000003","ES0000000004"};
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


        ownAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               listaCuentas.setVisibility(View.VISIBLE);
                recipientAcc.setVisibility(View.INVISIBLE);

            }
        });
        otherAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaCuentas.setVisibility(View.INVISIBLE);
                recipientAcc.setVisibility(View.VISIBLE);
            }
        });
        //BOTONES
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked=receiptCheck.isChecked();
                String amountText=amountTransfer.getText().toString();
                String numAcc=recipientAcc.getText().toString();
                if(ownAcc.isChecked()){
                    Toast.makeText(Transferencias.this, "Cuenta origen:"+gridText+",Cuenta destino:"+listaText+",Cantidad:"+amountText+",Divisa:"+divisaText+",Recibo:"+checked, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Transferencias.this, "Cuenta origen:"+gridText+",Cuenta destino:"+numAcc+",Cantidad:"+amountText+",Divisa:"+divisaText+",Recibo:"+checked, Toast.LENGTH_SHORT).show();
                }


            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaCuentas.setVisibility(View.INVISIBLE);
                recipientAcc.setVisibility(View.INVISIBLE);
                ownAcc.setChecked(false);
                otherAcc.setChecked(false);
                recipientAcc.setText("");
                amountTransfer.setText("");
                //grdOpciones.getselec
                //divisas.setAdapter();
                receiptCheck.setChecked(false);
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