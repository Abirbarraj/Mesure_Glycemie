package com.example.mesure_glycemie.Model;

import android.widget.Toast;

import com.example.mesure_glycemie.View.MainActivity;

public class Patient {
    private int sbAge ;
    private String tvresultat ;
    private float valeurMesuree ;
    private boolean fast ;
    //Notify controle --> Model
    public Patient(Integer age, Float valeurMesuree, boolean fast) {
        this.sbAge = sbAge;
        this.valeurMesuree = valeurMesuree;
        this.fast = fast;
        calculer();
    }
    public Integer getAge() {
        return sbAge;
    }
    public Float getValeurMesuree() {
        return valeurMesuree;
    }
    public boolean isFast() {
        return fast;
    }

    public void setAge(int age) {
        this.sbAge = sbAge;
    }

    public void setValeurMesuree(int valeur) {
        this.valeurMesuree = valeur;
    }

    public void setFast(boolean fast) {
        this.fast = fast;
    }
    public void calculer() {
        if(fast) {
            {
                if (sbAge >= 13)
                    if (valeurMesuree < 5)
                        tvresultat = "niveau de glycemie est bas";
                    else if (valeurMesuree >= 5 && valeurMesuree <= 7.2)
                        tvresultat = "niveau de glycemie est normale";
                    else tvresultat = "niveau de glycemie est elevé";
                else if (sbAge >= 6 && sbAge <= 12) {
                    if (valeurMesuree < 5)
                        tvresultat = "niveau de glycemie est bas";
                    else if (valeurMesuree >= 5 && valeurMesuree <= 7.2)
                        tvresultat = "niveau de glycemie est normale";
                    else tvresultat = "niveau de glycemie est elevé";
                } else if (sbAge < 6) {
                    if (valeurMesuree < 5.5)
                        tvresultat = "niveau de glycemie est bas";
                    else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                        tvresultat = "niveau de glycemie est normale";
                    tvresultat = "niveau de glycemie est elevé";
                }
            }
        }
        else //notfasting
        {
            if (valeurMesuree > 10.5)
                tvresultat = "niveau de glycemie est élever";
            else tvresultat = "niveau de glycemie est normale";
        }

    }
}

