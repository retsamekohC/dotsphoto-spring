package ru.vafonov.dotsphotospring.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vafonov.dotsphotospring.orm.entities.Ownership;
import ru.vafonov.dotsphotospring.orm.entities.OwnershipPK;

@Repository
public interface OwnershipRepository extends JpaRepository<Ownership, OwnershipPK> {
}
