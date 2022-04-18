package com.bookcorner.service.implementation;

import com.bookcorner.model.Read_books;
import com.bookcorner.repository.ReadBooksRepository;
import com.bookcorner.service.ReadBooksService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadBooksServiceImpl implements ReadBooksService {
    private final ReadBooksRepository readBooksRepository;

    public ReadBooksServiceImpl(ReadBooksRepository readBooksRepository) {
        this.readBooksRepository = readBooksRepository;
    }

    @Override
    public List<Read_books> findAll() {
        return this.readBooksRepository.findAll();
    }

    @Override
    public Optional<Read_books> findById(Long id) {
        return this.readBooksRepository.findById(id);
    }
}
