package com.test.projet.jbehave.steps;

import com.test.projet.ebiblio.domain.adherent.AdherentRepositoryMock;
import com.test.projet.ebiblio.domain.livre.*;
import com.test.projet.ebiblio.domain.tier.Adherent;
import com.test.projet.ebiblio.domain.tier.AdherentRepository;
import com.test.projet.ebiblio.domain.tier.NoAdherent;
import com.test.projet.ebiblio.service.calculateur.Calculateur;
import com.test.projet.ebiblio.service.calculateur.Remise;
import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;

@UsingSteps
public class eBiblioSteps {

    LivreRepository livreRepository;
    AdherentRepository adherentRepository;

    Calculateur calculateur;

    Adherent adherent;
    Livre livre;

    LocalDate dateDuJour;
    private BigDecimal prixCalcule;

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
    // Converter
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @AsParameterConverter
    public LocalDate toLocalDate(String name){
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return LocalDate.parse(name, formatter);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // GIVEN
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Given("nous sommes le &dateDuJour.")
    public void initDateDuJour(LocalDate dateDuJour) {
        this.dateDuJour = dateDuJour;
    }

    @Given("mon adhérent est client depuis le &dateAdhesion.")
    public void initAdherentDate(LocalDate dateAdhesion) {
        adherent.setDateAdhesion(dateAdhesion);
    }

    @Given("mon adhérent loue pour &montant € de livre.")
    public void monAdherentLoue(Long montant) {

    }

    @Given("{mon |l'}adhérent &no existe.")
    public void loadAdherent(String no) {
        adherent = adherentRepository.findBy(new NoAdherent(no));
    }

    @Given("mon livre de reference &no exist.")
    public void monLivreEstDisponible(String no) {
        livre = livreRepository.findBy(new Reference(no));
    }

    @Given("mon livre de reference &ref est disponible.")
    public void checkMonLivreEstDisponible(String ref) {
        livre = livreRepository.findBy(new Reference(ref));
        livre.getEtat().equals(Etat.DISPONIBLE);
    }

    @Given("les règles d'ancienneté sont :\n&regles")
    public void definirRegleCalculateur(ExamplesTable regles) {
        this.calculateur = new Calculateur(convertRegles(regles));
    }

    private Map<Integer, Integer> convertRegles(ExamplesTable table) {
        Map<Integer,Integer> regles = new HashMap<Integer,Integer>();
        for (Map<String,String> row : table.getRows()) {
            Integer age = Integer.valueOf(row.get("anciennete"));
            Integer tx = Integer.valueOf(row.get("taux"));
            regles.put(age, tx);
        }
        return regles;
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

    @When("l'adhérent emprunte un livre à &prix €.")
    public void emprunterLivre(BigDecimal prix) {
        Remise remise = calculateur.calculMontantRemise(this.dateDuJour, adherent.getDateAdhesion());
        this.prixCalcule = remise.calculPrix(prix);
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // THEN
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Then("l'adhérent paye &prix €.")
    public void adherentPaye(BigDecimal prix) {
        Assert.assertThat(this.prixCalcule, equalTo(prix));
    }

    @Then("le livre est loué.")
    public void leLivreEstLoue() {
        livre.estLoue();
    }

    @Then("l'adhérent a loué &nb livre.")
    public void checkAdherentLoueUnLivre(int nb) {

    }







    
    
}
