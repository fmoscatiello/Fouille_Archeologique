package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.config.Singloton;
import org.example.model.SiteFouille;
import java.util.ArrayList;
import java.util.List;

public class SiteFouilleDao implements Dao<SiteFouille,Long> {

    /**
     * Methode pour recuperer tous les elements du stockage
     *
     * @return Liste d'Objet
     */
    @Override
    public List<SiteFouille> findAll() {
        List<SiteFouille> siteFouilles = new ArrayList<>();
        //initialisation de mon EntityManager
        EntityManager em = null;
        //Initialisationde la transaction
        EntityTransaction tx = null;

        try {
            em = Singloton.getInstance().getEmf("archeo").createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            TypedQuery<SiteFouille> query = em.createQuery("SELECT che FROM SiteFouilleService che", SiteFouille.class);
            siteFouilles = query.getResultList();
            tx.commit();
        }catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
                em.close();
            }
            e.printStackTrace();
        }finally {
            if (em != null){
                em.close();
            }
        }
        return siteFouilles;
    }

    /**
     * Methode pour recuperer un element specifique grace à son identifiant
     *
     * @param id , clé primaire de l'élement
     * @return obj , l'élement recherché
     */
    @Override
    public SiteFouille findById(Long id) {
        SiteFouille siteFouille = null;
        //initialisation de mon EntityManager
        EntityManager em = null;
        //Initialisationde la transaction
        EntityTransaction tx = null;
        try{
            em = Singloton.getInstance().getEmf("archeo").createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            siteFouille = em.find(SiteFouille.class,id);
            tx.commit();

        }catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
                em.close();
            }
            e.printStackTrace();
        }finally {
            if (em != null){
                em.close();
            }
        }
        return siteFouille;
    }

    /**
     * Methode pour enregistrer un nouvel element dans mon stockage
     *
     * @param newObj , un objet à enregistrer
     * @return newObj avec un id généré par la BDD
     */
    @Override
    public SiteFouille create(SiteFouille newObj) {
        SiteFouille siteFouille = null;
        //initialisation de mon EntityManager
        EntityManager em = null;
        //Initialisationde la transaction
        EntityTransaction tx = null;
        try{
            em = Singloton.getInstance().getEmf("archeo").createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            // On créé l'objet et on le stoque ensuite dnas la variable
            //afin de voir qu'après insertion, on a bien un id attribué par la BDD
            siteFouille = em.merge(newObj);
            tx.commit();

        }catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
                em.close();
            }
            e.printStackTrace();
        }finally {
            if (em != null){
                em.close();
            }
        }
        return siteFouille;
    }

    /**
     * Methode pour mettre à jour l'objet dans la BDD
     *
     * @param objToUpdate , l'objet modifé à enregistrer dans la BDD
     */
    @Override
    public void update(SiteFouille objToUpdate) {
        //initialisation de mon EntityManager
        EntityManager em = null;
        //Initialisationde la transaction
        EntityTransaction tx = null;
        try{
            em = Singloton.getInstance().getEmf("archeo").createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(objToUpdate);
            tx.commit();

        }catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
                em.close();
            }
            e.printStackTrace();
        }finally {
            if (em != null){
                em.close();
            }
        }

    }

    /**
     * Methode pour supprimer un objet à partir de sa clé primaire
     *
     * @param id , clé primaire de l'objet à supprimer
     * @return l'objet supprimé. au cas où nous voudrions restaurer la data
     */
    @Override
    public SiteFouille delete(Long id) {
        SiteFouille siteFouille = null;
        //initialisation de mon EntityManager
        EntityManager em = null;
        //Initialisationde la transaction
        EntityTransaction tx = null;
        try{
            em = Singloton.getInstance().getEmf("archeo").createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            // On recupere l'objet grace à son id et on le stoque ensuite dnas la variable
            siteFouille = em.find(SiteFouille.class,id);
            //On supprime l'objet de la BDD
            em.remove(siteFouille);
            tx.commit();

        }catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
                em.close();
            }
            e.printStackTrace();
        }finally {
            if (em != null){
                em.close();
            }
        }
        return siteFouille;
    }
}
