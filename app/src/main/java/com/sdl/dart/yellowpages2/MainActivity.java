package com.sdl.dart.yellowpages2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String CHECK = "com.sdl.dart.yellowpages2.DatabaseHandler";
    Button btnAddUser, btnLogin, btnfgp;
    DatabaseHandler db;
    private String TAG = "UserInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        //  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //   fab.setOnClickListener(new View.OnClickListener() {
        /*    @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        db = new DatabaseHandler(this);

        btnAddUser = (Button) findViewById(R.id.button6);
        btnLogin = (Button) findViewById(R.id.button4);
        btnfgp = (Button) findViewById(R.id.button5);
        //btnDeleteInfo = (Button) findViewById(R.id.btnDeleteInfo);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddUserDialog dialog = new AddUserDialog();
                dialog.show(getFragmentManager(), TAG);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(v.getContext(),Choice.class);
            EditText editText = (EditText) findViewById(R.id.editText3);
            EditText editText2 = (EditText) findViewById(R.id.editText4);
            String message = editText.getText().toString();
            String message2 = editText2.getText().toString();
            intent.putExtra(message,message2);
startActivity(intent);



        }
        });}

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

    public void login(View view) {
        Intent intent = new Intent(this, DatabaseHandler.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(CHECK, message);
        EditText pass = (EditText) findViewById(R.id.editText);
        String message2 = pass.getText().toString();
        intent.putExtra(CHECK, message2);
        startActivity(intent);


    }

}
