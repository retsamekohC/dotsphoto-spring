package ru.vafonov.dotsphotospring.orm.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class OwnershipPK implements Serializable {
    private Long userId;
    private Long albumId;
}
