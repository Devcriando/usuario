package com.emerson.usuario.infrastructure.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String mensagem){
        super(mensagem);
    }

    public ResourceNotFoundException(String mensgem, Throwable throwable){
        super(mensgem,throwable);
    }
}
