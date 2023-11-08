package com.example.mesure_glycemie.Controller;

import com.example.mesure_glycemie.Model.Patient;

public class Controller {
    private static Patient Patient;
    public  Controller(){
        super();
    }
    public void createPatient(int age,float valeur,boolean isFasting){
        Patient=new Patient(age,valeur,isFasting);
    }
}
