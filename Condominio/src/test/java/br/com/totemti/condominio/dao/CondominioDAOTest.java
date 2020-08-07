package br.com.totemti.condominio.dao;

import org.junit.Test;

import br.com.totemti.condominio.modelo.Condominio;

public class CondominioDAOTest {
	
	@Test
	public void salvar() {
		Condominio condominio = new Condominio();
		condominio.setNome("");
		
		CondominioDAO condominioDAO = new CondominioDAO();
		condominioDAO.salvar(condominio);
		
	}

}
