package br.ufs.dcomp.guia.dataaccess.DAO;

import br.ufs.dcomp.guia.model.Acesso;

public class AcessoDAO extends StrategyDAO<Acesso>{

	@Override
	public boolean create(Acesso model) {
		return false;
	}

	@Override
	public Acesso read(Integer id) {
		return null;
	}

	@Override
	public boolean update(Acesso model) {
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}

}