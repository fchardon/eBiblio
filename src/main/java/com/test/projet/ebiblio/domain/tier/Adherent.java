package com.test.projet.ebiblio.domain.tier;

import java.util.ArrayList;
import java.util.List;

import com.test.projet.ebiblio.domain.Entity;
import com.test.projet.ebiblio.domain.livre.Livre;

public class Adherent implements Entity {

   

    private String nom;
    private String prenom;
    private NoAdherent noAdherent;
    
    private List<Livre> livreLoue;
    
    public Adherent(String nom, String prenom, NoAdherent noAdherent) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.noAdherent = noAdherent;
        livreLoue = new ArrayList<Livre>();
    }
    
    
    ////////////////////////////////////////
    
    public void louer(Livre livre) {
    	// 
    }
    

    public int nombreDeLivreEnLocation() {
        return livreLoue.size();
    }
    
    ////////////////////////////////////////
    
    
    /**
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return le prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @return le noAdherent
     */
    public NoAdherent getNoAdherent() {
        return noAdherent;
    }



    
    
    
}
