package com.test.projet.jbehave.steps;

import com.test.projet.ebiblio.domain.adherent.AdherentRepositoryMock;
import com.test.projet.ebiblio.domain.livre.*;
import com.test.projet.ebiblio.domain.tier.Adherent;
import com.test.projet.ebiblio.domain.tier.AdherentRepository;
import com.test.projet.ebiblio.domain.tier.NoAdherent;
import org.jbehave.core.annotations.*;

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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // GIVEN
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Given("mon adhérent loue pour &montant € de livre.")
    public void monAdherentLoue(Long montant) {

    }

    @Given("mon adhérent &no existe.")
    public void loadAdherent(String no) {
        adherent = adherentRepository.findBy(new NoAdherent(no));
    }

    @Given("mon livre de reference &no exist.")
    public void monLivreEstDisponible(String no) {
        livre = livreRepository.findBy(new Reference(no));
    }

    @Given("mon livre de reference &ref est disponible.")
    @Pending
    public void checkMonLivreEstDisponible(String ref) {
        livre = livreRepository.findBy(new Reference(ref));
        livre.getEtat().equals(Etat.DISPONIBLE);
    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // WHEN
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @When("je fais un rabais de &pourcentage%.")
    public void checkRabais(Long pourcentage) {
        // EN SUSPENS
    }

    @When("l'adhérent loue le livre.")
    public void adherentLoueUnLivre() {
        adherent.louer(livre);
        adherentRepository.store(adherent);
    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // THEN
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Then("l'adhérent paye &montant €.")
    public void adherentPaye(String montant) {
        // EN SUSPENS
    }

    @Then("le livre est loué.")
    public void leLivreEstLoue() {
        livre.estLoue();
    }

    @Then("l'adhérent a loué &nb livre.")
    public void checkAdherentLoueUnLivre(int nb) {

    }



    
    
}
