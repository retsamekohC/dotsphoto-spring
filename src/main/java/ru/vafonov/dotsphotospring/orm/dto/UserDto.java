package ru.vafonov.dotsphotospring.orm.dto;

import lombok.Builder;
import lombok.Data;
import ru.vafonov.dotsphotospring.orm.entities.User;

@Data
@Builder
public class UserDto implements Dto<User>{
    private Long id;
    private String nickname;
    private String email;
    private String fullName;
    private String passwordHash;
    private Long rootAlbumId;
    private Long subscriptionId;
}
