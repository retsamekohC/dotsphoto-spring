package ru.vafonov.dotsphotospring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.vafonov.dotsphotospring.orm.dto.UserDto;
import ru.vafonov.dotsphotospring.orm.entities.Album;
import ru.vafonov.dotsphotospring.orm.entities.User;
import ru.vafonov.dotsphotospring.orm.repositories.UserRepository;

import java.security.Principal;

@Service
public class UserService extends BaseLongIdEntityService<User, UserRepository> {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private OwnershipService ownershipService;

    @Autowired
    private SubscriptionService subscriptionService;

    public UserService(UserRepository repository) {
        super(repository);
    }

    public User findByNickname(String nickname) {
        return repository.findByNickname(nickname);
    }

    public User registerUser(String userNickname) {
        User user = new User();
        user.setNickname(userNickname);
        Album rootAlbum = albumService.createRootAlbumForUser(user);
        user.setRootAlbum(rootAlbum);
        user.setSubscription(subscriptionService.createSimpleSubscription());
        user = repository.save(user);
        ownershipService.createOwnershipOwner(user, rootAlbum);
        return user;
    }
}
