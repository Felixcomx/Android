package br.com.soufelix.minhacaderneta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


/**
 * Created by Jose on 11/06/2016.
 */
public class DBManager {
    private SQLiteDatabase db;
    private DBHelper dbHelper;




    public DBManager(Context context) {

        dbHelper = new DBHelper(context);

    }


    public String insereDado(String descricao, String categoria, String tipo , String frequencia, String valor) {

        ContentValues valores;
        long resultado;

        db = dbHelper.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DBHelper.DESCRICAO, descricao);
        valores.put(DBHelper.VALOR, valor);
        valores.put(DBHelper.TIPO, tipo);
        valores.put(DBHelper.FREQUENCIA, frequencia);
        valores.put(DBHelper.CATEGORIA, categoria);



        resultado = db.insert(DBHelper.TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";

        return "Registro Inserido com sucesso";
    }


    public ArrayList<String> getregistros() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String sql = "SELECT tipo, descricao, categoria, valor FROM registros";

        Cursor cursor = db.rawQuery(sql, null);

        ArrayList<String> registros = null;

        if (cursor != null && cursor.moveToFirst()) {
            registros = new ArrayList<String>();
            do {
                registros.add("( " + cursor.getString(0) +" ) "+ cursor.getString(1)+ " R$ " + cursor.getString(2)+ " - " + cursor.getString(3));
            } while (cursor.moveToNext());
        }
        return registros;
    }


    public void deletarRegistros(int id){
        String where = DBHelper.ID + "=" + id;
        db = dbHelper.getReadableDatabase();
        db.delete(DBHelper.TABELA,where,null);
        db.close();
    }

}


