package org.contoso.hinosavulsos.domain.services;

import org.contoso.hinosavulsos.domain.model.Song;
import org.contoso.hinosavulsos.ports.output.SongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public List<Song> findByQuery(String q) {
        String formattedQuery = q.toLowerCase();

        Set<Song> uniqueSongs = new LinkedHashSet<>();

        uniqueSongs.addAll(songRepository.findByTitleContainsIgnoreCase(formattedQuery));
        uniqueSongs.addAll(songRepository.findByArtistContainsIgnoreCase(formattedQuery));
        uniqueSongs.addAll(songRepository.findByLyricsContainsIgnoreCase(formattedQuery));

        return new ArrayList<>(uniqueSongs);
    }

    public Song add(Song song) {
        return songRepository.save(song);
    }
}
