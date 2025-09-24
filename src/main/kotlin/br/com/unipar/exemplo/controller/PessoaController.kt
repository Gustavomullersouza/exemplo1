package br.com.unipar.exemplo.controller

import br.com.unipar.exemplo.database.PessoaRepository
import br.com.unipar.exemplo.model.Pessoa
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
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

    @GetMapping
    fun listarPessoa() : List<Pessoa>{
        return pessoaRepository.findAll()
    }
}