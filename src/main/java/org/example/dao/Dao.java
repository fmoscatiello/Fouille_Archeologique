package org.example.dao;

import java.util.List;

public interface Dao<TypeObjet,PK>{

    /**
     * Methode pour recuperer tous les elements du stockage
     * @return Liste d'Objet
     */
    List<TypeObjet> findAll();

    /**
     * Methode pour recuperer un element specifique grace à son identifiant
     * @param id , clé primaire de l'élement
     * @return obj , l'élement recherché
     */
    TypeObjet findById(PK id);

    /**
     * Methode pour enregistrer un nouvel element dans mon stockage
     * @param newObj , un objet à enregistrer
     * @return newObj avec un id généré par la BDD
     */
    TypeObjet create(TypeObjet newObj);

    /**
     * Methode pour mettre à jour l'objet dans la BDD
     * @param objToUpdate , l'objet modifé à enregistrer dans la BDD
     */
    void update(TypeObjet objToUpdate);

    /**
     * Methode pour supprimer un objet à partir de sa clé primaire
     * @param id , clé primaire de l'objet à supprimer
     * @return l'objet supprimé. au cas où nous voudrions restaurer la data
     */
    TypeObjet delete(PK id);

}
