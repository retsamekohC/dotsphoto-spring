package ru.vafonov.dotsphotospring.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vafonov.dotsphotospring.orm.entities.Album;
import ru.vafonov.dotsphotospring.orm.entities.Photo;

import java.util.List;

@Repository
public interface PhotoRepository  extends JpaRepository<Photo, Long> {

    List<Photo> findAllByAlbum(Album album);
}
