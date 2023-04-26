package ru.vafonov.dotsphotospring.orm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(schema = "dotsphoto", name = "user", indexes = {
        @Index(columnList = "root_album_link"),
        @Index(columnList = "subscription_link"),
        @Index(columnList = "nickname")
})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "dotsphoto", name = "user_seq", sequenceName = "user_seq")
    @Column(name = "user_id")
    private Long id;
    @Basic
    @Column(name = "nickname", nullable = false, length = 9999, unique = true)
    private String nickname;
    @Basic
    @Column(name = "email", nullable = true, length = 9999)
    private String email;
    @Basic
    @Column(name = "full_name", nullable = true, length = 9999)
    private String fullName;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "root_album_link", nullable = false)
    private Album rootAlbum;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subscription_link", nullable = false)
    private Subscription subscription;
}
