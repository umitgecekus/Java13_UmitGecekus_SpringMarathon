package com.umit.mapper;

import com.umit.dto.request.RegisterRequestDto;
import com.umit.dto.response.DoktorLoginResponseDto;
import com.umit.dto.response.RegisterResponseDto;
import com.umit.entity.Doktor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoktorMapper {
    DoktorMapper INSTANCE = Mappers.getMapper(DoktorMapper.class);

    DoktorLoginResponseDto fromDoktorToLoginResponseDto(final Doktor doktor);

    Doktor fromRegisterRequestDtoToDoktor(final RegisterRequestDto dto);

    RegisterResponseDto fromDoktorToRegisterResponseDto(final Doktor doktor);
}
