package ru.vafonov.dotsphotospring.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vafonov.dotsphotospring.orm.entities.Album;
import ru.vafonov.dotsphotospring.services.AlbumService;

import java.util.List;

@RestController
@RequestMapping(path = "/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Album>> getAll() {
        return ResponseEntity.ok(albumService.findAll());
    }
}
