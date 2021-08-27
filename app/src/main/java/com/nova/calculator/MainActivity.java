package com.nova.calculator;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements InputFragment.InputFragmentListener {
    public InputFragment inputFragment;
    public DisplayFragment resultFragment;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFragment = new InputFragment();
        resultFragment = new DisplayFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.calculator_container,
                inputFragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.result_container,
                resultFragment).commit();
    }

    @Override
    public void sendResult(String result) {
        resultFragment.updateResult(result);
    }
}