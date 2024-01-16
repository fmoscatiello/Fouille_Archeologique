package org.example.service;

import org.example.config.Singloton;
import org.example.model.Chercheur;

import java.util.List;

public class ChercheurService {

    public void creerChercheur(Chercheur chercheur){
        Chercheur newChercheur = Singloton.getInstance().getChercheurDao().create(chercheur);
        System.out.println(newChercheur);
    }

    public List<Chercheur> afficherTousLesChercheurs(){
        List<Chercheur> chercheurs = Singloton.getInstance().getChercheurDao().findAll();
        for(Chercheur c : chercheurs){
            System.out.println(c);
        }
        return chercheurs;
    }

    public void miseAJourChercheur(){

    }

}
