package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.interfaces.MeuTimeInterface;
import br.com.codenation.desafio.model.Jogador;
import br.com.codenation.desafio.model.Time;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Time> listaTime;

	public DesafioMeuTimeApplication() {
		listaTime = new ArrayList<>();
	}

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) throws Exception {
		if (this.getTimeById(id) != null) {
			throw new IdentificadorUtilizadoException();
		}
		listaTime.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));

	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) throws Exception {
		Time time = this.getTimeById(idTime);
		if (this.getJogadorById(id) != null) {
			throw new IdentificadorUtilizadoException();
		}
		if (time == null) {
			throw new TimeNaoEncontradoException();
		}

		time.addJogador(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));

	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) throws Exception {
		Time time = this.getTimeByIdJogador(idJogador);
		if (time == null) {
			throw new JogadorNaoEncontradoException();
		}
		Jogador jogador = time.getJogador(idJogador);
		time.setCapitao(jogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) throws Exception {
		Time time = this.getTimeById(idTime);
		if (time == null) {
			throw new TimeNaoEncontradoException();
		}
		if (time.getCapitao() == null) {
			throw new CapitaoNaoInformadoException();
		}
		return time.getCapitao().getId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) throws Exception {
		Jogador jogador = this.getJogadorById(idJogador);
		if (jogador != null) {
			return jogador.getNome();
		}
		throw new JogadorNaoEncontradoException();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) throws Exception {
		Time time = this.getTimeById(idTime);
		if (time == null) {
			throw new TimeNaoEncontradoException();
		}
		return time.getNome();

	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) throws Exception {
		Time time = this.getTimeById(idTime);
		if (time == null) {
			throw new TimeNaoEncontradoException();
		}
		return time.getJogadorList()
			    .stream()
			    .map(Jogador::getId)
			    .sorted()
			    .collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) throws Exception {
		Time time = this.getTimeById(idTime);
		if (time == null) {
			throw new TimeNaoEncontradoException();
		}
		Jogador jogador = Collections.max(time.getJogadorList(), new Comparator<Jogador>() {
			@Override
			public int compare(Jogador o1, Jogador o2) {
				return Integer.compare(o1.getNivelHabilidade(), o2.getNivelHabilidade());
			}
		});
		return jogador.getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) throws TimeNaoEncontradoException {
		Time time = this.getTimeById(idTime);
		if (time == null) {
			throw new TimeNaoEncontradoException();
		}
		
		Jogador jogador = Collections.min(time.getJogadorList(), (Jogador o1, Jogador o2) -> {
			LocalDate d1 = o1.getDataNascimento();
			LocalDate d2 = o2.getDataNascimento();
			if (d1.isAfter(d2)) { // jogador mais novo
				return 1;
			} else if (d1.isBefore(d2)) { // jogador mais velho
				return -1;
			}
			return Long.compare(o1.getId(), o2.getId());
		});
		return jogador.getId();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		List<Long> times = new ArrayList<>();
		if (!listaTime.isEmpty()) {
			listaTime.forEach(time -> times.add(time.getIdTime()));
			Collections.sort(times);
		}
		return times;
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) throws Exception {
		Time time = this.getTimeById(idTime);
		if (time == null) {
			throw new TimeNaoEncontradoException();

		}
		Jogador jogador = Collections.max(time.getJogadorList(), (Jogador o1, Jogador o2) -> {
			BigDecimal s1 = o1.getSalario();
			BigDecimal s2 = o2.getSalario();
			return s1.compareTo(s2) != 0 ? s1.compareTo(s2) : Long.compare(o2.getId(), o1.getId()); // inverti os
																									// jogadores para
																									// obter o menor id
		});
		return jogador.getId();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) throws Exception {
		Jogador jogador = this.getJogadorById(idJogador);
		if (jogador == null) {
			throw new JogadorNaoEncontradoException();
		}
		return jogador.getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> TopJogadores = new ArrayList<>();
		List<Jogador> todosJogadores = new ArrayList<>();
		listaTime.forEach(time -> todosJogadores.addAll(time.getJogadorList()));
		if (!todosJogadores.isEmpty()) {
			Collections.sort(todosJogadores, (Jogador o1, Jogador o2) -> {
				Integer n1 = o1.getNivelHabilidade();
				Integer n2 = o2.getNivelHabilidade();
				return !n1.equals(n2) ? Integer.compare(n2, n1) : Long.compare(o1.getId(), o2.getId()); // inverti os
																										// jogadores
																										// para ordenar
																										// decrescente
			});
			if (top > todosJogadores.size())
				top = todosJogadores.size();
			List<Jogador> topJogadores = todosJogadores.subList(0, top);
			topJogadores.forEach(jogador -> TopJogadores.add(jogador.getId()));
		}
		return TopJogadores;
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) throws Exception {
		final Time timeCasa = this.getTimeById(timeDaCasa);
		final Time timeFora = this.getTimeById(timeDeFora);
		if(timeCasa == null || timeFora == null) {
			throw new TimeNaoEncontradoException();
		}
		if (timeCasa.getCorUniformePrincipal().equals(timeFora.getCorUniformePrincipal())) {
			return timeFora.getCorUniformeSecundario();
		} else {
			return timeFora.getCorUniformePrincipal();
		}
	}

	private Time getTimeById(Long idTime) {

		return listaTime
				.stream()
				.filter(time -> idTime.equals(time.getIdTime()))
				.findAny()
				.orElse(null);
		
	}

	private Time getTimeByIdJogador(Long idJogador) {
		

		for (Time time : listaTime) {
			Jogador jogador = time.getJogador(idJogador);
			if (jogador != null) {
				return time;
			}
		}
		return null;
		
	}

	private Jogador getJogadorById(Long idJogador) {
		for (Time time : listaTime) {
			Jogador jogador = time.getJogador(idJogador);
			if (jogador != null) {
				return jogador;
			}
		}
		return null;
	}

}