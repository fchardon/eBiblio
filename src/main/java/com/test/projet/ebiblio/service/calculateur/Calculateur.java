package com.test.projet.ebiblio.service.calculateur;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by florent on 21/10/2016.
 */
public class Calculateur {

    Map<Integer, Integer> remise = new HashMap<Integer, Integer>();

    public Calculateur( Map<Integer, Integer> remise) {
        this.remise = remise;
        /*this.remise.put(1,1);
        this.remise.put(2,2);
        this.remise.put(5,5);*/
    }

    /**
     *
     * @param dateDuJour
     * @param dateAdhesion
     * @return
     */
    public Remise calculMontantRemise(LocalDate dateDuJour, LocalDate dateAdhesion){
        Years years = Years.yearsBetween(dateAdhesion, dateDuJour);
        //long year = ChronoUnit.YEARS.between(dateAdhesion, dateDuJour);
        return calculMontantRemise(years.getYears());
    }


    /**
     * Calculer la remise correspondant à l'année inférieur la plus proche.<br/>
     * Si {@code annee} = 5 et qu'il existe des remises pour 1, 4 et 6 ans<br/>
     * Alors l'année inférieur la plus proche sera 4 ans.
     * @param annee -
     * @return la {@link Remise}
     */
    public Remise calculMontantRemise(Integer annee){
        //System.out.println("calculMontantRemise:"+annee);

        Integer anneeLaPlusProche = 0;
        // Supprimer le stream
        for (Integer anneeRemise: remise.keySet()) {
            //System.out.println(anneeRemise+":"+anneeLaPlusProche);
            if(anneeRemise > annee.intValue()) {
               break;
            }
            anneeLaPlusProche = anneeRemise;
        }

        if(!this.remise.containsKey(anneeLaPlusProche)) {
            throw new RuntimeException("There is no discount for the tenure "+anneeLaPlusProche+" year");
        }

        Integer remise = this.remise.get(anneeLaPlusProche);
        return new Remise(new BigDecimal(remise));
    }

    public void addRule(Integer year, Integer percent) {
        remise.put(year, percent);
    }
}
