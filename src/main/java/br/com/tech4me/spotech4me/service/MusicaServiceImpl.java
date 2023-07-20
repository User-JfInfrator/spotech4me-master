package br.com.tech4me.spotech4me.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.spotech4me.Repository.MusicaRepository;
import br.com.tech4me.spotech4me.model.Musica;
import br.com.tech4me.spotech4me.shared.MusicaDto;
import br.com.tech4me.spotech4me.shared.MusicaListagemDto;

@Service
public class MusicaServiceImpl implements MusicaService {
    @Autowired
    private MusicaRepository repositorio;
    
    
    @Override
    public List<MusicaListagemDto> obterTodasMusicas() {
        return repositorio.findAll()
        .stream()
        .map(p -> new MusicaListagemDto(p.getNome(), p.getEstilo())).toList();
    }

    @Override
    public Optional<MusicaDto> obterMusicaPorId(Integer id) {
        Optional<Musica> musica = repositorio.findById(id);
        if(musica.isPresent()){
            return Optional.of(new MusicaDto(musica.get().getId(), musica.get().getNome(), musica.get().getDuracao(), musica.get().getEstilo()));
        }
        else{
            return Optional.empty();
        }
    
    }

    @Override
    public MusicaDto cadastrarMusica(MusicaDto dto) {
        Musica musica = new Musica(dto);
        repositorio.save(musica);

        return new MusicaDto(musica.getId(), musica.getNome(), musica.getDuracao(), musica.getEstilo());
    }

    @Override
    public Optional<MusicaDto> atualizarPorId(Integer id, MusicaDto dto) {
        Optional<Musica> musica = repositorio.findById(id);

        if(musica.isPresent()){
         Musica musicaAtualizada = new Musica(dto);
         musicaAtualizada.setId(id);
         repositorio.save(musicaAtualizada);
         return Optional.of(new MusicaDto(musicaAtualizada.getId(), musicaAtualizada.getNome(), musicaAtualizada.getDuracao(), musicaAtualizada.getEstilo()));
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public void excluirPorId(Integer id) {
        repositorio.deleteById(id);
    }
    
}
