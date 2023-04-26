package ru.vafonov.dotsphotospring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vafonov.dotsphotospring.orm.entities.Album;
import ru.vafonov.dotsphotospring.orm.entities.Ownership;
import ru.vafonov.dotsphotospring.orm.entities.User;
import ru.vafonov.dotsphotospring.orm.enums.DataStatuses;
import ru.vafonov.dotsphotospring.orm.enums.OwnershipLevels;
import ru.vafonov.dotsphotospring.orm.repositories.AlbumRepository;

import java.sql.Date;

@Service
public class AlbumService extends BaseLongIdEntityService<Album, AlbumRepository> {

    public AlbumService(AlbumRepository repository) {
        super(repository);
    }

    public Album createRootAlbumForUser(User user) {
        if (user.getRootAlbum() != null) {
            return user.getRootAlbum();
        }

        Album album = new Album();
        album.setAlbumName(user.getNickname());
        album.setCreatedAt(new Date(new java.util.Date().getTime()));
        album.setLastUpdatedAt(new Date(new java.util.Date().getTime()));
        album.setStatus(DataStatuses.ACTIVE);
        album.setKilobyteSize(0);
        album = repository.save(album);
        return album;
    }
}
