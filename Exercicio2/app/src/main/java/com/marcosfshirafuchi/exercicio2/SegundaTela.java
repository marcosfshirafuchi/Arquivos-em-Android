package com.marcosfshirafuchi.exercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.marcosfshirafuchi.exercicio2.databinding.ActivitySegundaTelaBinding;

public class SegundaTela extends AppCompatActivity {

    private ActivitySegundaTelaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySegundaTelaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btNavegarParaTela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltarParaPrimeiraTela = new Intent(SegundaTela.this,MainActivity.class);
                startActivity(voltarParaPrimeiraTela);
            }
        });
    }
}