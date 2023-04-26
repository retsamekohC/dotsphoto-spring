package ru.vafonov.dotsphotospring.orm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@Table(schema = "dotsphoto", name = "subscription", indexes = {
        @Index(columnList = "product_link")
})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "dotsphoto", name = "subscription_seq", sequenceName = "subscription_seq")
    @Column(name = "subscription_id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_link")
    private SubscriptionProduct productLink;
    @Basic
    @Column(name = "date_from", nullable = false)
    private Date dateFrom;
    @Basic
    @Column(name = "date_to", nullable = false)
    private Date dateTo;
}
