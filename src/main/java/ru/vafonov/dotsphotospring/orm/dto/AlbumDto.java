package ru.vafonov.dotsphotospring.orm.dto;

import lombok.Data;
import ru.vafonov.dotsphotospring.orm.entities.Album;
import ru.vafonov.dotsphotospring.orm.enums.DataStatuses;

import java.sql.Date;

@Data
public class AlbumDto implements Dto<Album> {
    private String albumName;
    private Date createdAt;
    private Date lastUpdatedAt;
    private DataStatuses status;
    private Integer kilobyteSize;
}
