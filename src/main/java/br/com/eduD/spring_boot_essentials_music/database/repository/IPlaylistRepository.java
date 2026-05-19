package br.com.eduD.spring_boot_essentials_music.database.repository;

import br.com.eduD.spring_boot_essentials_music.database.model.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylistRepository extends JpaRepository<PlaylistEntity, Integer> {

}
