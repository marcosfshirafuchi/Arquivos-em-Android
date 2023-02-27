package com.marcosfshirafuchi.calculadoradeimc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.marcosfshirafuchi.calculadoradeimc.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String peso = binding.editPeso.getText().toString();
                String altura = binding.editAltura.getText().toString();

                if(peso.isEmpty()){
                    binding.editPeso.setError("Informe seu Peso!");
                }else if(altura.isEmpty()){
                    binding.editAltura.setError("Informe sua Altura!");
                }else{
                    calcularIMC();
                }
            }
        });
    }
    private void calcularIMC(){
        float peso = Float.parseFloat(binding.editPeso.getText().toString().replace(",","."));
        float altura = Float.parseFloat(binding.editAltura.getText().toString().replace(",","."));
        float imc = peso / (altura * altura);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        if(imc < 18.5){
            binding.txtResultado.setText("Seu IMC é " + decimalFormat.format(imc) + "\n" + "Peso Baixo");
        }else if(imc <= 24.9){
            binding.txtResultado.setText("Seu IMC é " + decimalFormat.format(imc) + "\n" + "Peso Normal");
        }else if(imc <= 29.9){
            binding.txtResultado.setText("Seu IMC é " + decimalFormat.format(imc) + "\n" + "SobrePeso");
        }else if(imc <= 34.9){
            binding.txtResultado.setText("Seu IMC é " + decimalFormat.format(imc) + "\n" + "Obesidade (Grau 1)");
        }else if(imc <= 39.9){
            binding.txtResultado.setText("Seu IMC é " + decimalFormat.format(imc) + "\n" + "Obesidade Severa (Grau 2)");
        }else{
            binding.txtResultado.setText("Seu IMC é " + decimalFormat.format(imc) + "\n" + "Obesidade Mórbida (Grau 3)");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemID = item.getItemId();
        if(itemID==R.id.ic_limpar){
            //binding recupera os ids
            binding.editPeso.setText("");
            binding.editAltura.setText("");
            binding.txtResultado.setText("");
        }

        return super.onOptionsItemSelected(item);
    }
}