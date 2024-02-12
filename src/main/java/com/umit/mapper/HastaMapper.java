package com.umit.mapper;

import com.umit.dto.request.HastaLoginRequestDto;
import com.umit.dto.response.HastaLoginResponseDto;
import com.umit.entity.Hasta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HastaMapper {
    HastaMapper INSTANCE = Mappers.getMapper(HastaMapper.class);

    HastaLoginResponseDto fromHastaToLoginResponseDto(final Hasta hasta);

    Hasta fromRequestDtoToHasta(final HastaLoginRequestDto dto);

}
