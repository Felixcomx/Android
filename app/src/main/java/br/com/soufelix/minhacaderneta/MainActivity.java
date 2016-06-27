package br.com.soufelix.minhacaderneta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button despesasActivity = (Button) findViewById(R.id.btDespesa);
        despesasActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity2 = new Intent(MainActivity.this, Despesas.class);
                startActivityForResult(Activity2, 1);

            }
        });


        Button receitaActivity = (Button) findViewById(R.id.btReceita);
        receitaActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity1 = new Intent(MainActivity.this, Receita.class);
                startActivityForResult(Activity1, 1);

            }
        });

        Button regitroActivity = (Button) findViewById(R.id.btRegistros);
        regitroActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity3 = new Intent(MainActivity.this, registros.class);
                startActivityForResult(Activity3, 1);

            }
        });
//

        ArrayList<String> itens = null;
        DBManager dbManager = new DBManager(this);

        itens = dbManager.getregistros();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);
        ListView listView = (ListView) findViewById(R.id.listViewDesp2);
        if (itens != null) {
            listView.setAdapter(adapter);
        }



        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }


        });


    }
}
