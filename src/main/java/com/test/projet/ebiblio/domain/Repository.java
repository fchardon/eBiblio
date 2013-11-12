package com.test.projet.ebiblio.domain;

public interface Repository<E> {

    E findBy(Long id);
    
    void store(E e);
}
