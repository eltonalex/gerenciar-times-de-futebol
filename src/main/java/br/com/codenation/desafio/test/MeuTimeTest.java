package br.com.codenation.desafio.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.codenation.DesafioMeuTimeApplication;

public class MeuTimeTest {

	public static void main(String[] args) {
		
		// incluirTime
		DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();
		
		LocalDate data1 = LocalDate.of(1983, 04, 11);
		LocalDate data2 = LocalDate.of(1984, 02, 20);
        LocalDate data3 = LocalDate.of(1985, 07, 05);
		
		try {
			desafio.incluirTime(1L,"Time 1", data1, "Azul", "Amarelo");
			desafio.incluirTime(2L,"Time 2", data2, "Azul", "Branco");
			desafio.incluirTime(3L,"Time 3", data3, "Verde", "Roxo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// incluirJogador		
		LocalDate dataNascimento0 = LocalDate.of(1981, 2, 21);
		BigDecimal salario0 = new BigDecimal("15115.00");
		LocalDate dataNascimento1 = LocalDate.of(1983, 4, 11);
		BigDecimal salario1 = new BigDecimal("10115.00");
		LocalDate dataNascimento2 = LocalDate.of(1984, 8, 25);
		BigDecimal salario2 = new BigDecimal("11300.00");
		LocalDate dataNascimento3 = LocalDate.of(1983, 3, 10);
		BigDecimal salario3 = new BigDecimal("12700.00");
		LocalDate dataNascimento4 = LocalDate.of(1985, 9, 11);
		BigDecimal salario4 = new BigDecimal("15615.00");
		
		try {
			desafio.incluirJogador( 1L, 1L, "Rogério", dataNascimento0, 90,salario0);
			desafio.incluirJogador( 2L, 1L, "Elton", dataNascimento1, 70,salario1);
			desafio.incluirJogador( 3L, 1L, "Alex", dataNascimento2, 83,salario2);
			desafio.incluirJogador( 4L, 1L, "Felipe", dataNascimento3, 96,salario3);
			desafio.incluirJogador( 5L, 1L, "Alexandre", dataNascimento4, 87,salario4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// definirCapitao
		try {
			desafio.definirCapitao(2L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// buscarCapitaoDoTime
		try {
			System.out.println(desafio.buscarCapitaoDoTime(1L));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// buscarNomeJogador
		try {
			System.out.println(desafio.buscarNomeJogador(1L));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// buscarNomeTime
		try {
			System.out.println(desafio.buscarNomeTime(1L));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		
		// buscarJogadoresDoTime
		try {
			List<Long> jogadores = desafio.buscarJogadoresDoTime(1L);
			for (Long long1 : jogadores) {
				System.out.println(long1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// buscarMelhorJogadorDoTime
		try {
			System.out.println(desafio.buscarMelhorJogadorDoTime(1L));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		
		// buscarJogadorMaisVelho
		try {
			System.out.println(desafio.buscarJogadorMaisVelho(1L));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// buscarTimes
		try {
			List<Long> times = desafio.buscarTimes();
			for (Long long2 : times) {
				System.out.println(long2);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// buscarSalarioDoJogador
		try {
			System.out.println(desafio.buscarSalarioDoJogador(2L));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// buscarTopJogadores
		try {
			System.out.println(desafio.buscarTopJogadores(1));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// buscarCorCamisaTimeDeFora
		try {
			System.out.println(desafio.buscarCorCamisaTimeDeFora(1L,2L));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
