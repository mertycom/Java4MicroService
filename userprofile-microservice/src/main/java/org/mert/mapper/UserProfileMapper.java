package org.mert.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface UserProfileMapper {

    UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

}
