package com.test.projet.ebiblio.service;

import com.test.projet.ebiblio.domain.livre.Etat;
import com.test.projet.ebiblio.domain.livre.LivreRepository;
import com.test.projet.ebiblio.domain.tier.Adherent;
import com.test.projet.ebiblio.domain.tier.AdherentRepository;
import com.test.projet.ebiblio.domain.livre.Livre;

import java.util.List;

/**
 * Created by florent on 14/06/15.
 */
public class eBiblioService {

    private LivreRepository livreRepository;

    private AdherentRepository adherentRepository;


    public void louerUnLivre(Long adherentId, Long livreId) {
        Livre livre = livreRepository.findBy(livreId);
        Adherent adherent = adherentRepository.findBy(adherentId);


        // Location de livre
        livre.setEtat(Etat.LOUE);
        if(adherent.hasLivres().isEmpty()) {
            adherent.devientActif();
        }

        List<Livre> livres = adherent.getLivres();

        if(!livres.contains(livre)) {
            livres.add(livre);
        }
        // F

        adherentRepository.store(adherent);


    }

    /*public void louerUnLivre(Long adherentId, Long livreId) {
        Livre livre = livreRepository.findBy(livreId);
        Adherent adherent = adherentRepository.findBy(adherentId);

        adherent.louer(livre);

        adherentRepository.store(adherent);

    }*/
}
