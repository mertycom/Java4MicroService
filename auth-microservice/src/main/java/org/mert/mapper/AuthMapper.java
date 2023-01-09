package org.mert.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mert.dto.request.RegisterRequestDto;
import org.mert.dto.response.RegisterResponseDto;
import org.mert.repository.entity.Auth;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface AuthMapper {

    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    Auth fromRegisterRequestDto(final RegisterRequestDto dto);

    @Mappings({
            @Mapping(source = "id",target = "authid")
    })
    RegisterResponseDto fromAuth(final Auth auth);
}
