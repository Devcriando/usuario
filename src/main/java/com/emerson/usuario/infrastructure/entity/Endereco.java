package com.emerson.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(name = "rua", length = 200)
    private String rua;
    @Column (name = "cep", length = 9)
    private String cep;
    @Column (name = "numero", length = 5)
    private long numero;
    @Column (name = "bairro", length = 50)
    private String bairro;
    @Column (name = "cidade", length = 150)
    private String cidade;
    @Column(name = "estado", length = 2)
    private String estado;
    @Column (name = "complemento", length = 15)
    private String complemento;

}
