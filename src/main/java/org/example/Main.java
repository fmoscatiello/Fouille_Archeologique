package org.example;

import org.example.model.*;
import org.example.service.ChercheurService;
import org.example.service.EquipeService;
import org.example.service.ObjetService;
import org.example.service.SiteFouilleService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SiteFouille siteFouille = new SiteFouille();
        siteFouille.setDesignation("Lille");
        SiteFouilleService siteFouilleService = new SiteFouilleService();
        siteFouilleService.creerSite(siteFouille);
    }
}