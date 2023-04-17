package ru.vafonov.dotsphotospring.orm.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vafonov.dotsphotospring.orm.dto.PhotoDto;
import ru.vafonov.dotsphotospring.orm.entities.Photo;
import ru.vafonov.dotsphotospring.services.PhotoMetadataService;

@Mapper(componentModel = "spring")
@Component
public abstract class PhotoMapper {
    @Autowired
    protected PhotoMetadataService photoMetadataService;

    @Mapping(target = "metadataId", expression = "java(entity.getMetadata().getId())")
    public abstract PhotoDto entityToDto(Photo entity);

    @Mapping(target = "metadata", expression = "java(photoMetadataService.findById(dto.getMetadataId()))")
    public abstract Photo dtoToEntity(PhotoDto dto);
}
