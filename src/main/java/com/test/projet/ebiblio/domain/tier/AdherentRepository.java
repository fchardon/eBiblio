package com.test.projet.ebiblio.domain.tier;

import com.test.projet.ebiblio.domain.Repository;

public interface AdherentRepository extends Repository<Adherent> {
    Adherent findBy(NoAdherent noAdherent);
}
