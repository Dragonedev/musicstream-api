package br.com.eduD.spring_boot_essentials_music.exception;

public class NotFoundException extends Exception{

    public NotFoundException(String message){
        super(message);
    }
}
