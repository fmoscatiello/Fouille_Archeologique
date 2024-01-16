package org.example.service;

import org.example.config.Singloton;
import org.example.model.SiteFouille;

public class SiteFouilleService {

    public void creerSite(SiteFouille siteFouille){
        SiteFouille newSiteFouille = Singloton.getInstance().getSiteFouilleDao().create(siteFouille);
        System.out.println(newSiteFouille);
    }
}
