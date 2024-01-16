package org.example.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.util.Date;

/**
 * Cette Classe est un verbe porteur de donnée, notamment la donnée Date de fouille
 * elle fait le lien avec la parcelle fouillée et l'équipe qui l'a fouillé
 */
@Entity
@IdClass(FouillePK.class)
public class Fouille {
    @Id
    private Long equipeId;
    @Id
    private Long parcelleId;
    @Id
    private Date date;

    public Fouille() {
    }

    public Fouille(Long equipeId, Long parcelleId, Date date) {
        this.equipeId = equipeId;
        this.parcelleId = parcelleId;
        this.date = date;
    }


}
