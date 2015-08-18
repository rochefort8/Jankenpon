package com.example.hoegaarden1917.jankenpon;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =  new Intent(SplashActivity.this, MainActivity.class) ;
                startActivity(intent);
                finish();
            }
//        BeerDataDownloader beerDataDownloader = new BeerDataDownloader(getBaseContext()) ;
//		beerDataDownloader.Get() ;
        },3000);
    }
}
