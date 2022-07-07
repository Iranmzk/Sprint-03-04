package demo.sprint.controller;


import demo.sprint.model.Pessoa;
import demo.sprint.model.mapper.PessoaMapper;
import demo.sprint.model.request.PessoaRequest;
import demo.sprint.model.response.PessoaResponse;
import demo.sprint.model.response.PessoaResponseSenha;
import demo.sprint.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/sprint03")
public class PessoaController {

    private  PessoaService service;
    @Autowired
    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaResponseSenha save(@Valid @RequestBody PessoaRequest pessoaRequest){
        return PessoaMapper.pessoaResponseSenha(service.save(PessoaMapper.requestPessoa(pessoaRequest)));
    }
    @GetMapping("/pessoa/{id}")
    public Pessoa findById(@PathVariable String id){
        System.out.println("Executando Versão 01");
        return service.findById(id);
    }

    @GetMapping("/admin")
    public List<PessoaResponseSenha> findAll(){
        return service.findAll()
                .stream()
                .map(PessoaMapper::pessoaResponseSenha)
                .toList();
    }
    @GetMapping()
    public List<PessoaResponse> findAllPessoa(){
        return service.findAll()
                .stream()
                .map(PessoaMapper::pessoaResponse)
                .toList();
    }

    @GetMapping("/create-coockie")
    public String criandoCoookie(Pessoa pessoa, HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("cookieTest","cookie-value");
        cookie.getName();
        cookie.getComment();
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        return "cookie-recived/";
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam("id") List<String> id){
        service.deleteAllById(id);
    }

    @PutMapping("/{id}")
    public PessoaResponse updatePessoa (@PathVariable String id,@Valid @RequestBody PessoaRequest pessoaRequest){
        return PessoaMapper.pessoaResponse(service.att(id, PessoaMapper.requestPessoa(pessoaRequest)));
    }

    @GetMapping("/filtro")
    public List<PessoaResponse> findPessoaNomeContains(@RequestParam String nome){
       return service.findByNomeContains(nome)
               .stream()
               .map(PessoaMapper::pessoaResponse)
               .toList();
    }
}

