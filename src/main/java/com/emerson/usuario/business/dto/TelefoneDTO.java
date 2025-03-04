package com.emerson.usuario.business.dto; // Define o pacote onde essa classe está localizada

// Importação das anotações do Lombok para reduzir código repetitivo
import lombok.*;

@Setter // Gera automaticamente os métodos "set" para todos os atributos da classe
@Getter // Gera automaticamente os métodos "get" para todos os atributos da classe
@AllArgsConstructor // Gera automaticamente um construtor com todos os atributos
@NoArgsConstructor // Gera automaticamente um construtor sem parâmetros
@Builder // Permite usar o padrão Builder para criar objetos dessa classe
public class TelefoneDTO { // Declaração da classe TelefoneDTO (Data Transfer Object)

    private String numero; // Armazena o número de telefone (ex: 987654321)
    private String ddd; // Armazena o código de área (ex: 11 para São Paulo)
}
