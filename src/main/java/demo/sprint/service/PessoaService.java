package demo.sprint.service;

import demo.sprint.model.Pessoa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.sprint.repository.PessoaRepositorio;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return repositorio.findById(id);
    }
    public List<Pessoa> findAll(){
        return repositorio.findAll();
    }
    public void deleteAllById(@RequestParam("id") List<String> id){
        repositorio.deleteAllById(id);
    }

    public List<Pessoa> findByNome(@RequestParam("nome") String nome){
        return repositorio.findByNomeContains(nome);
        }
    }
