package com.example.hoegaarden1917.jankenpon;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer ;


public class JankenActivity extends Activity implements View.OnClickListener {

    ImageView mImage ;
    TextView mText ;
    Button button_next ;
    int mItemNo = 0 ;

    int image_id_table[][] = {
            { R.drawable.character1_0,R.drawable.character1_1,R.drawable.character1_2 },
            { R.drawable.character2_0,R.drawable.character2_1,R.drawable.character2_2 },
            { R.drawable.character3_0,R.drawable.character3_1,R.drawable.character3_2 },
            { R.drawable.character4_0,R.drawable.character4_1,R.drawable.character4_2 },
    } ;
    int janken_id_table[] =
            { R.drawable.rock,R.drawable.scissors,R.drawable.paper } ;

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_janken);

        mItemNo = getIntent().getExtras().getInt("ITEM",0) ;
        Log.d("ITEM_NO",Integer.toString(mItemNo)) ;

        mp = MediaPlayer.create(this, R.raw.jankenpon);

        mImage = (ImageView)findViewById(R.id.image_janken) ;
        mImage.setImageResource(image_id_table[mItemNo][0]);

        mText = (TextView)findViewById(R.id.text_janken) ;
        button_next = (Button) findViewById(R.id.button_next);
        button_next.setOnClickListener(this);
        button_next.setVisibility(View.GONE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                doJanken();
            }
        }, 3000);

    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_next :
                Intent intent = new Intent(this, EndingActivity.class);
//                intent.putExtra("QUIZLIST",table) ;
                startActivity(intent);
                break;
        }
    }

    private void doJanken() {

        mp.start();
        mImage.setImageResource(image_id_table[mItemNo][1]);
        mText.setText("じゃんけん");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                doPon();
            }
        }, 2000);
    }

    private void doPon() {
        Random r = new Random();
        int janken = r.nextInt(3);

        mImage.setImageResource(janken_id_table[janken]);
        mText.setText("ぽん！");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                doAsk() ;
                Log.d("Hello", "Hello");
             }
        }, 3000);
    }

    private void doAsk() {
        mImage.setImageResource(image_id_table[mItemNo][2]);
        mText.setText("かったかな～？");

        button_next.setVisibility(View.VISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_janken, menu);
        return true;
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
