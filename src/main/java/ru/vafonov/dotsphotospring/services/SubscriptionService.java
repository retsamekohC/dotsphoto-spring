package ru.vafonov.dotsphotospring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vafonov.dotsphotospring.orm.entities.Subscription;
import ru.vafonov.dotsphotospring.orm.entities.SubscriptionProduct;
import ru.vafonov.dotsphotospring.orm.repositories.SubscriptionRepository;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class SubscriptionService extends BaseLongIdEntityService<Subscription, SubscriptionRepository> {
    public SubscriptionService(SubscriptionRepository repository) {
        super(repository);
    }

    @Autowired
    private SubscriptionProductService subscriptionProductService;

    public Subscription createSimpleSubscription() {
        SubscriptionProduct simpleSubscriptionProduct = subscriptionProductService.getSimpleSubscriptionProduct();
        Subscription subscription = new Subscription();
        subscription.setDateFrom(Date.valueOf(LocalDate.now()));
        subscription.setDateTo(Date.valueOf(LocalDate.now().plusMonths(simpleSubscriptionProduct.getPeriodMonths())));
        subscription.setProductLink(simpleSubscriptionProduct);
        return repository.save(subscription);
    }
}
