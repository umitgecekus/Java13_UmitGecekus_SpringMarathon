package com.umit.service;

import com.umit.dto.request.DoktorLoginRequestDto;
import com.umit.dto.request.RegisterRequestDto;
import com.umit.dto.response.DoktorLoginResponseDto;
import com.umit.dto.response.RegisterResponseDto;
import com.umit.entity.Doktor;
import com.umit.exception.ErrorType;
import com.umit.exception.HastaneManagerException;
import com.umit.mapper.DoktorMapper;
import com.umit.repository.DoktorRepository;
import com.umit.utility.enums.Durum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoktorService {
    private final DoktorRepository doktorRepository;


    public RegisterResponseDto register(RegisterRequestDto dto) {
        Doktor doktor = DoktorMapper.INSTANCE.fromRegisterRequestDtoToDoktor(dto);
        doktorRepository.save(doktor);
        return DoktorMapper.INSTANCE.fromDoktorToRegisterResponseDto(doktor);
    }

    public DoktorLoginResponseDto login(DoktorLoginRequestDto dto) {
        Optional<Doktor> doktor = doktorRepository.findOptionalByEmailAndSifre(dto.getEmail(), dto.getSifre());
        if (doktor.isEmpty()){
            throw new RuntimeException("Bu kullanıcı bulunamadı.");
        }
        if (!doktor.get().getEmail().equals(dto.getEmail()) && !doktor.get().getSifre().equals(dto.getSifre())) {
            throw new HastaneManagerException(ErrorType.ERROR_INVALID_LOGIN_PARAMETER);
        }
        return DoktorMapper.INSTANCE.fromDoktorToLoginResponseDto(doktor.get());
    }

    public Map<String, Durum> findByDurum(){
        return doktorRepository.findAll().stream().collect(Collectors.toMap(x->x.getAd(),y->y.getDurum()));
    }

}
