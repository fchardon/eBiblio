package com.test.projet.ebiblio.regles;

import static org.apache.commons.lang3.Validate.validState;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegleValidationReference {
 private final Pattern patternAvecSeparateur = Pattern.compile("[a-z]{3}");
    
    String numero;
    
    public RegleValidationReference(String numero) {
        this.numero = numero;
    }
    
    public boolean valider() throws IllegalStateException {
        Matcher matcherAvecSeparateur = patternAvecSeparateur.matcher(numero);
        validState(
                matcherAvecSeparateur.matches(),
                "Le format du numero '%s' doit être de la forme xxx avec x compris [a-z]",
                numero);

        return true;
    }
}
