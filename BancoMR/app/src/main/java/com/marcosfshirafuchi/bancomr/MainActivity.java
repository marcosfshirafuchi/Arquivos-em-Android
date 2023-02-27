package com.marcosfshirafuchi.bancomr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.marcosfshirafuchi.bancomr.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navegarTelaDeSaldo = new Intent(MainActivity.this,Saldo.class);
                startActivity(navegarTelaDeSaldo);

            }
        });

        binding.imgFaturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegarTelaDeFaturas = new Intent(MainActivity.this,Faturas.class);
                startActivity(navegarTelaDeFaturas);

            }
        });

        binding.imgTransferencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegarTelaDeTransferencia = new Intent(MainActivity.this,Transferencia.class);
                startActivity(navegarTelaDeTransferencia);
            }
        });

        binding.imgPoupanca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegarTelaDePoupanca = new Intent(MainActivity.this,Poupanca.class);
                startActivity(navegarTelaDePoupanca);
            }
        });
    }
}