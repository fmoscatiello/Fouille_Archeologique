package org.example.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.*;

/**
 * Singloton qui permet de generer sa propre instance.
 * l'instance du singloton est UNIQUE. elle permet de se connecter à la base de données.
 * En d'autres termes, cela nous permet de controler et de faire les requetes une par une.
 * On evite donc les conflits d'écriture
 */
public class Singloton {

    private EntityManagerFactory emf = null;
    private static Singloton instance = null;

    //instanciation de mes Dao
    private final ChercheurDao chercheurDao = new ChercheurDao();
    private final ObjetTrouveDao objetTrouveDao = new ObjetTrouveDao();
    private final EquipeDao equipeDao = new EquipeDao();
    private final ParcelleDao parcelleDao = new ParcelleDao();
    private final SiteFouilleDao siteFouilleDao = new SiteFouilleDao();


    public static Singloton getInstance() {
        if (instance==null){
            instance = new Singloton();
        }
        return instance;
    }

    /**
     * Methode permettant d'initialiser mon EntityManagerFactory
     * @param persistenceUnitName : le nom de la configuration
     * @return EntityManagerFactory
     */

    public EntityManagerFactory getEmf(String persistenceUnitName){
        if (this.emf == null) {
            this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        }
        return this.emf;
    }


    public ChercheurDao getChercheurDao() {
        return chercheurDao;
    }

    public ObjetTrouveDao getObjetTrouveDao() {
        return objetTrouveDao;
    }

    public EquipeDao getEquipeDao() {
        return equipeDao;
    }

    public ParcelleDao getParcelleDao() {
        return parcelleDao;
    }

    public SiteFouilleDao getSiteFouilleDao() {
        return siteFouilleDao;
    }
}
