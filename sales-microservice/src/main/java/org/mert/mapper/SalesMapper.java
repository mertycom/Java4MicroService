package org.mert.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface SalesMapper {

    SalesMapper INSTANCE = Mappers.getMapper(SalesMapper.class);

}
