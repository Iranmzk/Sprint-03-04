package demo.sprint.service;

import demo.sprint.controller.exception.ApiRequestException;
import demo.sprint.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.sprint.repository.PessoaRepositorio;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepositorio repositorio;
//    public PessoaService (PessoaService pessoaService){
//        this.repositorio = pessoaService.repositorio;
//    }

    public Pessoa save(Pessoa pessoa){
        return repositorio.save(pessoa);
    }
    public Optional<Pessoa> findOne(String id){
        return Optional.of(repositorio.findById(id)
                .orElseThrow(() -> new ApiRequestException("ID Não encontrado " + id)));
    }
    public List<Pessoa> findAll(){
        return repositorio.findAll();
    }
    public void deleteAllById(@RequestParam("id") List<String> id){
        repositorio.deleteAllById(id);
    }

    public Optional<Pessoa> findByNome(@RequestParam("nome") String nome){
        return Optional.of(repositorio.findByNomeContains(nome)
                .orElseThrow
                        ((() -> new ApiRequestException("NOME não encontrado"))));
        }
    }
