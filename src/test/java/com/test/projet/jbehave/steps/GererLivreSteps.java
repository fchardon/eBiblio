package com.test.projet.jbehave.steps;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.test.projet.ebiblio.domain.adherent.AdherentRepositoryMock;
import com.test.projet.ebiblio.domain.livre.Livre;
import com.test.projet.ebiblio.domain.livre.LivreRepository;
import com.test.projet.ebiblio.domain.livre.LivreRepositoryMock;
import com.test.projet.ebiblio.domain.livre.Reference;
import com.test.projet.ebiblio.domain.tier.Adherent;
import com.test.projet.ebiblio.domain.tier.AdherentRepository;
import com.test.projet.ebiblio.domain.tier.NoAdherent;

public class GererLivreSteps {

    LivreRepository livreRepository;
    AdherentRepository adherentRepository;

    Adherent adherent;
    Livre livre;
    
    @AfterStory
    public void clean() {
    	LivreRepositoryMock.disposeInstance();
    	AdherentRepositoryMock.disposeInstance();
    	adherent = null;
    	livre = null;
    }
    
    @BeforeStory
    public void init() {
    	livreRepository = LivreRepositoryMock.getInstance();
        adherentRepository = AdherentRepositoryMock.getInstance();

    }
    
    
}
