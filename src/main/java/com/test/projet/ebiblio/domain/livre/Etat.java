package com.test.projet.ebiblio.domain.livre;

public enum Etat {
    /**
     * Livre Disponible à la location
     */
    DISPONIBLE,
    
    /**
     * Livre loué, indisponible
     */
    LOUE,
    
    /**
     * Livre perdu, non disponible
     */
    PERDU;
}
