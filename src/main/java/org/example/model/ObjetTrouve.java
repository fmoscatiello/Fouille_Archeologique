package org.example.model;

import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
public class ObjetTrouve {

    @Id
    @GeneratedValue
    private Long id;
    private String designation;
    private String categorie;
    @Enumerated(EnumType.STRING)
    private Completude etatCompletude;

 //Si true , pas besoin de le restaurer. sinon il faut le restaurer
    private boolean enBonEtat;
    @ManyToOne
    @JoinColumn(name = "parcelle_id")
    private Parcelle parcelle;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipeTrouve;

    public ObjetTrouve(){}

    public ObjetTrouve(Long id, String designation, String categorie, Completude etatCompletude, boolean enBonEtat, Parcelle parcelle) {
        this.id = id;
        this.designation = designation;
        this.categorie = categorie;
        this.etatCompletude = etatCompletude;
        this.enBonEtat = enBonEtat;
        this.parcelle = parcelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Completude getEtatCompletude() {
        return etatCompletude;
    }

    public void setEtatCompletude(Completude etatCompletude) {
        this.etatCompletude = etatCompletude;
    }

    public boolean isEnBonEtat() {
        return enBonEtat;
    }

    public void setEnBonEtat(boolean enBonEtat) {
        this.enBonEtat = enBonEtat;
    }

    public Parcelle getParcelle() {
        return parcelle;
    }

    public void setParcelle(Parcelle parcelle) {
        this.parcelle = parcelle;
    }

    public Equipe getEquipeTrouve() {
        return equipeTrouve;
    }

    public void setEquipeTrouve(Equipe equipeTrouve) {
        this.equipeTrouve = equipeTrouve;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ObjetTrouve.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("designation='" + designation + "'")
                .add("categorie='" + categorie + "'")
                .add("etatCompletude=" + etatCompletude)
                .add("enBonEtat=" + enBonEtat)
                .add("parcelle=" + parcelle)
                .toString();
    }
}
