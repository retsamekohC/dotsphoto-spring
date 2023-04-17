package ru.vafonov.dotsphotospring.orm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vafonov.dotsphotospring.orm.enums.DataStatuses;

import java.sql.Date;

@Entity
@Data
@Table(name = "photo", schema = "dotsphoto", indexes = {
        @Index(columnList = "metadata_link"),
        @Index(columnList = "album_link")
})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "dotsphoto.photo_seq", schema = "dotsphoto", sequenceName = "dotsphoto.photo_seq")
    @Column(name = "photo_id")
    private Long id;
    @Basic
    @Column(name = "content", nullable = false)
    private byte[] content;
    @Basic
    @Column(name = "filename", nullable = false, length = 9999)
    private String filename;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    @Basic
    @Column(name = "last_updated_at", nullable = true)
    private Date lastUpdatedAt;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "metadata_link", nullable = false)
    private PhotoMetadata metadata;
    @Basic
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DataStatuses status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_link", nullable = false)
    private Album album;
}
