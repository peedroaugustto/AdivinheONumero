package com.example.aluno.numero;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener {

    EditText numero;
    TextView mensagem;
    int aleatorio = (int)(Math.random()*101);
    int palpites = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero   = (EditText)findViewById(R.id.numero);
        mensagem = (TextView)findViewById(R.id.mensagem);
        numero.setOnKeyListener(this);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_ENTER &&
                event.getAction() != KeyEvent.ACTION_DOWN){
            verificaPapite();
            return true;
        }
        return false;
    }

    private void verificaPapite() {

        palpites++;
        int nro = Integer.parseInt(numero.getText().toString());
        Log.v("Numero: ", Integer.toString(aleatorio));
        if(nro == aleatorio){
            mensagem.setText("Acertou. palpites: " + palpites);
        } else if(nro > aleatorio){
            mensagem.setText("Valor acima do alvo");
        } else if (nro < aleatorio){
            mensagem.setText("Valor abaixo do alvo");
        }


    }
}

