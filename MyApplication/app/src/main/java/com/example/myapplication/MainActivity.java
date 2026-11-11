package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button buttonZero;
    private Button buttonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.show_count);
        buttonZero = findViewById(R.id.button_zero);
        buttonCount = findViewById(R.id.button_count);

        if (buttonZero != null) {
            buttonZero.setBackgroundColor(Color.GRAY);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void showToast(View view) {
        Toast.makeText(this, "TOAST", Toast.LENGTH_SHORT).show();
    }

    public void showCount(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }

        if (buttonCount != null) {
            if (mCount % 2 == 1) {
                buttonCount.setBackgroundColor(Color.GREEN);
            } else {
                buttonCount.setBackgroundColor(Color.BLUE);
            }
        }

        if (buttonZero != null) {
            buttonZero.setBackgroundColor(Color.parseColor("#FFA500"));
        }
    }

    public void showZero(View view) {
        mCount = 0;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
        if (buttonZero != null) {
            buttonZero.setBackgroundColor(Color.GRAY);
        }
        if (buttonCount != null) {
            buttonCount.setBackgroundColor(Color.BLUE);
        }
    }
}