package demo.sprint.controller;


import demo.sprint.model.Pessoa;
import demo.sprint.model.PessoaDTO;
import demo.sprint.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public Pessoa save(@RequestBody Pessoa pessoa){
        return service.save(pessoa);
    }
    @GetMapping("/pessoa/{id}")
    public PessoaDTO findById(@PathVariable String id){
        System.out.println("Executando Versão 01");
        return service.findById(id);
    }

    @GetMapping()
    public List<Pessoa> findAll(){
        return service.findAll();
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
    public Pessoa updatePessoa (@RequestBody Pessoa pessoa){
        return service.save(pessoa);
    }

    @GetMapping("/filtro")
    public List<Pessoa> findPessoaNomeContains(@RequestParam String nome){
       return service.findByNomeContains(nome);
    }
}

