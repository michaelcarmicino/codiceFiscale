package com.example.demo.codiceFiscaleService;

import java.time.LocalDate;
import java.util.HashMap;

public class CodiceFiscaleService {
    private static final HashMap<String, Integer> mesi;

    static {

        mesi = new HashMap<>();
        mesi.put("A", 1);
        mesi.put("B", 2);
        mesi.put("C", 3);
        mesi.put("D", 4);
        mesi.put("E", 5);
        mesi.put("H", 6);
        mesi.put("L", 7);
        mesi.put("M", 8);
        mesi.put("P", 9);
        mesi.put("R", 10);
        mesi.put("S", 11);
        mesi.put("T", 12);

    }
    public static LocalDate estraiData(String cf){
        //CRMMHL00C05I197D
        // cifre 7-8 rappresentano l'anno
        // cifra 9 rappresenta il mese
        // cifra 10-11 rappresenta il giorno
        int annoCorrente = LocalDate.now().getYear();
        int annoNascita = Integer.parseInt(cf.substring(6,8));

        if(annoNascita < annoCorrente%100){
            if(annoNascita <=10){
                annoNascita = Integer.parseInt("200" + annoNascita);
            }else{
                annoNascita = Integer.parseInt("20" + annoNascita);
            }

        } else {
            annoNascita = Integer.parseInt("19" + annoNascita);
        }

        int mese = mesi.get(cf.substring(8,9));

        int giorno = Integer.parseInt(cf.substring(9,11));

        System.out.println(Integer.parseInt(cf.substring(9,11)) );
        if(giorno>31){
            giorno = giorno -40;
        }
        LocalDate localDate = LocalDate.of(annoNascita, mese, giorno);
        return localDate;
    }
    public static int calcoloEta(Integer annoNascita ){

        int anno = LocalDate.now().getYear();

        return anno - annoNascita;
    }


}
