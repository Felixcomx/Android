package br.com.soufelix.minhacaderneta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Jose on 11/06/2016.
 */

public class DBHelper extends SQLiteOpenHelper {


    private static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "registros";
    public static final String ID = "_id";
    public static final String DESCRICAO = "descricao";
    public static final String CATEGORIA = "categoria";
    public static final String TIPO = "tipo";
    public static final String FREQUENCIA = "frequencia";
    public static final String VALOR = ("valor");
    private static final int VERSAO = 3;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + DESCRICAO + " text,"
                + VALOR + " text,"
                + TIPO + " text,"
                + FREQUENCIA + " text,"
                + CATEGORIA + " text" +")";

        db.execSQL(sql);

    }

    public DBHelper(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);

    }


}
