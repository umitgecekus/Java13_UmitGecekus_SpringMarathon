package com.umit.service;

import com.umit.dto.request.HastaLoginRequestDto;
import com.umit.dto.response.HastaLoginResponseDto;
import com.umit.entity.Hasta;
import com.umit.mapper.HastaMapper;
import com.umit.repository.HastaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HastaService {
    private final HastaRepository hastaRepository;
    public HastaLoginResponseDto login(HastaLoginRequestDto dto) {
        Hasta hasta = HastaMapper.INSTANCE.fromRequestDtoToHasta(dto);
        hastaRepository.save(hasta);
        return HastaMapper.INSTANCE.fromHastaToLoginResponseDto(hasta);
    }
}