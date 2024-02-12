package com.umit.controller;

import com.umit.dto.request.DoktorLoginRequestDto;
import com.umit.dto.request.RegisterRequestDto;
import com.umit.dto.response.DoktorLoginResponseDto;
import com.umit.dto.response.RegisterResponseDto;
import com.umit.service.DoktorService;
import com.umit.utility.enums.Durum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.umit.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(DOKTOR)
public class DoktorController {

    private final DoktorService doktorService;

    @PostMapping(ADD)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(doktorService.register(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<DoktorLoginResponseDto> login(@RequestBody DoktorLoginRequestDto dto){
        return ResponseEntity.ok(doktorService.login(dto));
    }

    @GetMapping("/durum")
    public Map<String , Durum> durum(){
        return doktorService.findByDurum();
    }

}
