package ru.vafonov.dotsphotospring.services;

import org.springframework.stereotype.Service;
import ru.vafonov.dotsphotospring.orm.entities.SubscriptionProduct;
import ru.vafonov.dotsphotospring.orm.repositories.SubscriptionProductRepository;

@Service
public class SubscriptionProductService extends BaseLongIdEntityService<SubscriptionProduct, SubscriptionProductRepository> {
    public SubscriptionProductService(SubscriptionProductRepository repository) {
        super(repository);
    }

    public SubscriptionProduct getSimpleSubscriptionProduct() {
        return repository.findById(1L).orElse(null);
    }
}
