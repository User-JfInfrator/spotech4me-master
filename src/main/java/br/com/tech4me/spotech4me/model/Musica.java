package br.com.tech4me.spotech4me.model;

import br.com.tech4me.spotech4me.shared.MusicaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Musica")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String nome;
    @Column
    private int duracao;
    @Enumerated(EnumType.STRING)
    @Column
    private estiloMusica estilo;

    public Musica(){}

    public Musica(MusicaDto dto) {
        this.nome = dto.nome();
        this.duracao = dto.duracao();
        this.estilo = dto.estilo();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public estiloMusica getEstilo() {
        return estilo;
    }
    public void setEstilo(estiloMusica estilo) {
        this.estilo = estilo;
    }

    
}
