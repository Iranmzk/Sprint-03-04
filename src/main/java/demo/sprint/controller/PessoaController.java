package demo.sprint.controller;


import demo.sprint.configuration.ApiRequestException;
import demo.sprint.model.Pessoa;
import demo.sprint.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sprint03")
public class PessoaController {

    private  PessoaService pessoaService;
    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/v1/pessoa")
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa save(@RequestBody Pessoa pessoa){
        return pessoaService.save(pessoa);
    }
    @GetMapping("/v1/{id}")
    public Pessoa findOne(@PathVariable String id){
        System.out.println("Executando Versão 01");
        return pessoaService.findOne(id);
    }

    @GetMapping("/v1")
    public List<Pessoa> findAll(){
        return pessoaService.findAll();
    }

    @GetMapping("/v1/create-coockie")
    public String criandoCoookie(Pessoa pessoa, HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("cookieTest","cookie-value");
        cookie.getName();
        cookie.getComment();
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        return "cookie-recived/";
    }

    @DeleteMapping("/v1/delete")
    public void deleteById(@RequestParam("id") List<String> id){
        pessoaService.deleteAllById(id);
    }

    @PutMapping("/v1/pessoa")
    public Pessoa updatePessoa (@RequestBody Pessoa pessoa){
        return pessoaService.save(pessoa);
    }

    @GetMapping("/v1/filtro")
    public List<Pessoa> findPessoaNomeContains(@RequestParam("nome") String nome){
       return pessoaService.findByNomeContains(nome);
    }

}

