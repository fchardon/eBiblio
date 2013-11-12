package com.test.projet.ebiblio.domain.tier;

import com.test.projet.ebiblio.domain.ValueObject;
import com.test.projet.ebiblio.regles.RegleValidationNoAdherent;
// Le NoAdherent doit être du format [0-9]{3}
public class NoAdherent implements ValueObject {

    private String numero;

    public NoAdherent(String numero) {
        if (new RegleValidationNoAdherent(numero).valider()) {
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
        NoAdherent other = (NoAdherent) obj;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }
    
    

}
