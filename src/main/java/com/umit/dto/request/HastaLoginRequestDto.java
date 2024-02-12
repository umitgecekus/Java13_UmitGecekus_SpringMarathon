package com.umit.dto.request;

import com.umit.utility.enums.Cinsiyet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HastaLoginRequestDto {
    String ad;
    String tcNo;
    String telefon;
    String adres;
    Integer yas;
    Cinsiyet cinsiyet;
}