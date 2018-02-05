package br.ufs.dcomp.guia.dataaccess.DAO;

import br.ufs.dcomp.guia.model.Guia;

public class GuiaDAO extends StrategyDAO<Guia> {

	@Override
	public boolean create(Guia model) {
		return false;
	}

	@Override
	public Guia read(Integer id) {
		return null;
	}

	@Override
	public boolean update(Guia model) {
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}

}