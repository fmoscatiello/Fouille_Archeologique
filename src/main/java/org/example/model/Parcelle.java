package org.example.model;
import jakarta.persistence.*;

import java.util.List;
import java.util.StringJoiner;

/**
 * Classe representant une parcelle de recherche pour les fouilles archéologiques
 */
@Entity
public class Parcelle {

    @Id
    @GeneratedValue
    private Long id;
    private double longueur;
    private double largeur;
    @ManyToOne
    @JoinColumn(name = "site_id")
    private SiteFouille siteFouille;

    @OneToMany(mappedBy = "parcelle")
    private List<ObjetTrouve> objetTrouveList;


    public Parcelle(){}

    public Parcelle(Long id, double longueur, double largeur, SiteFouille siteFouille) {
        this.id = id;
        this.longueur = longueur;
        this.largeur = largeur;
        this.siteFouille = siteFouille;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public SiteFouille getSiteFouille() {
        return siteFouille;
    }

    public void setSiteFouille(SiteFouille siteFouille) {
        this.siteFouille = siteFouille;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Parcelle.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("longueur=" + longueur)
                .add("largeur=" + largeur)
                .add("siteFouille=" + siteFouille)
                .toString();
    }
}
