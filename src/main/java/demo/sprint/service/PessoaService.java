package demo.sprint.service;

import demo.sprint.configuration.exception.ApiNotFoundException;
import demo.sprint.integration.data.DataIntegration;
import demo.sprint.integration.data.DataIntegrationResponse;
import demo.sprint.integration.product.ProductIntegrationResponse;
import demo.sprint.model.Pessoa;
import demo.sprint.repository.PessoaRepositorio;
import demo.sprint.service.data.mapper.response.DataIntegrationResponseMapper;
import demo.sprint.service.data.model.response.DataServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class PessoaService {
//    @Autowired
    private final PessoaRepositorio repositorio;
    private final DataIntegration dataIntegration;

    public Pessoa save(Pessoa pessoa) {
        return repositorio.save(pessoa);
    }

    public Pessoa att(String id, Pessoa pessoaAtt){
        Pessoa pessoaSalva = repositorio.findById(id)
                .orElseThrow(() -> new ApiNotFoundException("Id não encontrado " + id));
        pessoaAtt.setId(pessoaSalva.getId());
        return repositorio.save(pessoaAtt);
    }

    public DataIntegrationResponse findProd(String usItemId){
        return dataIntegration.findProduct(usItemId);
    }

    public Pessoa findById(String id){
        return repositorio.findById(id)
                .orElseThrow(() -> new ApiNotFoundException("Id não encontrado " + id));
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
