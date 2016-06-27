package br.com.soufelix.minhacaderneta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class registros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        ArrayList<String> itens = null;
        final DBManager dbManager = new DBManager(this);

        itens = dbManager.getregistros();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);
        final ListView listView = (ListView) findViewById(R.id.listViewRegistros);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }


        });


        Button cancelarActivity = (Button) findViewById(R.id.btVoltar);
        cancelarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity3 = new Intent(registros.this, MainActivity.class);
                startActivityForResult(Activity3, 1);
                finish();


            }
        });


    }
}


