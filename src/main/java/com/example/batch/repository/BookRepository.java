package com.example.batch.repository;

import com.example.batch.entity.Batch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final EntityManager em;

    public void save(Batch batch){
        em.persist(batch);
    }
}
