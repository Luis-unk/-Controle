package br.com.maisControle.maisControle.repository;

import br.com.maisControle.maisControle.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuario extends JpaRepository<Usuario, Integer> {
}
