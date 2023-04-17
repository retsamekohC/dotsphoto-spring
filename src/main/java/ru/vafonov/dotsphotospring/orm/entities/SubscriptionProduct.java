package ru.vafonov.dotsphotospring.orm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vafonov.dotsphotospring.orm.enums.DataStatuses;

@Entity
@Data
@Table(name = "subscription_product", schema = "dotsphoto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "dotsphoto.subscription_product_seq", schema = "dotsphoto", sequenceName = "dotsphoto.subscription_product_seq")
    @Column(name = "product_id")
    private Long id;
    @Basic
    @Column(name = "product_name", nullable = false, length = 9999)
    private String productName;
    @Basic
    @Column(name = "available_space_gb", nullable = false)
    private Integer availableSpaceGb;
    @Basic
    @Column(name = "period_months", nullable = false)
    private Integer periodMonths;
    @Basic
    @Column(name = "price", nullable = false)
    private Integer price;
    @Basic
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DataStatuses status;
    @Basic
    @Column(name = "show_ads", nullable = false)
    private Boolean showAds;
}
