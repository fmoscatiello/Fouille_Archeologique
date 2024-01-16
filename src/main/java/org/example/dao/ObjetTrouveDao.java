package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.config.Singloton;
import org.example.model.ObjetTrouve;

import java.util.ArrayList;
import java.util.List;

public class ObjetTrouveDao implements Dao<ObjetTrouve,Long> {


    /**
     * Methode pour recuperer tous les elements du stockage
     *
     * @return Liste d'Objet
     */
    @Override
    public List<ObjetTrouve> findAll() {
        List<ObjetTrouve> objets = new ArrayList<>();
        //initialisation de mon EntityManager
        EntityManager em = null;
        //Initialisationde la transaction
        EntityTransaction tx = null;

        try {
            em = Singloton.getInstance().getEmf("archeo").createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            TypedQuery<ObjetTrouve> query = em.createQuery("SELECT che FROM ObjetTrouve che", ObjetTrouve.class);
            objets = query.getResultList();
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
        return objets;
    }

    /**
     * Methode pour recuperer un element specifique grace à son identifiant
     *
     * @param id , clé primaire de l'élement
     * @return obj , l'élement recherché
     */
    @Override
    public ObjetTrouve findById(Long id) {
        ObjetTrouve objet = null;
        //initialisation de mon EntityManager
        EntityManager em = null;
        //Initialisationde la transaction
        EntityTransaction tx = null;
        try{
            em = Singloton.getInstance().getEmf("archeo").createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            objet = em.find(ObjetTrouve.class,id);
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
        return objet;
    }

    /**
     * Methode pour enregistrer un nouvel element dans mon stockage
     *
     * @param newObj , un objet à enregistrer
     * @return newObj avec un id généré par la BDD
     */
    @Override
    public ObjetTrouve create(ObjetTrouve newObj) {
        ObjetTrouve objet = null;
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
            objet = em.merge(newObj);
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
        return objet;
    }

    /**
     * Methode pour mettre à jour l'objet dans la BDD
     *
     * @param objToUpdate , l'objet modifé à enregistrer dans la BDD
     */
    @Override
    public void update(ObjetTrouve objToUpdate) {
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
    public ObjetTrouve delete(Long id) {
        ObjetTrouve objet = null;
        //initialisation de mon EntityManager
        EntityManager em = null;
        //Initialisationde la transaction
        EntityTransaction tx = null;
        try{
            em = Singloton.getInstance().getEmf("archeo").createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            // On recupere l'objet grace à son id et on le stoque ensuite dnas la variable
            objet = em.find(ObjetTrouve.class,id);
            //On supprime l'objet de la BDD
            em.remove(objet);
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
        return objet;
    }
}
