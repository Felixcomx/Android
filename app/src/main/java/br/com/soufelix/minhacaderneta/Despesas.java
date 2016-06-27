package br.com.soufelix.minhacaderneta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Despesas extends AppCompatActivity {

    private String descricao;
    private String categoria;
    private String valor;
    private String tipo;
    private String frequencia;
    private long id;

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

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


    }

    public void cliquebotao(View view){
        DBManager crud = new DBManager(getBaseContext());

        EditText descDespB = (EditText)findViewById(R.id.editTextDescDesp);
        EditText valDespB = (EditText)findViewById((R.id.editTextValDesp));
        EditText catDespB = (EditText)findViewById((R.id.editTextCatDesp));
        String descDesp = descDespB.getText().toString();
        String valDesp = valDespB.getText().toString();
        String tipDesp = " - ";
        String frequencia = "";
        String catDesp = catDespB.getText().toString();

        String resultado;

        resultado = crud.insereDado(descDesp,valDesp,tipDesp, frequencia, catDesp);
// voltar a tela inicial apos gravar
        Intent Activity3 = new Intent(Despesas.this, MainActivity.class);
        startActivityForResult(Activity3, 1);

// Exibe mensagem na tela de registro inserido com sucesso ou não.
        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio_Eventual:
                if (checked)
                    break;
            case R.id.radio_Frequente:
                if (checked)
                    break;
        }
    }

    }

