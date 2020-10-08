package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Winner extends AppCompatActivity {
    TextView Status =null;
    Button retry=null;
    Bundle bund=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        final Intent next  = new Intent(Winner.this,MainActivity.class);
        next.putExtra("status",false);
        bund = getIntent().getExtras();
        Status = (TextView)findViewById(R.id.textView);
        Status.setText(bund.getString("value"));
        retry = (Button)findViewById(R.id.button_retry);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
