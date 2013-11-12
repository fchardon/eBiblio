package com.test.projet.ebiblio.domain.adherent;

import java.util.ArrayList;
import java.util.List;

import com.test.projet.ebiblio.domain.exception.EntityNotFoundException;
import com.test.projet.ebiblio.domain.tier.Adherent;
import com.test.projet.ebiblio.domain.tier.AdherentRepository;
import com.test.projet.ebiblio.domain.tier.NoAdherent;

public class AdherentRepositoryMock implements AdherentRepository {
    private static AdherentRepositoryMock INSTANCE = null;

    List<Adherent> adherents;

    public static AdherentRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AdherentRepositoryMock();
        }
        return INSTANCE;
    }

    private AdherentRepositoryMock() {
        adherents = new ArrayList<Adherent>();
        adherents.add(new Adherent("Chardonnereau", "Florent", new NoAdherent("123")));
    }

    public Adherent findBy(NoAdherent noAdherent) {
        for (Adherent adherent : adherents) {
            if (adherent.getNoAdherent().equals(noAdherent)) {
                return adherent;
            }
        }
        throw new EntityNotFoundException("L'adherent avec le numero {0} n'existe pas.", noAdherent);
    }

    public Adherent findBy(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void store(Adherent e) {
        // TODO Auto-generated method stub
        
    }

}
