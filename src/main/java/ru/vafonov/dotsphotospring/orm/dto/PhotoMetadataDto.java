package ru.vafonov.dotsphotospring.orm.dto;

import lombok.Data;
import ru.vafonov.dotsphotospring.orm.entities.PhotoMetadata;

import java.sql.Date;

@Data
public class PhotoMetadataDto implements Dto<PhotoMetadata> {
    private Long id;
    private Integer widthInPixels;
    private Integer heightInPixels;
    private Integer cameraMegapixels;
    private Integer kilobyteSize;
    private String geolocation;
    private Date shotAt;
}
