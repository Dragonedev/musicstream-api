package br.com.eduD.spring_boot_essentials_music.service;

import br.com.eduD.spring_boot_essentials_music.database.model.MusicEntity;
import br.com.eduD.spring_boot_essentials_music.database.model.PlaylistEntity;
import br.com.eduD.spring_boot_essentials_music.database.repository.IMusicRepository;
import br.com.eduD.spring_boot_essentials_music.database.repository.IPlaylistRepository;
import br.com.eduD.spring_boot_essentials_music.dto.MusicDto;
import br.com.eduD.spring_boot_essentials_music.dto.PlaylistDto;
import br.com.eduD.spring_boot_essentials_music.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final IPlaylistRepository playlistRepository;
    private final IMusicRepository musicRepository;

    public List<PlaylistEntity> findAll(){
        return playlistRepository.findAll();
    }

    public Set<MusicEntity> findMusicFromPlaylist(Integer playlistId) throws NotFoundException {
        PlaylistEntity playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new NotFoundException("Playlist não encontrada"));

        return playlist.getMusics();
    }
    public PlaylistEntity createPlaylist(PlaylistDto playlistDto){
        PlaylistEntity playlist = PlaylistEntity.builder()
                .name(playlistDto.getName())
                .build();

        return playlistRepository.save(playlist);
    }
    public PlaylistEntity addMusic(Integer playlistId, Integer musicId) throws NotFoundException {

        PlaylistEntity playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new NotFoundException("Playlist não encontrada"));

        MusicEntity music = musicRepository.findById(musicId)
                .orElseThrow(() -> new NotFoundException("Música não encontrada"));

        playlist.getMusics().add(music);

        return playlistRepository.save(playlist);
    }

    public void removeMusic(Integer playlistId, Integer musicId) throws NotFoundException{
        PlaylistEntity playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new NotFoundException("Playlist não encontrada"));

        MusicEntity music = musicRepository.findById(musicId)
                .orElseThrow(() -> new NotFoundException("Música não encontrada"));

        playlist.getMusics().remove(music);
    }

    public void deletePlaylist(Integer playlistId) throws NotFoundException{

        PlaylistEntity playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new NotFoundException("Playlist não encontrada"));

        playlistRepository.delete(playlist);
    }

}
