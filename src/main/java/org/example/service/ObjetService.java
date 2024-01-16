package org.example.service;

import org.example.config.Singloton;
import org.example.model.ObjetTrouve;

import java.util.List;

public class ObjetService {

    public void creerObjet(ObjetTrouve newObjet){
        ObjetTrouve objet = Singloton.getInstance().getObjetTrouveDao().create(newObjet);
        System.out.println(objet);
    }

    public List<ObjetTrouve> findAll(){
        List<ObjetTrouve> objetTrouveList = Singloton.getInstance().getObjetTrouveDao().findAll();
        return objetTrouveList;
    }

    public ObjetTrouve findById(Long id){
        ObjetTrouve objetTrouve = Singloton.getInstance().getObjetTrouveDao().findById(id);
        return objetTrouve;
    }

    public void updateObjet(ObjetTrouve objetTrouve){
        Singloton.getInstance().getObjetTrouveDao().update(objetTrouve);
    }

}
