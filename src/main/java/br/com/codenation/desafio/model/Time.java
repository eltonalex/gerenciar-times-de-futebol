package br.com.codenation.desafio.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {

	private Long id;
	private String nome;
	private LocalDate dataCriacao;
	private String corUniformePrincipal;
	private String corUniformeSecundario;
	private Jogador capitao;
	private List<Jogador> listJogador;

	public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {
		this.id = id;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.corUniformePrincipal = corUniformePrincipal;
		this.corUniformeSecundario = corUniformeSecundario;
		this.listJogador = new ArrayList<>();
	}

	public Long getIdTime() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public String getCorUniformePrincipal() {
		return corUniformePrincipal;
	}

	public String getCorUniformeSecundario() {
		return corUniformeSecundario;
	}

	public Jogador getCapitao() {
		return capitao;
	}

	public void setCapitao(Jogador capitao) {
		this.capitao = capitao;
	}

	public void addJogador(Jogador jogador) {
		this.listJogador.add(jogador);
	}

	public Jogador getJogador(Long idJogador) {
		
		return listJogador
				.stream()
				.filter(jogador -> idJogador.equals(jogador.getId()))
				.findAny()
				.orElse(null);
	}

	public List<Jogador> getJogadorList() {
		
		return listJogador;
	}

	public Long getId() {
		return id;
	}

}