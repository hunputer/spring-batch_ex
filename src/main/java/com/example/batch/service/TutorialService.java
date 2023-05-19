package com.example.batch.service;

import com.example.batch.entity.Batch;
import com.example.batch.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorialService {

    private final BookRepository bookRepository;

    public void save(Batch batch){
        bookRepository.save(batch);
    }
}
