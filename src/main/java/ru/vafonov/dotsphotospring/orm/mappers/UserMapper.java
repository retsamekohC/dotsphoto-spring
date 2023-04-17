package ru.vafonov.dotsphotospring.orm.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vafonov.dotsphotospring.orm.dto.UserDto;
import ru.vafonov.dotsphotospring.orm.entities.User;
import ru.vafonov.dotsphotospring.services.AlbumService;
import ru.vafonov.dotsphotospring.services.SubscriptionService;

@Mapper(componentModel = "spring")
@Component
public abstract class UserMapper{

    @Autowired
    protected AlbumService albumService;

    @Autowired
    protected SubscriptionService subscriptionService;

    @Mapping(target = "rootAlbumId", expression = "java(entity.getRootAlbum().getId())")
    @Mapping(target = "subscriptionId", expression = "java(entity.getSubscription().getId())")
    public abstract UserDto entityToDto(User entity);

    @Mapping(target = "rootAlbum", expression = "java(albumService.findById(dto.getRootAlbumId()))")
    @Mapping(target = "subscription", expression = "java(subscriptionService.findById(dto.getSubscriptionId()))")
    public abstract User dtoToEntity(UserDto dto);
}
