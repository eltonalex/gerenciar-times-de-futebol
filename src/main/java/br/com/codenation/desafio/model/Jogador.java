package br.com.codenation.desafio.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {


     Long id;
     Long idTime;
     String nome;
     LocalDate dataNascimento;
     Integer nivelHabilidade;
     BigDecimal salario;
    


    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.id = id;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.setNivelHabilidade(nivelHabilidade);
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }
    
	private void setNivelHabilidade(Integer nivelHabilidade) {
        if(nivelHabilidade > 100) {
            this.nivelHabilidade = 100;
        } else if(nivelHabilidade < 0){
            this.nivelHabilidade = 0;
        } else {
            this.nivelHabilidade = nivelHabilidade;
        }
    }
	
	 @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nivelHabilidade=" + nivelHabilidade +
                '}';
    }
	 
	 @Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	 
	 
}