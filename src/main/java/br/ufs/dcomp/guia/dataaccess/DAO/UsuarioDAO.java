package br.ufs.dcomp.guia.dataaccess.DAO;

import br.ufs.dcomp.guia.model.usuario.Usuario;

public class UsuarioDAO extends StrategyDAO<Usuario>{

	@Override
	public boolean create(Usuario model) {
		return false;
	}

	@Override
	public Usuario read(Integer id) {
		return null;
	}

	@Override
	public boolean update(Usuario model) {
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}

}