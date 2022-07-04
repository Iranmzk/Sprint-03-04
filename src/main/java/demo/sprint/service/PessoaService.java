package demo.sprint.service;

import demo.sprint.configuration.ApiRequestException;
import demo.sprint.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.sprint.repository.PessoaRepositorio;


import java.util.List;


@Service
public class PessoaService {

    private PessoaRepositorio repositorio;

     @Autowired
    public PessoaService (PessoaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public Pessoa save(Pessoa pessoa){
        return repositorio.save(pessoa);
    }

    public Pessoa findById(String id){
        return repositorio.findById(id)
                .orElseThrow(() -> new ApiRequestException(id));
    }

    public List<Pessoa> findAll(){
        return repositorio.findAll();
    }

    public void deleteAllById(List<String> id){
        repositorio.deleteAllById(id);
    }

    public List<Pessoa> findByNomeContains(String nome){
            return repositorio.findByNomeContains(nome);
    }
}
