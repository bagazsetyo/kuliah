package com.example.belajar_android_sturio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME = "apotek.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_OBAT = "obat";
    private static final String TABLE_TRANSAKSI = "transaksi";
    private static final String TABLE_PELANGGAN = "pelanggan";
    private static final String TABLE_STOK = "stok";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_NAME = "name";

    private static final String COLUMN_TRANSACTION_ID = "transaction_id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TOTAL = "total";

    private static final String COLUMN_CUSTOMER_ID = "customer_id";
    private static final String COLUMN_CUSTOMER_NAME = "customer_name";
    private static final String COLUMN_ADDRESS = "address";

    private static final String COLUMN_STOCK_ID = "stock_id";
    private static final String COLUMN_QUANTITY = "quantity";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableObat = "CREATE TABLE " + TABLE_OBAT + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_NAME + " TEXT)";

        String createTableTransaksi = "CREATE TABLE " + TABLE_TRANSAKSI + " (" +
                COLUMN_TRANSACTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_TOTAL + " REAL)";

        String createTablePelanggan = "CREATE TABLE " + TABLE_PELANGGAN + " (" +
                COLUMN_CUSTOMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CUSTOMER_NAME + " TEXT, " +
                COLUMN_ADDRESS + " TEXT)";

        String createTableStok = "CREATE TABLE " + TABLE_STOK + " (" +
                COLUMN_STOCK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_QUANTITY + " INTEGER)";

        db.execSQL(createTableObat);
        db.execSQL(createTableTransaksi);
        db.execSQL(createTablePelanggan);
        db.execSQL(createTableStok);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop tables if they exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OBAT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSAKSI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PELANGGAN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STOK);

        // Recreate tables
        onCreate(db);
    }
}
