package ru.vafonov.dotsphotospring.orm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vafonov.dotsphotospring.orm.enums.OwnershipLevels;

@Entity
@Data
@Table(schema = "dotsphoto",name = "ownership", indexes = {
        @Index(columnList = "user_link_user_id"),
        @Index(columnList = "owned_album_album_id")
})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ownership {

    @EmbeddedId
    private OwnershipPK pk;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId("userId")
    @JoinColumn(name = "user_link_user_id")
    private User userLink;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId("albumId")
    @JoinColumn(name = "owned_album_album_id")
    private Album ownedAlbum;

    @Basic
    @Column(name = "ownership_level", nullable = false)
    @Enumerated(EnumType.STRING)
    private OwnershipLevels ownershipLevels;
}
