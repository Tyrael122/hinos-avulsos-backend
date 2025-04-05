package org.contoso.hinosavulsos.ports.output;

import org.contoso.hinosavulsos.domain.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends MongoRepository<Song, String> {

    List<Song> findByTitleContainsIgnoreCase(String title);
    List<Song> findByArtistContainsIgnoreCase(String artist);
    List<Song> findByLyricsContainsIgnoreCase(String lyrics);
}