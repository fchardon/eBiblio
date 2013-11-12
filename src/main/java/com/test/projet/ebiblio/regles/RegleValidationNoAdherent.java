package com.test.projet.ebiblio.regles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.Validate.validState;

public class RegleValidationNoAdherent implements RegleValidation {

    private final Pattern patternAvecSeparateur = Pattern.compile("[0-9]{3}");
    
    String numero;
    
    public RegleValidationNoAdherent(String numero) {
        this.numero = numero;
    }
    
    public boolean valider() throws IllegalStateException {
        Matcher matcherAvecSeparateur = patternAvecSeparateur.matcher(numero);
        validState(
                matcherAvecSeparateur.matches(),
                "Le format du numero '%s' doit être de la forme (xx.yy.xx) avec xx entre [0-9] et yy [a-z]",
                numero);

        return true;
    }

}
