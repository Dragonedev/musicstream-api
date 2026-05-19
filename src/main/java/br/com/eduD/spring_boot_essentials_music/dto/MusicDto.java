package br.com.eduD.spring_boot_essentials_music.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MusicDto {

    private String title;
    private String artist;
    private Integer plays;
}
