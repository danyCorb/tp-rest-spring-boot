package com.ynov.nantes.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ynov.nantes.rest.entity.Book;

/**
 * Extension du Repository CRUD pour ajouter une méthode métier.
 * 
 * @author Matthieu BACHELIER
 * @since 2020-11
 * @version 1.0
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

    /**
     * Recherche un livre selon son titre.
     * 
     * @param title paramètre de recherche
     * @return un livre
     */
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
    public List<Book> findByTitle(@Param("title") String title);

}