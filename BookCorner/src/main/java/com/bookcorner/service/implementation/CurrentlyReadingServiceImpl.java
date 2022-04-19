//package com.bookcorner.service.implementation;
//
//import com.bookcorner.model.Currently_reading;
//import com.bookcorner.repository.CurrentlyReadingRepository;
//import com.bookcorner.service.CurrentlyReadingService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CurrentlyReadingServiceImpl implements CurrentlyReadingService {
//    private final CurrentlyReadingRepository currentlyReadingRepository;
//
//    public CurrentlyReadingServiceImpl(CurrentlyReadingRepository currentlyReadingRepository) {
//        this.currentlyReadingRepository = currentlyReadingRepository;
//    }
//
//    @Override
//    public List<Currently_reading> findAll() {
//        return this.currentlyReadingRepository.findAll();
//    }
//
//    @Override
//    public Optional<Currently_reading> findById(Long id) {
//        return this.currentlyReadingRepository.findById(id);
//    }
//}
