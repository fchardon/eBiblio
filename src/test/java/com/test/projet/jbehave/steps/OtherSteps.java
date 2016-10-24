package com.test.projet.jbehave.steps;

public class OtherSteps {

  /*

    System system = new System();
    Calculateur calculateur = new Calculateur();
    GenerateurDecision generateurDecision = new GenerateurDecision();
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // GIVEN
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////



    @Given("la date du jour est le $date")
    public void initDateDuJour(LocalDate date) {
        system.dateDuJourEst(date);
    }

    @When("le gestionnaire génère une décision d'octroi pour la période du $periode pour l'enfant $enfant de l'ayant-droit $ayantDroit engagé le $dateEmbauche chez l'employeur $nomEmployeur sur $canton.")
    public void genererDecisionOctroi(LocalDate periode, Enfant enfant, AyantDroit ayantDroit, LocalDate dateEmbauche, String nomEmployeur, Canton canton) {
        Calculateur calculateur = system.trouverCalculateurPour(canton);
        Employeur employeur = system.trouverEmployeur(ayantDroit, nomEmployeur, dateEmbauche);
        Montant montant = calculateur.calculerDroitMensuel(ayantDroit, enfant, employeur, periode);
        DecisionOctroi decisionOctroi = generateurDecision.genererDecisionOctroi(montant, dateEmbauche, system.dateDuJour());
        system.enregistrerDecision(decisionOctroi);

    }

    @Then("le système prépare un droit de $montantMensuel avec un montant rétroactif de $montantRetroactif")
    public void verifierMontantAccorde(Montant montantMensuel, Montant retroactif) {
        DecisionOctroi decisionOctroi = system.getDecisionOctroi();
        assertThat(decisionOctroi.getMontantMensuel(),equalTo(montantMensuel));
        assertThat(decisionOctroi.getMontantRetroactif(),equalTo(retroactif));
    }

    private class Calculateur {
        public Montant calculerDroitMensuel(AyantDroit ayantDroit, Enfant enfant, Employeur employeur, Canton canton ) {
            return new Montant();
        }


    }


    private class GenerateurDecision {
        public DecisionOctroi genererDecisionOctroi(Montant montant, LocalDate dateDebut, LocalDate dateFin){
            return new DecisionOctroi();
        }
    }

    private class System {
        public void dateDuJourEst(LocalDate date) {

        }

        public LocalDate dateDuJour() {
            return new LocalDate();
        }

        public Calculateur trouverCalculateurPour(Canton canton) {
            return new Calculateur();
        }
        public Employeur trouverEmployeur(AyantDroit ayantDroit, String nomEmployer, LocalDate dateEmbauche) {
            return new Employeur();
        }

        public void enregistrerDecision(DecisionOctroi decisionOctroi) {

        }

        public  DecisionOctroi getDecisionOctroi() {
            return new DecisionOctroi();
        }
    }
    */
}
