package br.com.maisControle.maisControle.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3, message = "O nome deve conter no minimo 3 caracteres!")
    @Column(name = "nome", length = 200)
    private String nome;

    @NotBlank(message = "CPF é obrigatório!")
    @CPF
    @Column(name = "cpf", length = 25, nullable = false)
    private String cpf;

    @NotBlank(message = "O Email é obrigatório!")
    @Email
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "A Senha é obrigatória!")
    @Column(name = "senha", columnDefinition = "TEXT")
    private String senha;

    @Column(name = "saldo")
    private Double saldo;
}
