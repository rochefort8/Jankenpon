package com.example.hoegaarden1917.jankenpon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends Activity implements View.OnClickListener {

    ImageButton button_char1, button_char2, button_char3, button_char4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        button_char1 = (ImageButton) findViewById(R.id.button_char1);
        button_char1.setOnClickListener(this);
        button_char2 = (ImageButton) findViewById(R.id.button_char2);
        button_char2.setOnClickListener(this);
        button_char3 = (ImageButton) findViewById(R.id.button_char3);
        button_char3.setOnClickListener(this);
        button_char4 = (ImageButton) findViewById(R.id.button_char4);
        button_char4.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClick(View v) {
       int item = 0 ;

        switch (v.getId()) {
            case R.id.button_char1:
                item = 0;
                break;
            case R.id.button_char2:
                item = 1;
                break;
            case R.id.button_char3:
                item = 2;
                break;
            case R.id.button_char4:
                item = 3;
                break;
            default:
                item = 0;
                break;
        }
        Intent intent = new Intent(this, JankenActivity.class);
        intent.putExtra("ITEM",item) ;
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
}
