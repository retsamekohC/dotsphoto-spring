package ru.vafonov.dotsphotospring.orm.dto;

import lombok.Data;
import ru.vafonov.dotsphotospring.orm.entities.Photo;
import ru.vafonov.dotsphotospring.orm.enums.DataStatuses;

import java.sql.Date;

@Data
public class PhotoDto implements Dto<Photo> {
    private Long id;
    private byte[] content;
    private String filename;
    private Date createdAt;
    private Date lastUpdatedAt;
    private Long metadataId;
    private DataStatuses status;
    private Long albumId;
}
