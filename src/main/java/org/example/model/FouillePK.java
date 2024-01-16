package org.example.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Date;

/**
 * Cette classe n'est pas une entity
 * Elle permet juste de créer une clé composite pour l'Entity Fouille
 * la classe composite sera consititué du couple equipe_id/parcelle_id
 */
@Embeddable
public class FouillePK implements Serializable {

 private Long equipeId;
 private Long parcelleId;
 private Date date;

 public FouillePK(){}

    public FouillePK(Long equipeId, Long parcelleId, Date date) {
        this.equipeId = equipeId;
        this.parcelleId = parcelleId;
        this.date = date;
    }

    public Long getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(Long equipeId) {
        this.equipeId = equipeId;
    }

    public Long getParcelleId() {
        return parcelleId;
    }

    public void setParcelleId(Long parcelleId) {
        this.parcelleId = parcelleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
