package demo.sprint.controller;


import demo.sprint.model.Pessoa;
import demo.sprint.model.mapper.PessoaMapper;
import demo.sprint.model.request.PessoaRequest;
import demo.sprint.model.response.PessoaResponse;
import demo.sprint.model.response.PessoaResponseSenha;
import demo.sprint.model.walmartEntity.ProductEntity;
import demo.sprint.service.PessoaService;
import demo.sprint.service.data.DataService;
import demo.sprint.service.data.DataServiceFacade;
import demo.sprint.service.data.model.response.ResponseServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/sprint03")
public class PessoaController {
    private PessoaService service;
    private DataService dataService;
    private DataServiceFacade facade;

    @PostMapping("/pessoas")
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaResponseSenha save(@RequestBody @Valid PessoaRequest pessoaRequest) {
        return PessoaMapper.pessoaResponseSenha(service.save(PessoaMapper.requestPessoa(pessoaRequest)));
    }

    @GetMapping("/prod")
    public ResponseServiceProduct getDetails(@RequestParam @Valid String usItemId){
        return dataService.findProductIntegration(usItemId);
    }

    @GetMapping("/search")
    public ProductEntity search(@RequestParam @Valid String usItemId){
        return dataService.findProductIntegration1(usItemId);
    }

    @PostMapping("/prod/save")
    public ProductEntity save(@RequestBody ProductEntity entity){
        return dataService.save(entity);
    }

//    @GetMapping("/prod/search")
//    public ProductEntity findById(@PathVariable String usItemId) {
//        return dataService.findByUsItemId(usItemId);
//    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PessoaResponseSenha updatePessoa(@PathVariable @Valid String id, @RequestBody PessoaRequest pessoaRequest) {
        return PessoaMapper.pessoaResponseSenha(service.att(id, PessoaMapper.requestPessoa(pessoaRequest)));
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestParam("id") List<String> id) {
        service.deleteAllById(id);
    }

    @GetMapping("/pessoa/{id}")
    public Pessoa findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/admin")
    public List<PessoaResponseSenha> findAll() {
        return service.findAll()
                .stream()
                .map(PessoaMapper::pessoaResponseSenha)
                .toList();
    }

    @GetMapping("/pessoas")
    public List<PessoaResponse> findAllPessoa() {
        return service.findAll()
                .stream()
                .map(PessoaMapper::pessoaResponse)
                .toList();
    }

    @GetMapping("/create-coockie")
    public String criandoCoookie(Pessoa pessoa, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("cookieTest", "cookie-value");
        cookie.getName();
        cookie.getComment();
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        return "cookie-recived/";
    }

    @GetMapping("/filtro")
    public List<PessoaResponse> findPessoaNomeContains(@RequestParam String nome) {
        return service.findByNomeContains(nome)
                .stream()
                .map(PessoaMapper::pessoaResponse)
                .toList();
    }
}

