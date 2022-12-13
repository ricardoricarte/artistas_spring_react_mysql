package br.com.ricarte.artistas.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ricarte.artistas.model.ArtistaModelo;
import br.com.ricarte.artistas.model.RespostaModelo;
import br.com.ricarte.artistas.repository.ArtistaRepositorio;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ArtistaServico {

  ArtistaRepositorio ar;
  RespostaModelo rm;

  // Método para listar todos os artistas
  public Iterable<ArtistaModelo> listar() {
    return ar.findAll();
  }

  // Método para Cadastrar Artistas
  public ResponseEntity<?> cadastrar(ArtistaModelo am) {
    if (am.getArtista().equals("")) {
      rm.setMensagem("O nome do artista é obrigatório");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else if (am.getEstilo().equals("")) {
      rm.setMensagem("O nome do estilo é obrigatório");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<ArtistaModelo>(ar.save(am), HttpStatus.CREATED);
    }
  }

  // Método para alterar artistas
  public ResponseEntity<?> cadastrarAlterar(ArtistaModelo am, String acao) {
    if (am.getArtista().equals("")) {
      rm.setMensagem("O nome do artista é obrigatório");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else if (am.getEstilo().equals("")) {
      rm.setMensagem("O nome do estilo é obrigatório");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else {
      if (acao.equals("cadastrar")) {
        return new ResponseEntity<ArtistaModelo>(ar.save(am), HttpStatus.CREATED);
      } else {
        return new ResponseEntity<ArtistaModelo>(ar.save(am), HttpStatus.OK);
      }
    }
  }

  // Método para remover Artista
  public ResponseEntity<RespostaModelo> remover(Long id) {

    ar.deleteById(id);

    rm.setMensagem("O Artista foi removido com Sucesso.");
    return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);

  }
}
