package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.StringJoiner;

@Entity
public class SiteFouille {
    @Id
    @GeneratedValue
    private Long id;
    private String designation;
    @OneToMany(mappedBy = "siteFouille")
    private List<Parcelle> parcelles;
    public SiteFouille(){}

    public SiteFouille(Long id, List<Parcelle> parcelles) {
        this.id = id;
        this.parcelles = parcelles;
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

    public List<Parcelle> getParcelles() {
        return parcelles;
    }

    public void setParcelles(List<Parcelle> parcelles) {
        this.parcelles = parcelles;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SiteFouille.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("designation='" + designation + "'")
                .add("parcelles=" + parcelles)
                .toString();
    }
}
