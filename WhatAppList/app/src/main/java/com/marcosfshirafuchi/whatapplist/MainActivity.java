package com.marcosfshirafuchi.whatapplist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.marcosfshirafuchi.whatapplist.Adapter.AdapterUsuario;
import com.marcosfshirafuchi.whatapplist.Model.Usuario;
import com.marcosfshirafuchi.whatapplist.RecyclerItemClickListener.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_usuario;
    private List<Usuario> usuarioList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_usuario = findViewById(R.id.recycler_usuarios);
        //Define a orientação da lista, neste na vertical
        recycler_usuario.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));

        //Esse método vai dar mais desempenho na lista
        recycler_usuario.setHasFixedSize(true);
        //instanciando o AdapterUsuario
        AdapterUsuario adapterUsuario = new AdapterUsuario(usuarioList);
        //Adaptação da lista
        recycler_usuario.setAdapter(adapterUsuario);
        Usuarios();

        //
        recycler_usuario.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recycler_usuario,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Usuario usuario = usuarioList.get(position);
                        Toast.makeText(getApplicationContext(),"Usuario: " + usuario.getNome(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Usuario usuario = usuarioList.get(position);
                        Toast.makeText(getApplicationContext(),"Usuario: " + usuario.getNome(),Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));
    }

    public void Usuarios(){

        Usuario usuario1 = new Usuario(R.drawable.usuario1,"Marcos","Olá como vai?");
        usuarioList.add(usuario1);

        Usuario usuario2 = new Usuario(R.drawable.usuario2,"Bruna","Olá como vai?");
        usuarioList.add(usuario2);

        Usuario usuario3 = new Usuario(R.drawable.usuario1,"Pedro","Vou na sua casa amanhã");
        usuarioList.add(usuario3);

        Usuario usuario4 = new Usuario(R.drawable.usuario2,"Bianca","Estou bem e você?");
        usuarioList.add(usuario4);

        Usuario usuario5 = new Usuario(R.drawable.usuario1,"João da Silva","Oi");
        usuarioList.add(usuario5);

        Usuario usuario6 = new Usuario(R.drawable.usuario2,"Maria Clara","Vamos ao shopping depois do almoço?");
        usuarioList.add(usuario6);

        Usuario usuario7 = new Usuario(R.drawable.usuario1,"Cleber","Como você esta?");
        usuarioList.add(usuario7);

        Usuario usuario8 = new Usuario(R.drawable.usuario2,"Leticia","Muito obrigada :)");
        usuarioList.add(usuario8);

        Usuario usuario9 = new Usuario(R.drawable.usuario1,"Felipe Rodrigues","Foi muito legal ontem.");
        usuarioList.add(usuario9);

        Usuario usuario10 = new Usuario(R.drawable.usuario2,"Janaina","Bom fim de semana pra você");
        usuarioList.add(usuario10);

        Usuario usuario11 = new Usuario(R.drawable.usuario1,"Mario","Olá Leticia tudo bem?");
        usuarioList.add(usuario11);

        Usuario usuario12 = new Usuario(R.drawable.usuario2,"Ana","Oi");
        usuarioList.add(usuario12);


    }
}