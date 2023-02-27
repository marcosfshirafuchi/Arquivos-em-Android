package com.marcosfshirafuchi.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fbSalvar = findViewById(R.id.fb_Salvar);
        editAnotacao = findViewById(R.id.editAnotacao);
        preferencias = new AnotacaoPreferencias(getApplicationContext());

        fbSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoRecuperado = editAnotacao.getText().toString();

                if(textoRecuperado.equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha a anotação!",Toast.LENGTH_SHORT).show();

                }
                else{
                    preferencias.salvarAnotacao(textoRecuperado);
                    Toast.makeText(getApplicationContext(),"Anotação salva com sucesso!",Toast.LENGTH_SHORT).show();
                }

            }
        });
        //Recuperar a anotação
        String anotacao = preferencias.recuperarAnotacao();
        if(!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }
    }
}