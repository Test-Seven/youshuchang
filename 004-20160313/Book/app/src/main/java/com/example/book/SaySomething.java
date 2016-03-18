package com.example.book;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class SaySomething extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button clickme = (Button) this.findViewById(R.id.Botton1);
        clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MyTag", "onClick");
                Intent intent = new Intent();
                intent.setClass(SaySomething.this, ListenSomthing.class);
                startActivity(intent);

            }
        });
    }
}

