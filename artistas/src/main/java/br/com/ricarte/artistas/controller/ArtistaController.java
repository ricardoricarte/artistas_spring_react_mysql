package br.com.ricarte.artistas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricarte.artistas.model.ArtistaModelo;
import br.com.ricarte.artistas.model.RespostaModelo;
import br.com.ricarte.artistas.service.ArtistaServico;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
public class ArtistaController {

  ArtistaServico as;
  

  @GetMapping("/listar")
  public Iterable<ArtistaModelo> listar() {
    return as.listar();
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<?> cadastrar(@RequestBody ArtistaModelo am) {
    return as.cadastrarAlterar(am, "cadastrar");
  }

  @PutMapping("/alterar")
  public ResponseEntity<?> alterar(@RequestBody ArtistaModelo am) {
    return as.cadastrarAlterar(am, "alterar");
  }

  @DeleteMapping("/remover/{id}")
  public ResponseEntity<RespostaModelo> remover(@PathVariable Long id) {
    return as.remover(id);

  }
  
}
