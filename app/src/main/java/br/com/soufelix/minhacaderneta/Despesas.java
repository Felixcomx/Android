package br.com.soufelix.minhacaderneta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Despesas extends AppCompatActivity {

    Spinner categoria;
    private String descricao;
    private String valor;
    private String tipo;
    private String frequencia;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesas);

        Button cancelarActivity = (Button) findViewById(R.id.btVoltar);
        cancelarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity3 = new Intent(Despesas.this, MainActivity.class);
                startActivityForResult(Activity3, 1);
                finish();


            }
        });


        categoria =(Spinner)findViewById(R.id.dpCategoria);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.categoria_despesas, android.R.layout.simple_spinner_dropdown_item);
        categoria.setAdapter(adapter);

    }

    public void cliquebotao(View view){
        DBManager crud = new DBManager(getBaseContext());

        EditText descDespB = (EditText)findViewById(R.id.editTextDescDesp);
        EditText valDespB = (EditText)findViewById((R.id.editTextValDesp));
        String descDesp = descDespB.getText().toString();
        String valDesp = valDespB.getText().toString();
        String tipDesp = " - ";
        String frequencia = "";
        Spinner catDesp = (Spinner) findViewById(R.id.dpCategoria);

        String resultado;

        resultado = crud.insereDado(descDesp,valDesp,tipDesp, frequencia, String.valueOf(catDesp.getSelectedItem()));
// voltar a tela inicial apos gravar
        Intent Activity3 = new Intent(Despesas.this, MainActivity.class);
        startActivityForResult(Activity3, 1);

// Exibe mensagem na tela de registro inserido com sucesso ou não.
        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
    }



    }

