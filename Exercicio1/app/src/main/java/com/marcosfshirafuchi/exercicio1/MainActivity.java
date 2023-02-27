package com.marcosfshirafuchi.exercicio1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.marcosfshirafuchi.exercicio1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = binding.editNumero.getText().toString();
                if(numero.isEmpty()){
                    binding.editNumero.setError("Digite um número!");
                }else{
                    verificarParouImpar();
                }

            }
        });
    }
    private void verificarParouImpar(){
        int numero =Integer.parseInt(binding.editNumero.getText().toString());

        if(numero %2 ==0)
        {
            binding.txtMensagem.setText("O numero "+numero + " é Par!");
        }else{
            binding.txtMensagem.setText("O numero "+numero + " é Impar!");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Recuperar o menu principál
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID = item.getItemId();
        if(itemID ==R.id.ic_limpar){
            binding.editNumero.setText("");
            binding.txtMensagem.setText("");
        }
        return super.onOptionsItemSelected(item);
    }
}