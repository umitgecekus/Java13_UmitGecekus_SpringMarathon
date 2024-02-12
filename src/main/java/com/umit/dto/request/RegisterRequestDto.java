package com.umit.dto.request;

import com.umit.utility.enums.Unvan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    String ad;
    String email;
    String sifre;
    Unvan unvan;
    Long bransId;
}
