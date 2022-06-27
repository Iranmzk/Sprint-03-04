package demo.sprint.controller;


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
   @Autowired
    private  PessoaService pessoaService;
//
//    public PessoaController(PessoaService pessoaService) {
//        this.pessoaService = pessoaService;
//    }

    @PostMapping("/pessoa")
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa save(@RequestBody Pessoa pessoa){
        return pessoaService.save(pessoa);
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> findOne(@PathVariable String id){
        return pessoaService.findOne(id);
    }

    @GetMapping("/")
    public List<Pessoa> findAll(){
        return pessoaService.findAll();
    }

    @GetMapping("/create-coockie")
    public String criandoCoookie(Pessoa pessoa, HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("cookie-name","cookie-value");
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        return "cookie-recived/";
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam("id") List<String> id){
        pessoaService.deleteAllById(id);
    }

    @PutMapping("/{id}")
    public Pessoa putPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.save(pessoa);
    }

    @GetMapping("/filtro")
    public Optional<Pessoa> findPessoaNome(@RequestParam("nome") String nome){
       return pessoaService.findByNome(nome);
    }

    }

