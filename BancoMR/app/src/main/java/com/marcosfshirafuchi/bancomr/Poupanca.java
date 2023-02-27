package com.marcosfshirafuchi.bancomr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.marcosfshirafuchi.bancomr.databinding.ActivityPoupancaBinding;

public class Poupanca extends AppCompatActivity {

    private ActivityPoupancaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPoupancaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.toolbarPoupanca.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltarTelaPrincipal = new Intent(Poupanca.this,MainActivity.class);
                startActivity(voltarTelaPrincipal);
            }
        });
    }
}