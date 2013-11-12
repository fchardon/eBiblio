package com.test.projet.ebiblio.domain.livre;

import com.test.projet.ebiblio.domain.Repository;

public interface LivreRepository extends Repository<Livre> {

    Livre findBy(Reference reference);
}
