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

}
