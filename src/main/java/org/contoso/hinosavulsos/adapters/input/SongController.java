package org.contoso.hinosavulsos.adapters.input;

import org.contoso.hinosavulsos.domain.model.Song;
import org.contoso.hinosavulsos.domain.services.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/songs", produces = "application/json;charset=UTF-8")
//@CrossOrigin(origins = "*") // Allow Flutter to connect
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.findAll();
    }

    @GetMapping("/search")
    public List<Song> searchSongs(@RequestParam String q) {
        return songService.findByQuery(q);
    }

    @PostMapping
    public Song addSong(@RequestBody Song song) {
        return songService.add(song);
    }
}