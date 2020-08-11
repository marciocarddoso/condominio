package br.com.totemti.condominio.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.totemti.condominio.modelo.Condominio;

public class CondominioDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		Condominio condominio = new Condominio();
		condominio.setNome("");
		
		CondominioDAO condominioDAO = new CondominioDAO();
		condominioDAO.salvar(condominio);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		CondominioDAO condominioDAO = new CondominioDAO();
		List<Condominio> resultado = condominioDAO.listar();
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 6L;
		CondominioDAO condominioDAO = new CondominioDAO();
		Condominio condominio = condominioDAO.buscar(codigo);

		if (condominio == null) {
			System.out.println("Nenhum registro encontrado!");
		}
		
		if (condominio != null) {
			System.out.println("Codigo " + condominio.getId() + " - Condominio " + condominio.getNome());
		}

	}
	
	@Test
	@Ignore
	public void excluir() {
		
		Long codigo = 6L;
		CondominioDAO condominioDAO = new CondominioDAO();
		Condominio condominio = condominioDAO.buscar(codigo);
		
		if (condominio == null) {
			System.out.println("Nenhum registro encontrado!");
		}
		
		if (condominio != null) {
			
			System.out.println("Condominio encontrado: " + condominio.getNome());
			condominioDAO.excluir(condominio);
			System.out.println("Registro excluído com sucesso");
		}
		
	}

}
