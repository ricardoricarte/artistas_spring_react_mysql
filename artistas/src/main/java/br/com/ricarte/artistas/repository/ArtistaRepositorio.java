package br.com.ricarte.artistas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ricarte.artistas.model.ArtistaModelo;

@Repository
public interface ArtistaRepositorio extends JpaRepository<ArtistaModelo, Long>{
  
}
