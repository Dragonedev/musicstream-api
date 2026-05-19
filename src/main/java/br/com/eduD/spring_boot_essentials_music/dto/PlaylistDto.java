package br.com.eduD.spring_boot_essentials_music.dto;

import br.com.eduD.spring_boot_essentials_music.database.model.MusicEntity;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaylistDto {
    private String name;
    private Set<MusicEntity> musics;
}
