package br.com.maiconbotelho.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textViewResultado = findViewById(R.id.textViewResultado);
    }

    public void calcular(View view){

        //recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar campos
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if ( camposValidados ){

            //Converter string para números
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            //Fazer cálculo de menor preço
            Double resultado = valorAlcool / valorGasolina;
            if ( resultado >= 0.7){
                textViewResultado.setText("Melhor utilizar Gasolina");

            }else {
                textViewResultado.setText("Melhor utilizar Álcool");
            }

        }else {
            textViewResultado.setText("Preencha os preços primeiro!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;
        if( pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
            Toast.makeText(this, "Favor preencher campo Álcool", Toast.LENGTH_SHORT).show();

        } else if ( pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
            Toast.makeText(this, "Favor preencher campo Gasolina", Toast.LENGTH_SHORT).show();
        }
        return camposValidados;
    }
}