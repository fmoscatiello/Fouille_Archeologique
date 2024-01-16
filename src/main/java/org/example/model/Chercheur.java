package org.example.model;
import jakarta.persistence.*;
import java.util.StringJoiner;

/**
 * Classe chercheur.
 */
@Entity
@Table(name = "chercheur")
public class Chercheur {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private boolean estDirecteur;
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    public Chercheur() {
    }

    public Chercheur(Long id, String nom, String prenom, boolean estDirecteur, Equipe equipe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.estDirecteur = estDirecteur;
        this.equipe = equipe;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isEstDirecteur() {
        return estDirecteur;
    }

    public void setEstDirecteur(boolean estDirecteur) {
        this.estDirecteur = estDirecteur;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }



    @Override
    public String toString() {
        return new StringJoiner(", ", Chercheur.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nom='" + nom + "'")
                .add("prenom='" + prenom + "'")
                .add("estDirecteur=" + estDirecteur)
                .add("equipe=" + equipe)
                .toString();
    }
}
