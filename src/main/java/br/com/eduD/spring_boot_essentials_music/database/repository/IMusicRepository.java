package br.com.eduD.spring_boot_essentials_music.database.repository;

import br.com.eduD.spring_boot_essentials_music.database.model.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<MusicEntity, Integer> {
}
