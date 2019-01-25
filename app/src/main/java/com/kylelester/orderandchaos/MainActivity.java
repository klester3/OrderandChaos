/*************
 Developer: Kyle Lester
 App: Order and Chaos
 Tested On: Pixel 2
 **************/
package com.kylelester.orderandchaos;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;
        button = findViewById(R.id.game_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToGame();
            }
        });

        button = findViewById(R.id.about_OC_button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                GoToWeb();
            }
        });

        button = findViewById(R.id.about_theApp_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToAbout();
            }
        });
    }

    private void GoToAbout() {
        Intent intent = new Intent(getApplicationContext(),
                AboutAppActivity.class);
        startActivity(intent);
    }

    private void GoToWeb() {
        Uri uri = Uri.parse("https://en.wikipedia.org/wiki/Order_and_Chaos");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void GoToGame() {
        Intent intent = new Intent(getApplicationContext(),
                GameActivity.class);
        startActivity(intent);
    }
}
