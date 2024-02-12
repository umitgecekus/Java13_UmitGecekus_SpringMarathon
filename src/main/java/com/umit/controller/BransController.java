package com.umit.controller;

import com.umit.entity.Brans;
import com.umit.service.BransService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.umit.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(BRANS)
public class BransController {
    private final BransService bransService;

    @PostMapping(ADD)
    public ResponseEntity<Boolean> add(@RequestBody String ad){
        return ResponseEntity.ok(bransService.add(ad));
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Brans>> getAll(){
        return ResponseEntity.ok(bransService.findAll());
    }
}