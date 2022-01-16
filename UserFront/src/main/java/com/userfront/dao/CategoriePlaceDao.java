package com.userfront.dao;

import com.userfront.domain.tennis.CategoriePlace;
import com.userfront.domain.tennis.Emplacement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriePlaceDao extends CrudRepository<CategoriePlace, Long> {
    List<CategoriePlace> findAll();

    CategoriePlace findById(Long id);

    void deleteById(Long id);
}
