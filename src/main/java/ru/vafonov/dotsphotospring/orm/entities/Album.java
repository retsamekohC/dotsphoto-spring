package ru.vafonov.dotsphotospring.orm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vafonov.dotsphotospring.orm.enums.DataStatuses;

import java.sql.Date;

@Builder
@Entity
@Data
@Table(schema = "dotsphoto", name = "album")
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator( schema = "dotsphoto", name = "album_seq", sequenceName = "album_seq")
    @Column(name = "album_id")
    private Long id;
    @Basic
    @Column(name = "album_name", nullable = false, length = 9999)
    private String albumName;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    @Basic
    @Column(name = "last_updated_at", nullable = true)
    private Date lastUpdatedAt;
    @Basic
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DataStatuses status;
    @Basic
    @Column(name = "kilobyte_size", nullable = false)
    private Integer kilobyteSize;
}
