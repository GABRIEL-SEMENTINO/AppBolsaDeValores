package br.com.unipar.bolsadevalores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edAtivo, edLucroLiquido, edPatrimonioLiquido, edNumeroAcoes, edPrecoAtual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view) {

        //Recuperar os valores dos Edit's texts
        edAtivo = findViewById(R.id.edAtivo);
        edLucroLiquido = findViewById(R.id.edLucroLiquido);
        edPatrimonioLiquido = findViewById(R.id.edPatrimonioLiquido);
        edNumeroAcoes = findViewById(R.id.edNumeroAcoes);
        edPrecoAtual = findViewById(R.id.edPrecoAtual);


        //Calcular o resultado

        String ativo = edAtivo.getText().toString();
        double lucroLiquido = Double.parseDouble(edLucroLiquido.getText().toString());
        double patrimonioLiquido = Double.parseDouble(edPatrimonioLiquido.getText().toString());
        long numeroAcoes = Long.parseLong(edNumeroAcoes.getText().toString());
        double precoAtual = Double.parseDouble(edPrecoAtual.getText().toString());

        /*LPA = Lucro Líquido / N º Ações Emitidas
          P/L = Preço Atual / LPA
          ROE = (Lucro Líquido / Patrimônio Líquido) * 100
          VPA = Patrimônio Líquido / N º Ações Emitidas
          P/VP = Preço da Ação / VPA
        */
        /*
        * Double = classe (tipo de dados que possuem funções que te auxiliam a manusear a variável)
        * double = tipo primitivo (tipo de dados que apenas diz ao compilador que tipo de valor será armazenado na variável)
        **/

        double lpa = lucroLiquido / numeroAcoes;
        double pl = precoAtual / lpa;
        double roe = (lucroLiquido / patrimonioLiquido) * 100;
        double vpa = patrimonioLiquido / numeroAcoes;
        double pvp = precoAtual / vpa;



        Intent intent = new Intent(this, ResultadoActivity.class);
        Bundle b = new Bundle();
        b.putString("ativo", ativo);
        b.putDouble("lpa", lpa);
        b.putDouble("pl", pl);
        b.putDouble("roe", roe);
        b.putDouble("vpa", vpa);
        b.putDouble("pvp", pvp);
        intent.putExtras(b);
        startActivity(intent);
        finish();

    }

}
