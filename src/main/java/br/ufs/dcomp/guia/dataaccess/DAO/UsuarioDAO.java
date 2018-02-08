package br.ufs.dcomp.guia.dataaccess.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import br.ufs.dcomp.guia.model.usuario.Usuario;

public class UsuarioDAO extends StrategyDAO<Usuario>{

	@Override
	public Usuario read(Integer id) {
		Usuario usuario = null;
		try {
			ResultSet r = this.dm.executeQuery(this.getSelectStatment(id));
			if (r.next()) {
				usuario = new Usuario();
				usuario.setId(r.getInt("id"));
				usuario.setEmail(r.getString("email"));
				usuario.setNome(r.getString("nome"));
				usuario.getFormacao().setId(r.getInt("formacao"));
				usuario.getExp().setId(r.getInt("experiencia"));
				usuario.getVinculo().setId(r.getInt("vinculo"));
				usuario.getTipo().setId(r.getInt("tipo"));
				usuario.getSetor().setId(r.getInt("setor"));
			}
		} catch (SQLException e) {
			usuario = null;
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public String getInsertStatment(Usuario model) {
		return String.format(
			"INSERT INTO public.tb_usuario(nome, email, formacao, vinculo, tipo, setor, experiencia) VALUES (\'%s\', \'%s\', %s, %s, %s, %s, %s);",
			model.getNome(),
			model.getEmail(),
			model.getFormacao().getId().toString(),
			model.getVinculo().getId().toString(),
			model.getTipo().getId().toString(),
			model.getSetor().getId().toString(),
			model.getExp().getId().toString() 
		);
	}

	@Override
	public String getUpdateStatment(Usuario model) {
		return String.format(
			"UPDATE public.tb_usuario SET nome=\'%s\', email=\'%s\', formacao=%s, vinculo=%s, tipo=%s, setor=%s, experiencia=%s WHERE (id = %s);",
			model.getNome(),
			model.getEmail(),
			model.getFormacao().getId().toString(),
			model.getVinculo().getId().toString(),
			model.getTipo().getId().toString(),
			model.getSetor().getId().toString(),
			model.getExp().getId().toString() 
		);
	}

	@Override
	public String getSelectStatment(Integer id) {
		return String.format(
			"SELECT id, nome, email, formacao, vinculo, tipo, setor, experiencia FROM public.tb_usuario	WHERE (id = %s);",
			id.toString() 
		);
	}

	@Override
	public String getDeleteStatment(Integer id) {
		return String.format(
			"DELETE FROM public.tb_usuario WHERE (id = %s);",
			id.toString() 
		);
	}


}