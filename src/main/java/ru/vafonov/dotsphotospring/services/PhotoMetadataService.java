package ru.vafonov.dotsphotospring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import ru.vafonov.dotsphotospring.orm.entities.PhotoMetadata;
import ru.vafonov.dotsphotospring.orm.repositories.PhotoMetadataRepository;

@Service
public class PhotoMetadataService extends BaseLongIdEntityService<PhotoMetadata, PhotoMetadataRepository> {
    public PhotoMetadataService(PhotoMetadataRepository repository) {
        super(repository);
    }

    public PhotoMetadata buildEmptyMetadata() {
        return repository.save(new PhotoMetadata());
    }
}
