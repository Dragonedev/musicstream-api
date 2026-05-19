package br.com.eduD.spring_boot_essentials_music.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PlaylistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "music_playlist",
            joinColumns = @JoinColumn(name ="playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "music_id")
    )

    private Set<MusicEntity> musics = new HashSet<>();
}
