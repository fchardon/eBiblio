package com.test.projet.ebiblio.domain.livre;

import com.test.projet.ebiblio.domain.Entity;

public class Livre implements Entity  {
    
    private String nom;
    private String auteur;
    private Reference reference;
    private Etat etat;
    
    
    public Livre(String nom, String auteur, Reference reference) {
        super();
        this.nom = nom;
        this.auteur = auteur;
        this.reference = reference;
        etat = Etat.DISPONIBLE;
    }

    
    ////////////////////////////////////////
    
    
    
    public boolean estDisponible() {
        return etat.equals(Etat.DISPONIBLE);
    }

    public boolean estLoue() {
        return etat.equals(Etat.LOUE);
    }
    
    ////////////////////////////////////////
    
    /**
     * @return le nom
     */
    public String getNom() {
        return nom;
    }



    /**
     * @return le auteur
     */
    public String getAuteur() {
        return auteur;
    }



    /**
     * @return le reference
     */
    public Reference getReference() {
        return reference;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
