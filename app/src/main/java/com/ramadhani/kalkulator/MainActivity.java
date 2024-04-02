package com.ramadhani.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Deklarasi variabel untuk komponen UI
    private EditText nilaiAEditText, nilaiBEditText, hasilEditText;
    private RadioGroup leftRadioGroup, rightRadioGroup;
    private RadioButton tambahRadioButton, kurangRadioButton, kaliRadioButton, bagiRadioButton;
    private Button hitungButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen UI
        nilaiAEditText = findViewById(R.id.nilaiAEditText);
        nilaiBEditText = findViewById(R.id.nilaiBEditText);
        hasilEditText = findViewById(R.id.hasilEditText);

        leftRadioGroup = findViewById(R.id.LeftRadioGroup);
        rightRadioGroup = findViewById(R.id.RightRadioGroup);

        tambahRadioButton = findViewById(R.id.tambah);
        kurangRadioButton = findViewById(R.id.kurang);
        kaliRadioButton = findViewById(R.id.Kali);
        bagiRadioButton = findViewById(R.id.Bagi);

        Button hitungButton = findViewById(R.id.hitungButton);

        // Menambahkan listener ke tombol hitung
        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){ hitungOperasi(); }
        });
    }

    private void hitungOperasi(){
        // Get values from EditTexts
        String nilaiAString = nilaiAEditText.getText().toString();
        String nilaiBString = nilaiBEditText.getText().toString();

        // Check if any of the EditTexts is empty
        if (nilaiAString.isEmpty()) {
            Toast.makeText(this, "Nilai A Kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        if (nilaiBString.isEmpty()) {
            Toast.makeText(this, "Nilai B Kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        // Parse values to double
        double nilaiA = Double.parseDouble(nilaiAString);
        double nilaiB = Double.parseDouble(nilaiBString);

        // Perform calculation based on selected operation
        double hasil = 0;

        // Check which operation is selected
        if (tambahRadioButton.isChecked()) {
            hasil = nilaiA + nilaiB;
        } else if (kurangRadioButton.isChecked()) {
            hasil = nilaiA - nilaiB;
        } else if (kaliRadioButton.isChecked()) {
            hasil = nilaiA * nilaiB;
        } else if (bagiRadioButton.isChecked()) {
            if (nilaiB != 0) {
                hasil = nilaiA / nilaiB;
            } else {
                Toast.makeText(this, "tidak bisa dibagi dengan 0", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // display the result
        hasilEditText.setText(String.valueOf(hasil));
    }
}