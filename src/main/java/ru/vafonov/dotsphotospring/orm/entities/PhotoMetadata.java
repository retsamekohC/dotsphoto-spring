package ru.vafonov.dotsphotospring.orm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@Table(name = "photo_metadata", schema = "dotsphoto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "dotsphoto.photo_metadata_seq", schema = "dotsphoto", sequenceName = "dotsphoto.photo_metadata_seq")
    @Column(name = "metadata_id")
    private Long id;
    @Basic
    @Column(name = "width_in_pixels", nullable = true)
    private Integer widthInPixels;
    @Basic
    @Column(name = "height_in_pixels", nullable = true)
    private Integer heightInPixels;
    @Basic
    @Column(name = "camera_megapixels", nullable = true)
    private Integer cameraMegapixels;
    @Basic
    @Column(name = "kilobyte_size", nullable = true)
    private Integer kilobyteSize;
    @Basic
    @Column(name = "geolocation", nullable = true, length = 9999)
    private String geolocation;
    @Basic
    @Column(name = "shot_at", nullable = true)
    private Date shotAt;
}
