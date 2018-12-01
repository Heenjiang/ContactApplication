package com.example.zoey.contactapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import helper.ContactDBTable;
import helper.DBHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mName;
    private EditText mPhoneNumber;
    private Button mFindBt;
    private Button mSaveBt;
    private static String TAG = "mylog";
    private DBHelper mDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);

        mFindBt = findViewById(R.id.find_contact);
        mFindBt.setOnClickListener(this);

        mSaveBt = findViewById(R.id.save_contact);
        mSaveBt.setOnClickListener(this);

        mName = findViewById(R.id.text_name);
        mPhoneNumber = findViewById(R.id.text_phone_number);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void finish() {
        Log.d(TAG, "finish: ");
        super.finish();
    }

    @Override
    public void onClick(View v) {
        String name = mName.getText().toString();
        String phoneNumber = mPhoneNumber.getText().toString();
        switch (v.getId()){
            case R.id.find_contact:
                findContactByName(name);
                break;
            case R.id.save_contact:
                saveContactInDB(name, phoneNumber);
                break;
                default:
                    break;
        }

    }

    private void findContactByName(String name) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        Cursor cursor = db.query(ContactDBTable.TABLE_NAME,null,null, null,null,null,null);
        while(cursor.moveToNext()){
        }
    }


    private void saveContactInDB(String name, String phoneNumber) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        db.insert(ContactDBTable.TABLE_NAME,null, null);
    }

    private void clean(){
        mName.setText("");
        mPhoneNumber.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDBHelper.close();
    }
}
