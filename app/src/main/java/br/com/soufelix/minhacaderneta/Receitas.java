package br.com.soufelix.minhacaderneta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Receitas extends AppCompatActivity {
    Spinner categoria;
    private String descricao;
    private String valor;
    private String tipo;
    private  String frequencia;
    private long id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receita);


        Button cancelarActivity = (Button) findViewById(R.id.btVoltar);
        cancelarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity4 = new Intent(Receitas.this, MainActivity.class);
                startActivityForResult(Activity4, 1);
                finish();
            }
        });

        categoria =(Spinner)findViewById(R.id.rcCategoria);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.categoria_receitas, android.R.layout.simple_spinner_dropdown_item);
        categoria.setAdapter(adapter);

    }

    public void cliquebotao(View view){
        DBManager crud = new DBManager(getBaseContext());

        EditText descRecB = (EditText)findViewById(R.id.editTextDescRec);
        EditText valRecB = (EditText)findViewById((R.id.editTextValRec));
        String descRec = descRecB.getText().toString();
        String valRec = valRecB.getText().toString();
        String frequencia = "";
        String tipRec = " + ";
        Spinner catRec = (Spinner) findViewById(R.id.rcCategoria);


        String resultado;

        resultado = crud.insereDado(descRec,valRec,tipRec, frequencia, String.valueOf(catRec.getSelectedItem()));
        // voltar a tela inicial apos gravar
        Intent Activity3 = new Intent(Receitas.this, MainActivity.class);
        startActivityForResult(Activity3, 1);

        // Exibe mensagem na tela de registro inserido com sucesso ou não.
        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();


    }

}
