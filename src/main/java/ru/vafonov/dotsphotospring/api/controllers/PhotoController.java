package ru.vafonov.dotsphotospring.api.controllers;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.vafonov.dotsphotospring.orm.dto.PhotoDto;
import ru.vafonov.dotsphotospring.orm.entities.OwnershipPK;
import ru.vafonov.dotsphotospring.orm.entities.Photo;
import ru.vafonov.dotsphotospring.orm.entities.User;
import ru.vafonov.dotsphotospring.orm.mappers.PhotoMapper;
import ru.vafonov.dotsphotospring.services.OwnershipService;
import ru.vafonov.dotsphotospring.services.PhotoService;
import ru.vafonov.dotsphotospring.services.UserService;
import ru.vafonov.dotsphotospring.utils.JwtTokenUtils;

import java.util.List;

@RestController
@RequestMapping(path = "/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private UserService userService;

    @Autowired
    private OwnershipService ownershipService;

    private final PhotoMapper mapper = Mappers.getMapper(PhotoMapper.class);

    @GetMapping
    public ResponseEntity<List<PhotoDto>> getAll(JwtAuthenticationToken token) {
        User user = userService.findByNickname(JwtTokenUtils.getUserNameFromToken(token));
        return ResponseEntity.ok(photoService.findAllByAlbum(user.getRootAlbum()).stream().map(mapper::entityToDto).toList());
    }

    @GetMapping(path="/ids")
    public ResponseEntity<List<Long>> getAllIds(JwtAuthenticationToken token) {
        User user = userService.findByNickname(JwtTokenUtils.getUserNameFromToken(token));
        return ResponseEntity.ok(photoService.findAllByAlbum(user.getRootAlbum()).stream().map(Photo::getId).toList());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<PhotoDto> getPhoto(JwtAuthenticationToken token, @PathVariable String id) {
        try {
            Long photoId = Long.parseLong(id);
            Photo photo = photoService.findById(photoId);
            User user = userService.findByNickname(JwtTokenUtils.getUserNameFromToken(token));
            if (ownershipService.findById(new OwnershipPK(photo.getAlbum().getId(), user.getId())) != null) {
                return ResponseEntity.ok(mapper.entityToDto(photo));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<PhotoDto> postPhoto(JwtAuthenticationToken token, MultipartFile file) {
        User user = userService.findByNickname(JwtTokenUtils.getUserNameFromToken(token));
        return ResponseEntity.ok(mapper.entityToDto(photoService.savePhotoToUserRoot(file, user)));
    }
}
