package br.com.codenation.desafio.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.codenation.desafio.annotation.Desafio;

public interface MeuTimeInterface {

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) throws Exception;

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) throws Exception;

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) throws Exception;

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime)throws Exception;

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) throws Exception;

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) throws Exception;

	@Desafio("buscarMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) throws Exception;

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) throws Exception;

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) throws Exception;

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) throws Exception;

	@Desafio("buscarTimes")
	public List<Long> buscarTimes();

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top);
	
	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long idTimeDaCasa, Long idTimeDeFora) throws Exception;
}
