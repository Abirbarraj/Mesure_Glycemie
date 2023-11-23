package com.example.mesure_glycemie.Model;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.example.mesure_glycemie.View.MainActivity;

public class Patient {
    private int age;
    private float valMesuree;
    private boolean fasting;
    private String result;

    public Patient(int age, float valMesuree, boolean fasting) {
        this.age = age;
        this.valMesuree= valMesuree;
        this.fasting = fasting;
        calculer();
    }
    public String getResult() {
        return result;}
    private int getAge() {
        return age;}
    private float getValMesuree() {
        return valMesuree;}
    private boolean isFasting() {
        return fasting;}
    public String toString() {
        return "Patient{" +
                "result='" + result + '\'' +
                '}';
    }
    private void calculer() {
        if (fasting)
            if (age >= 13)
                if (valMesuree < 5)
                    result = "Niveau de glycemie est bas";
                else if (valMesuree >= 5 && valMesuree <= 7.2)
                    result = "Niveau de glycemie est normale";
                else result = "Niveau de glycemie est elevee";
            else if (age >= 6 && age <= 12)
                if (valMesuree < 5)
                    result = "Niveau de glycemie est bas";
                else if (valMesuree >= 5 && valMesuree <= 10.0)
                    result = "Niveau de glycemie est normale";
                else result = "Niveau de glycemie est elevee";
            else if (age < 6)
                if (valMesuree < 5.5)
                    result = "Niveau de glycemie est bas";
                else if (valMesuree >= 5.5 && valMesuree <= 10.0)
                    result = "Niveau de glycemie est normale";
                else result = "Niveau de glycemie est elevee";
            else if (valMesuree > 10.5)
                result = "Niveau elevee";
            else
                result = "Niveau de glycemie est normale";

    }
}