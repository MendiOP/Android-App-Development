package com.example.shppingcart;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int ITEM_REQUEST = 1;

    private TextView first, second, third, fourth, fifth;
    private Button addButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        fourth = findViewById(R.id.fourth);
        fifth = findViewById(R.id.fifth);
        addButton = findViewById(R.id.addButton);

    }
    public void goSecond(View view)
    {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivityForResult(intent, ITEM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ITEM_REQUEST)
        {
            if(resultCode == RESULT_OK)
            {
                String name ="no selected";
                String[] strings = {MainActivity2.EXTRA_APPLE, MainActivity2.EXTRA_BANANA, MainActivity2.EXTRA_MANGO, MainActivity2.EXTRA_JACKFRUIT, MainActivity2.EXTRA_WATERMELON};
                for(String s : strings)
                    if(data.getStringExtra(s) != null) {
                        name = data.getStringExtra(s);
                        break;
                    }
                
                TextView tempView = null;
                TextView[] views = {first, second, third, fourth, fifth};
                for(TextView view : views)
                {
                    if(view.getText().toString().equals("TextView"))
                    {
                        tempView = view;
                        break;
                    }
                }

                if(!fifth.getText().toString().equals("TextView")) {
                    Toast.makeText(this, "Items are full!", Toast.LENGTH_SHORT).show();
                }
                else
                    tempView.setText(name);

            }
        }
    }
}