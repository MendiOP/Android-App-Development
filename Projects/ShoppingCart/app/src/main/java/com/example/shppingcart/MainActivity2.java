package com.example.shppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.PrivateKey;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_APPLE = "com.example.shppingcart.extra.APPLE";
    public static final String EXTRA_BANANA= "com.example.shppingcart.extra.BANANA";
    public static final String EXTRA_JACKFRUIT = "com.example.shppingcart.extra.JACKFRUIT";
    public static final String EXTRA_MANGO = "com.example.shppingcart.extra.MANGO";
    public static final String EXTRA_WATERMELON = "com.example.shppingcart.extra.WATERMELON";

    private Button apple, banana, jackfruit, mango, watermelon;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        apple = findViewById(R.id.apple);
        banana = findViewById(R.id.Banana);
        jackfruit = findViewById(R.id.JackFruite);
        mango = findViewById(R.id.Mango);
        watermelon = findViewById(R.id.WaterMelon);
    }

    public void setApple(View view)
    {
        String name = apple.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_APPLE, name);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void setBanana(View view)
    {
        String name = banana.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_BANANA, name);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void setJackfruit(View view)
    {
        String name = jackfruit.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_JACKFRUIT, name);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void setWatermelon(View view)
    {
        String name = watermelon.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_WATERMELON, name);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void setMango(View view)
    {
        String name = mango.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_MANGO, name);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}