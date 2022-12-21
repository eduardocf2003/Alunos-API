package br.com.mesttra.alunosapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Aluno {

    @Id
    private Long matricula;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate dataNascimento;

    @Column(unique = true)
    private String cpf;

    @Column(name = "valor_mensalidade", nullable = false)
    private Float valorMensalidade;

    public Aluno() {

    }

    public Aluno(Long matricula, String nome, LocalDate dataNascimento, String cpf, Float valorMensalidade) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.valorMensalidade = valorMensalidade;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
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

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", valorMensalidade=" + valorMensalidade +
                '}';
    }
}
