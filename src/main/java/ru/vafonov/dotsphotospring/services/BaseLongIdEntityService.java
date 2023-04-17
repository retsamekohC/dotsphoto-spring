package ru.vafonov.dotsphotospring.services;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseLongIdEntityService<T, R extends JpaRepository<T, Long>> extends BaseEntityService<T, Long, R> {

    public BaseLongIdEntityService(R repository) {
        super(repository);
    }
}
