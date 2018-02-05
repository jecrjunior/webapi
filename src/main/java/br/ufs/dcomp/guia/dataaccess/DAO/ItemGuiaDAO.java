package br.ufs.dcomp.guia.dataaccess.DAO;

import br.ufs.dcomp.guia.model.ItemGuia;

public class ItemGuiaDAO extends StrategyDAO<ItemGuia> {

	@Override
	public boolean create(ItemGuia model) {
		return false;
	}

	@Override
	public ItemGuia read(Integer id) {
		return null;
	}

	@Override
	public boolean update(ItemGuia model) {
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}

}