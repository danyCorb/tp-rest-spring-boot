package com.ynov.nantes.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ynov.nantes.rest.entity.Author;

/**
 * Extension du Repository CRUD pour ajouter une méthode métier.
 * 
 * @author Matthieu BACHELIER
 * @since 2020-11
 * @version 1.0
 */
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    /**
     * Recherche un auteur par son nom ou son prénom.
     * 
     * @param lastname le nom
     * @param firstname le prénom
     * @return un auteur
     */
    @Query("SELECT a FROM Author a WHERE a.lastname LIKE %:lastname% or a.firstname LIKE %:firstname%")
    public Author findByName(@Param("lastname") String lastname, @Param("firstname") String firstname);

}