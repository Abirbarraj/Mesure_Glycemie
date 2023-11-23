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

import com.example.mesure_glycemie.Controller.Controller;
import com.example.mesure_glycemie.R;

public class MainActivity extends AppCompatActivity {
    //attributs
    private EditText etValeur;
    private Button btnConsulter;
    private SeekBar sbAge;
    private TextView tvage, tvresultat;
    private RadioButton rbtoui, rbtnon;

    //private Controller controller=new Controller();
    private Controller controller = Controller.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //Listener Seekbar
        sbAge.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        Log.i("Information", "On Progress Change" + i);
                        tvage.setText("Votre Age :" + i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        btnConsulter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int age;
                        float valMesuree;
                        boolean verifAge = false, verifVal = false;
                        if (sbAge.getProgress() != 0)
                            verifAge = true;
                        else
                            Toast.makeText(MainActivity.this, "veuillez verifier votre age", Toast.LENGTH_SHORT).show();
                        if (!etValeur.getText().toString().isEmpty())
                            verifVal = true;
                        else
                            Toast.makeText(MainActivity.this, "veuillez verifier votre valeur mesuree", Toast.LENGTH_LONG).show();
                        if (verifAge && verifVal) {
                            age = sbAge.getProgress();
                            valMesuree = Float.valueOf(etValeur.getText().toString());
                            boolean isFasting = rbtoui.isChecked();
                            //user action view--> controller
                            Controller.createPatient(age,valMesuree,isFasting);}


                    }
                }
        );

    }

    private void init(){
        etValeur =(EditText) findViewById(R.id.EdText);
        btnConsulter =(Button) findViewById(R.id.btnConsulter);
        rbtoui = (RadioButton)findViewById(R.id.rbtOui);
        rbtnon= (RadioButton)findViewById(R.id.rbtnon);
        sbAge= (SeekBar)findViewById(R.id.sbAge);
        tvage= (TextView)findViewById(R.id.tvage);
        tvresultat=(TextView) findViewById(R.id.result);

    }


}