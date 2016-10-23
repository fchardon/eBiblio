package com.test.projet.ebiblio.service.calculateur;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        long year = ChronoUnit.YEARS.between(dateDuJour, dateAdhesion);
        return calculMontantRemise(year);
    }


    /**
     * Calculer la remise correspondant à l'année inférieur la plus proche.<br/>
     * Si {@code annee} = 5 et qu'il existe des remises pour 1, 4 et 6 ans<br/>
     * Alors l'année inférieur la plus proche sera 4 ans.
     * @param annee -
     * @return la {@link Remise}
     */
    public Remise calculMontantRemise(Long annee){
        Integer anneeLaPlusProche = null;
        // Supprimer le stream
        for (Integer anneeRemise: remise.keySet()
             ) {
            anneeLaPlusProche = anneeRemise;
            if(annee > annee.intValue()) {
               break;
            }
        }
       /* Integer integer = remise.keySet().stream()
                .filter(integer1 -> integer1 > year.intValue())
                .max((p1, p2) -> p1.compareTo(p2)).get();*/
        Integer remise = this.remise.get(anneeLaPlusProche);
        return new Remise(new BigDecimal(remise));
    }

}
