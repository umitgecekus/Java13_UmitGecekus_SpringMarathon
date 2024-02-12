package com.umit.service;

import com.umit.dto.request.RandevuSaveRequestDto;
import com.umit.dto.response.RandevuSaveResponseDto;
import com.umit.entity.Doktor;
import com.umit.entity.Randevu;
import com.umit.mapper.RandevuMapper;
import com.umit.repository.DoktorRepository;
import com.umit.repository.RandevuRepository;
import com.umit.utility.enums.Durum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RandevuService {
    private final RandevuRepository randevuRepository;
    private final DoktorRepository doktorRepository;


    public RandevuSaveResponseDto randevuAl(RandevuSaveRequestDto dto) {
        Optional<Doktor> doktor = doktorRepository.findByAd(dto.getDoktorAdi());
        Randevu randevu = RandevuMapper.INSTANCE.fromRequestDtoToRandevu(dto);
        randevu.setDoktorAdi(doktor.get().getAd());
        doktor.get().setDurum(Durum.HASTA_VAR);
        randevuRepository.save(randevu);
        return RandevuMapper.INSTANCE.fromRandevuToResponseDto(randevu);
    }


    public List<Randevu> findAll(){
        return randevuRepository.findAll();
    }

    public Map<String, Date> findByDoktorAdi(String doktorAdi){
        List<Randevu> randevular = randevuRepository.findByDoktorAdi(doktorAdi);
        return randevular.stream()
                .collect(Collectors.toMap(x -> x.getHastaAdi(), y -> y.getRandevuTarihi()));
    }


}