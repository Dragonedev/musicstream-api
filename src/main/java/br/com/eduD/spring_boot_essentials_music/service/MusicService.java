package br.com.eduD.spring_boot_essentials_music.service;

import br.com.eduD.spring_boot_essentials_music.database.model.MusicEntity;
import br.com.eduD.spring_boot_essentials_music.database.repository.IMusicRepository;
import br.com.eduD.spring_boot_essentials_music.dto.MusicDto;
import br.com.eduD.spring_boot_essentials_music.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final IMusicRepository musicRepository;

    public List<MusicEntity> findAll(){
        return musicRepository.findAll();
    }

    public void save(MusicDto musicDto){
        MusicEntity newMusic = MusicEntity.builder()
                        .title(musicDto.getTitle())
                        .artist(musicDto.getArtist())
                        .plays(musicDto.getPlays())
                .build();

        musicRepository.save(newMusic);
    }

    public void delete(Integer id) throws NotFoundException {

        if(!musicRepository.existsById(id)){
            throw new NotFoundException("Música não encontrada");
        }

        musicRepository.deleteById(id);
    }
}
