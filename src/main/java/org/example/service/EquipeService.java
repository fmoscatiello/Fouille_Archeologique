package org.example.service;

import jakarta.transaction.Transactional;
import org.example.config.Singloton;
import org.example.model.Chercheur;
import org.example.model.Equipe;

public class EquipeService {

    /**
     * Methode pour créer une équipe et associer tout les chercheurs de l'équipe dans la table Chercheur
     * @param equipe , l'équipe à ajouter
     */
    @Transactional
    public void creerEquipe(Equipe equipe){

        if(verifierSiDirecteur(equipe)) {
            Equipe equipe1 = Singloton.getInstance().getEquipeDao().create(equipe);
            for (Chercheur ch : equipe1.getEquipe()) {
                ch.setEquipe(equipe1);
                Singloton.getInstance().getChercheurDao().update(ch);
            }
            System.out.println("Equipe bien créée");
        }else{
            System.out.println("Pas de création d'équipe, il n'y a pas de directeur d'assigné");
        }
    }

    /**
     * Methode pour verifier qu'il y a bien un directeur dans l'équipe
     * @param equipe , l'equipe à verifier
     * @return un boolean, true si il y a un directeur, false dans le cas contraire
     */
    public boolean verifierSiDirecteur(Equipe equipe){
        for (Chercheur ch : equipe.getEquipe()){
            if (ch.isEstDirecteur()){
                return true;
            }
        }
        return false;
    }

    public Equipe trouverEquipeById(Long id){
        Equipe equipe = Singloton.getInstance().getEquipeDao().findById(id);
        return equipe;
    }

    public void updateEquipe(Equipe equipe){
        Singloton.getInstance().getEquipeDao().update(equipe);
    }

}
