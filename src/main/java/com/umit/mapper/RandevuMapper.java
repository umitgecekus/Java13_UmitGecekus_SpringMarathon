package com.umit.mapper;

import com.umit.dto.request.RandevuSaveRequestDto;
import com.umit.dto.response.RandevuSaveResponseDto;
import com.umit.entity.Randevu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RandevuMapper {
    RandevuMapper INSTANCE = Mappers.getMapper(RandevuMapper.class);

    RandevuSaveResponseDto fromRandevuToResponseDto(final Randevu randevu);

    Randevu fromRequestDtoToRandevu(final RandevuSaveRequestDto dto);

}
