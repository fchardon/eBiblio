package com.test.projet.ebiblio.domain.tier;

import com.test.projet.ebiblio.domain.Entity;
import com.test.projet.ebiblio.domain.livre.Livre;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class Adherent implements Entity {

   

    private String nom;
    private String prenom;
    private NoAdherent noAdherent;
    
    private List<Livre> livreLoue;
    private AdherentStatus status;
    private LocalDate dateAdhesion;

    public Adherent(String nom, String prenom, NoAdherent noAdherent) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.noAdherent = noAdherent;
        livreLoue = new ArrayList<Livre>();
    }
    
    
    ////////////////////////////////////////
    
    public void louer(Livre livre) {
        if(aLoueDesLivres()) {
            devientActif();
        }

        if(livre.estDisponible()) {
            ajouterLivre(livre);
        }

       // DomainEvent.event(AdherentALoueUnLivreEvent());

    }

    public void devientActif() {
        this.status = AdherentStatus.ACTIF;
    }

    public boolean aLoueDesLivres() {
        return livreLoue.isEmpty();
    }

    public boolean ajouterLivre(Livre livre) {
        return livreLoue.add(livre);
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


    public Dictionary hasLivres() {
        return null;
    }

    public List<Livre> getLivres() {
        return new ArrayList<Livre>();
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }
}
