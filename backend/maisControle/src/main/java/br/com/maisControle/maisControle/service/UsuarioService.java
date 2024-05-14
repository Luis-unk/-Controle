package br.com.maisControle.maisControle.service;

import br.com.maisControle.maisControle.model.Usuario;
import br.com.maisControle.maisControle.repository.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private IUsuario repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuario repository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.repository = repository;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> list = repository.findAll();
        return list;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario novoUsuario = repository.save(usuario);
        return novoUsuario;
    }

    public Usuario updateUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario updateUsuario = repository.save(usuario);
        return updateUsuario;
    }

    public Boolean excluirUsuario(Integer id) {
        repository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(Usuario usuario) {
        String senha = repository.getById(usuario.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        return valid;
    }
}
