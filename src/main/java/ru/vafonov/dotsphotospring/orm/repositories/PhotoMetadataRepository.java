package ru.vafonov.dotsphotospring.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vafonov.dotsphotospring.orm.entities.PhotoMetadata;

@Repository
public interface PhotoMetadataRepository extends JpaRepository<PhotoMetadata, Long> {

}
