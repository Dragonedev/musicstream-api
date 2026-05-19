package br.com.eduD.spring_boot_essentials_music.controller;

import br.com.eduD.spring_boot_essentials_music.database.model.MusicEntity;
import br.com.eduD.spring_boot_essentials_music.dto.MusicDto;
import br.com.eduD.spring_boot_essentials_music.exception.NotFoundException;
import br.com.eduD.spring_boot_essentials_music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/musics")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService musicService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MusicEntity> findAll() {
        return musicService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody MusicDto musicDto){
        musicService.save(musicDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) throws NotFoundException {
        musicService.delete(id);
    }
}
