package com.userfront.dao;

import com.userfront.domain.tennis.CategorieBillet;
import com.userfront.domain.tennis.CategoriePlace;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategorieBilletDao extends CrudRepository<CategorieBillet, Long> {
    List<CategorieBillet> findAll();

    CategorieBillet findById(Long id);

    void deleteById(Long id);
}
