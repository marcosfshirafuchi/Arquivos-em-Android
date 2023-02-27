package com.marcosfshirafuchi.exercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.marcosfshirafuchi.exercicio2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.txtPrimeiraTela.setText("Primeira Tela");

        binding.btNavegarParaTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegarParaTela2 = new Intent(MainActivity.this,SegundaTela.class);
                startActivity(navegarParaTela2);
            }
        });
    }
}