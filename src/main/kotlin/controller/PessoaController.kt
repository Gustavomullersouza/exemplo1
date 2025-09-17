package controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RestController

//A anotação Restcontroller não pode usar VIEW, basicamenteo é para construir APIs
//a anotação Controler permite ter VIEW, para construir Web Applications
@RestController
class PessoaController {
}