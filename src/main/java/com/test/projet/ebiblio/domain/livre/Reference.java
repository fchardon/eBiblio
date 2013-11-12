package com.test.projet.ebiblio.domain.livre;

import com.test.projet.ebiblio.domain.ValueObject;
import com.test.projet.ebiblio.regles.RegleValidationReference;

public class Reference implements ValueObject {
    private String numero;

    public Reference(String numero) {
        if (new RegleValidationReference(numero).valider()) {
            this.numero = numero;
        }
    }

    /**
     * @return le numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reference other = (Reference) obj;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }
    
    

}
