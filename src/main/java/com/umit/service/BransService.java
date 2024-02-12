package com.umit.service;

import com.umit.entity.Brans;
import com.umit.repository.BransRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BransService {
    private final BransRepository bransRepository;

    public Boolean add(String ad) {
        Brans brans = Brans.builder()
                .ad(ad)
                .build();
        bransRepository.save(brans);
        return true;
    }


    public List<Brans> findAll() {
        return bransRepository.findAll();
    }
}
