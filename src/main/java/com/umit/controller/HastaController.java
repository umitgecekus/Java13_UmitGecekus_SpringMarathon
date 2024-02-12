package com.umit.controller;

import com.umit.dto.request.HastaLoginRequestDto;
import com.umit.dto.response.HastaLoginResponseDto;
import com.umit.service.HastaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.umit.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(HASTA)
public class HastaController {
    private final HastaService hastaService;

    @PostMapping(LOGIN)
    public ResponseEntity<HastaLoginResponseDto> login(@RequestBody HastaLoginRequestDto dto){
        return ResponseEntity.ok(hastaService.login(dto));
    }

}