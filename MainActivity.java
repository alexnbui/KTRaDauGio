package com.example.testdaugio;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Initialize UI elements
        EditText etWeight = findViewById(R.id.etWeight);
        Button btnConvert = findViewById(R.id.btnConvert);
        TextView tvResult = findViewById(R.id.tvResult);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
// Set click listener for the convert button
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightStr = etWeight.getText().toString();
                if (!weightStr.isEmpty()) {
                    try {
                        double weight = Double.parseDouble(weightStr);
                        double result = weight * 2.20462; // Conversion factor: 1 kilo = 2.20462 pounds
                        tvResult.setText(String.format("%.2f", result));
                    } catch (NumberFormatException e) {
                        tvResult.setText("Please enter a valid number");
                    }
                } else {
                    tvResult.setText("Please enter a weight");
                }
            }
        });
    }
}