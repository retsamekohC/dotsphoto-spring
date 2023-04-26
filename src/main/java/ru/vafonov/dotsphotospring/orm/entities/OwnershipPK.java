package ru.vafonov.dotsphotospring.orm.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OwnershipPK implements Serializable {
    private Long userId;
    private Long albumId;
}
