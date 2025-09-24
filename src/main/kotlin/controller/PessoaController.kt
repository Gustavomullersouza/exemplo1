package controller

import database.PessoaRepository
import model.Pessoa
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//A anotação Restcontroller não pode usar VIEW, basicamenteo é para construir APIs
//a anotação Controler permite ter VIEW, para construir Web Applications
@RestController
@RequestMapping("/pessoa")
class PessoaController ( private val pessoaRepository : PessoaRepository){
    //Uma injeção de dependeica é necessaria quando
    //usamos uma classe externa,essa injeção (variavel)
    //deve ser privada, por uma questão de segurança.
    @PostMapping
    fun cadastrarPessoa(@RequestBody pessoa: Pessoa)
    : ResponseEntity<Pessoa>{
        return ResponseEntity.ok(
            pessoaRepository.save<Pessoa>(pessoa))
    }
}