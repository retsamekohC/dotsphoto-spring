package ru.vafonov.dotsphotospring.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseEntityService<T, K, R extends JpaRepository<T, K>> {


    protected final R repository;

    public BaseEntityService(R repository) {
        this.repository = repository;
    }

    /**
     * Получить все записи из таблицы
     * @return список энтити
     */
    public List<T> findAll() {
        return repository.findAll();
    }

    /**
     * Сохранить энтити в таблицу
     * @param entity энтити для сохранения
     * @return сохраненная энтити
     */
    public T save(T entity) {
        return repository.save(entity);
    }

    /**
     * Удалить запись в таблице по айди
     * @param id айди удаляемой записи
     */
    public void delete(K id) {
        repository.deleteById(id);
    }

    /**
     * Найти запись по айди
     * @param id айди нужной записи
     * @return энтити
     */
    public T findById(K id) {
        return repository.findById(id).orElse(null);
    }
}
