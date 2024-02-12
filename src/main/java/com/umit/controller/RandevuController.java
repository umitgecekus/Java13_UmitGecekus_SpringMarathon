package com.umit.controller;

import com.umit.dto.request.RandevuSaveRequestDto;
import com.umit.dto.response.RandevuSaveResponseDto;
import com.umit.entity.Randevu;
import com.umit.service.RandevuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.umit.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RANDEVU)
public class RandevuController {
    private final RandevuService randevuService;

    @PostMapping(ADD)
    public ResponseEntity<RandevuSaveResponseDto> randevuAl(@RequestBody RandevuSaveRequestDto dto){
        return ResponseEntity.ok(randevuService.randevuAl(dto));
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Randevu>> getAll(){
        return ResponseEntity.ok(randevuService.findAll());
    }

    @GetMapping("get-all-hasta")
    public ResponseEntity<Map<String , Date >> getAllHasta (String doktorAdi){
        return ResponseEntity.ok(randevuService.findByDoktorAdi(doktorAdi));
    }
}
