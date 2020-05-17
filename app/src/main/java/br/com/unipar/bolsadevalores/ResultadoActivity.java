package br.com.unipar.bolsadevalores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Bundle b = getIntent().getExtras();

        TextView edLpa = findViewById(R.id.edLpa);
        TextView edPl = findViewById(R.id.edPl);
        TextView edroe = findViewById(R.id.edRoe);
        TextView edvpa = findViewById(R.id.edVpa);
        TextView edpvp = findViewById(R.id.edpvp);
        if (b != null){
            Double lpa = b.getDouble("lpa");
            Double pl = b.getDouble("pl");
            Double roe = b.getDouble("roe");
            Double vpa = b.getDouble("vpa");
            Double pvp = b.getDouble("pvp");

            edLpa.setText(lpa.toString());
            edPl.setText(pl.toString());
            edroe.setText(roe.toString());
            edvpa.setText(vpa.toString());
            edpvp.setText(pvp.toString());

        }

    }
}
