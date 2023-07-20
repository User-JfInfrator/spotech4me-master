package br.com.tech4me.spotech4me.shared;

import br.com.tech4me.spotech4me.model.estiloMusica;

public record MusicaDto(Integer id, String nome, int duracao, estiloMusica estilo) {
    
}
