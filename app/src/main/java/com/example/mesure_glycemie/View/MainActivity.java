package com.example.mesure_glycemie.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mesure_glycemie.R;

public class MainActivity extends AppCompatActivity {
    private EditText etValeur;
    private Button btnConsulter;
    private RadioButton rbtoui;
    private RadioButton rbtnon;
    private SeekBar sbAge;
    private TextView tvage,tvresultat;

    private void init(){
        etValeur =(EditText) findViewById(R.id.EdText);
        btnConsulter =(Button) findViewById(R.id.btnConsulter);
        rbtoui = (RadioButton)findViewById(R.id.rbtOui);
        rbtnon= (RadioButton)findViewById(R.id.rbtnon);
        sbAge= (SeekBar)findViewById(R.id.sbAge);
        tvage= (TextView)findViewById(R.id.tvage);
        tvresultat=(TextView) findViewById(R.id.result);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Information", "onProgressChanged " + progress);
                // affichage dans le Log de Android studio pour voir les changements détectés sur le SeekBar ..
                tvage.setText("Votre âge : " + progress);
                // Mise à jour du TextView par la valeur : progress à chaque changement.

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        btnConsulter.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                calculer(v);
                                            }
                                        }
        );
    }

    public void calculer(View v){
        int age ;
        float valeurMesuree ;
        boolean verifAge=false ;
        boolean verifValeur=false ;
        if(sbAge.getProgress()!=0) {
            verifAge=true;
        }
        else {
            Toast.makeText(MainActivity.this,"veuillez verifier votre age", Toast.LENGTH_SHORT).show();
        }
        if(!etValeur.getText().toString().isEmpty()) {
            verifValeur=true;
        }
        else Toast.makeText(MainActivity.this,"veuillez verifier votre age", Toast.LENGTH_LONG).show();
        if(verifAge && verifValeur){
            age=sbAge.getProgress();
            valeurMesuree=Float.valueOf(
                    etValeur.getText().toString());
            boolean isFasting=rbtoui.isChecked();
            if(isFasting)
            {if(age>=13)
                if(valeurMesuree<5)
                    tvresultat.setText("niveau de glycemie est bas");
                else if(valeurMesuree>=5 && valeurMesuree<=7.2)
                    tvresultat.setText("niveau de glycemie est normale");
                else tvresultat.setText("niveau de glycemie est elevé");
            else if (age>=6 && age<=12) {
                if(valeurMesuree<5)
                    tvresultat.setText("niveau de glycemie est bas");
                else if(valeurMesuree>=5 && valeurMesuree<=7.2)
                    tvresultat.setText("niveau de glycemie est normale");
                else tvresultat.setText("niveau de glycemie est elevé");
            }
            else if (age<6) {
                if(valeurMesuree<5.5)
                    tvresultat.setText("niveau de glycemie est bas");
                else if(valeurMesuree>=5.5 && valeurMesuree<=10.0)
                    tvresultat.setText("niveau de glycemie est normale");
                else tvresultat.setText("niveau de glycemie est elevé");
            }
            }
            else //notfasting
            {if(valeurMesuree>10.5)
                tvresultat.setText("niveau de glycemie est élever");
            else tvresultat.setText("niveau de glycemie est normale");
            }
        }
    }
}
