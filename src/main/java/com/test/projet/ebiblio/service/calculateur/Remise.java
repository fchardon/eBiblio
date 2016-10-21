package com.test.projet.ebiblio.service.calculateur;

import java.math.BigDecimal;

/**
 * Created by florent on 22/10/2016.
 */
public class Remise {

    BigDecimal montantRemise;

    public Remise(BigDecimal montantRemise) {
        this.montantRemise = montantRemise;
    }

    public BigDecimal calculPrix(BigDecimal prix) {
        return prix.subtract(prix.multiply(montantRemise).divide(BigDecimal.valueOf(100)));
    }
}
