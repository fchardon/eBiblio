package com.test.projet.ebiblio.domain.livre;

import java.util.ArrayList;
import java.util.List;

import com.test.projet.ebiblio.domain.exception.EntityNotFoundException;


public class LivreRepositoryMock implements LivreRepository {

    private static LivreRepositoryMock INSTANCE = null;
    
    List<Livre> livres;
    
    public static LivreRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new LivreRepositoryMock();
        }
        return INSTANCE;
    }
    
    public static void disposeInstance() {
        INSTANCE = null;
    }
    
    private LivreRepositoryMock() {
        livres = new ArrayList<Livre>(); 
        livres.add(new Livre("Comment changer le monde ?",  "Yannick Grenzinger", new Reference("aaa")));
    }
    
    public Livre findBy(Reference reference) {
        for(Livre livre : livres) {
            if(livre.getReference().equals(reference)) {
                return livre;
            }
        }
        throw new EntityNotFoundException("Le livre avec la référence {0} n'existe pas.", reference);
    }
    
    public Livre findBy(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void store(Livre e) {
        // TODO Auto-generated method stub
        
    }

}
