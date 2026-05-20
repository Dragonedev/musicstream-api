package br.com.eduD.spring_boot_essentials_music.controller;

import br.com.eduD.spring_boot_essentials_music.database.model.MusicEntity;
import br.com.eduD.spring_boot_essentials_music.database.model.PlaylistEntity;
import br.com.eduD.spring_boot_essentials_music.dto.PlaylistDto;
import br.com.eduD.spring_boot_essentials_music.exception.NotFoundException;
import br.com.eduD.spring_boot_essentials_music.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlaylistEntity> findAll(){
        return playlistService.findAll();
    }

    @GetMapping("{playlistId}")
    @ResponseStatus(HttpStatus.OK)
    public Set<MusicEntity> getMusicByPlaylistId(@PathVariable Integer playlistId) throws NotFoundException{
        return playlistService.findMusicFromPlaylist(playlistId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PlaylistDto playlistDto){
        playlistService.createPlaylist(playlistDto);
    }

    @PostMapping("/{playlistId}/musics/{musicId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@PathVariable Integer playlistId, @PathVariable Integer musicId) throws NotFoundException {
        playlistService.addMusic(playlistId, musicId);
    }

    @DeleteMapping("/{playlistId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer playlistId) throws NotFoundException{
        playlistService.deletePlaylist(playlistId);
    }

    @DeleteMapping("/{playlistId}/musics/{musicId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Integer playlistId, @PathVariable Integer musicId) throws NotFoundException{
        playlistService.removeMusic(playlistId, musicId);
    }
}
