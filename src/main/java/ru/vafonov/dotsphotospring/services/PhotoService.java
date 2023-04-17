package ru.vafonov.dotsphotospring.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.vafonov.dotsphotospring.orm.entities.Album;
import ru.vafonov.dotsphotospring.orm.entities.Ownership;
import ru.vafonov.dotsphotospring.orm.entities.Photo;
import ru.vafonov.dotsphotospring.orm.entities.User;
import ru.vafonov.dotsphotospring.orm.enums.DataStatuses;
import ru.vafonov.dotsphotospring.orm.repositories.PhotoRepository;
import ru.vafonov.dotsphotospring.utils.DateUtils;

import java.util.List;

@Service
public class PhotoService extends BaseLongIdEntityService<Photo, PhotoRepository> {

    @Autowired
    private PhotoMetadataService photoMetadataService;

    public PhotoService(PhotoRepository repository) {
        super(repository);
    }

    public List<Photo> findAllByAlbum(Album album) {
        return repository.findAllByAlbum(album);
    }

    @SneakyThrows
    public Photo savePhotoToUserRoot(MultipartFile file, User user) {
        Album album = user.getRootAlbum();
        Photo photo = new Photo(
                null,
                file.getBytes(),
                file.getOriginalFilename(),
                DateUtils.now(),
                DateUtils.now(),
                photoMetadataService.buildEmptyMetadata(),
                DataStatuses.ACTIVE,
                album
        );

        return repository.save(photo);
    }
}
