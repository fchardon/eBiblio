package com.test.projet.jbehave.steps;

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

    LivreRepository livreRepository = LivreRepositoryMock.getInstance();
    AdherentRepository adherentRepository = AdherentRepositoryMock.getInstance();

    Adherent adherent;
    Livre livre;
    
    @Given("mon adhérent %noAdherent existe.")
    public void givenMonAdherentExiste(String noAdherent) {
        adherent = adherentRepository.findBy(new NoAdherent(noAdherent));
    }

    @Given("mon livre référence %reference est disponible.")
    public void givenMonLivreReferenceEstDisponible(String reference) {
        livre = livreRepository.findBy(new Reference(reference));
        Assert.assertTrue("Mon livre n'est pas disponible", livre.estDisponible());
    }
    
    @When("l'adhérent loue le livre.")
    public void whenLadherentLoueLeLivre() {
        adherent.louer(livre);
    }

    @Then("le livre est loué.")
    public void thenLeLivreEstLoue() {
        Assert.assertTrue("Mon livre n'est pas loué", livre.estLoue());
    }
    
    @Then("l'adhérent a loué %nombre livre.")
    public void thenLadherentALoueLivres(int nombre) {
     Assert.assertEquals("Le nombre de livre loué est incorrecte.", nombre, adherent.nombreDeLivreEnLocation());
    }

}
