package br.com.mesttra.alunosapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CriarAlunoDTO {

    @NotBlank
    private String nome;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate dataNascimento;

    @CPF
    private String cpf;

    @NotNull(message = "valorMensalidade não pode ser nulo")
    private Float valorMensalidade;

    public CriarAlunoDTO(String nome, LocalDate dataNascimento, String cpf, Float valorMensalidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.valorMensalidade = valorMensalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Float getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(Float valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }
}
