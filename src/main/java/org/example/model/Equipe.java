package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Classe Equipe qui est composée de son identifiant, et d'une liste de Chercheurs
 */
@Entity
public class Equipe {
    @Id
    @GeneratedValue
    private Long id;
    private String nom ;

    @OneToMany(mappedBy = "equipe")
    private List<Chercheur> equipe;

    @OneToMany(mappedBy = "equipeTrouve", fetch = FetchType.EAGER)
    private List<ObjetTrouve> objetTrouves;

    public Equipe() {
    }

    public Equipe(Long id, String nom, List<Chercheur> equipe, List<ObjetTrouve> objetTrouves) {
        this.id = id;
        this.nom = nom;
        this.equipe = equipe;
        this.objetTrouves = objetTrouves;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Chercheur> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<Chercheur> equipe) {
        this.equipe = equipe;
    }

    public List<ObjetTrouve> getObjetTrouves() {
        return objetTrouves;
    }

    public void setObjetTrouves(List<ObjetTrouve> objetTrouves) {
        this.objetTrouves = objetTrouves;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Equipe.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nom='" + nom + "'")
                .add("equipe=" + equipe)
                .add("objetTrouves=" + objetTrouves)
                .toString();
    }
}
