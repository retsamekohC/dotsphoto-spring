package ru.vafonov.dotsphotospring.services;

import org.springframework.stereotype.Service;
import ru.vafonov.dotsphotospring.orm.entities.Album;
import ru.vafonov.dotsphotospring.orm.entities.Ownership;
import ru.vafonov.dotsphotospring.orm.entities.OwnershipPK;
import ru.vafonov.dotsphotospring.orm.entities.User;
import ru.vafonov.dotsphotospring.orm.enums.OwnershipLevels;
import ru.vafonov.dotsphotospring.orm.repositories.OwnershipRepository;

@Service
public class OwnershipService extends BaseEntityService<Ownership, OwnershipPK, OwnershipRepository> {
    public OwnershipService(OwnershipRepository repository) {
        super(repository);
    }

    public Ownership createOwnershipOwner(User user, Album album) {
        Ownership ownership = new Ownership();
        ownership.setOwnedAlbum(album);
        ownership.setUserLink(user);
        ownership.setOwnershipLevels(OwnershipLevels.OWNER);
        return repository.save(ownership);
    }
}
