package com.umit.dto.request;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RandevuSaveRequestDto {
    String hastaAdi;
    String tcNo;
    String doktorAdi;

    @Temporal(TemporalType.DATE)
    Date randevuTarihi;



}

