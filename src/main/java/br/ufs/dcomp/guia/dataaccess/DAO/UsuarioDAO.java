package br.ufs.dcomp.guia.dataaccess.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.ufs.dcomp.guia.model.usuario.Usuario;

public class UsuarioDAO extends StrategyDAO<Usuario> {

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
				usuario.getFormacao().setDescricao(r.getString("desc_formacao"));
				usuario.getExp().setId(r.getInt("experiencia"));
				usuario.getExp().setDescricao(r.getString("desc_experiencia"));
				usuario.getVinculo().setId(r.getInt("vinculo"));
				usuario.getVinculo().setDescricao(r.getString("desc_vinculo"));
				usuario.getTipo().setId(r.getInt("tipo"));
				usuario.getTipo().setDescricao(r.getString("desc_tipo"));
				usuario.getSetor().setId(r.getInt("setor"));
				usuario.getSetor().setDescricao(r.getString("desc_setor"));
			}
		} catch (SQLException e) {
			usuario = null;
			e.printStackTrace();
		}
		return usuario;
	}

	public List<Usuario> readAll() {
		List<Usuario> lstUsuario = new ArrayList<Usuario>();
		try {
			ResultSet r = this.dm.executeQuery(this.getSelectAllStatment());
			while (r.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(r.getInt("id"));
				usuario.setEmail(r.getString("email"));
				usuario.setNome(r.getString("nome"));
				usuario.getFormacao().setId(r.getInt("formacao"));
				usuario.getFormacao().setDescricao(r.getString("desc_formacao"));
				usuario.getExp().setId(r.getInt("experiencia"));
				usuario.getExp().setDescricao(r.getString("desc_experiencia"));
				usuario.getVinculo().setId(r.getInt("vinculo"));
				usuario.getVinculo().setDescricao(r.getString("desc_vinculo"));
				usuario.getTipo().setId(r.getInt("tipo"));
				usuario.getTipo().setDescricao(r.getString("desc_tipo"));
				usuario.getSetor().setId(r.getInt("setor"));
				usuario.getSetor().setDescricao(r.getString("desc_setor"));
				lstUsuario.add(usuario);
			}
		} catch (SQLException e) {
			lstUsuario = null;
			e.printStackTrace();
		}		
		return lstUsuario;
	}

	@Override
	public String getInsertStatment(Usuario model) {
		return String.format(
				"INSERT INTO public.tb_usuario(nome, email, formacao, vinculo, tipo, setor, experiencia) VALUES (\'%s\', \'%s\', %s, %s, %s, %s, %s);",
				model.getNome(), model.getEmail(), model.getFormacao().getId().toString(),
				model.getVinculo().getId().toString(), model.getTipo().getId().toString(),
				model.getSetor().getId().toString(), model.getExp().getId().toString());
	}

	@Override
	public String getUpdateStatment(Usuario model) {
		return String.format(
				"UPDATE public.tb_usuario SET nome=\'%s\', email=\'%s\', formacao=%s, vinculo=%s, tipo=%s, setor=%s, experiencia=%s WHERE (id = %s);",
				model.getNome(), model.getEmail(), model.getFormacao().getId().toString(),
				model.getVinculo().getId().toString(), model.getTipo().getId().toString(),
				model.getSetor().getId().toString(), model.getExp().getId().toString());
	}

	@Override
	public String getSelectStatment(Integer id) {
		return String.format(
			this.getSelectAllStatment() +
			"WHERE (U.id = %s)",
			id.toString() 
		);
	}

	public String getSelectAllStatment() {
		return "SELECT U.id, U.nome, U.email, U.formacao, F.descricao as desc_formacao, U.vinculo, V.descricao as desc_vinculo, U.tipo, T.descricao as desc_tipo, U.setor, S.descricao as desc_setor, U.experiencia, E.descricao as desc_experiencia "+ 	
		"FROM public.tb_usuario as U LEFT JOIN public.tb_usuario_formacao as F ON U.formacao = F.id LEFT JOIN public.tb_usuario_vinculo as V ON U.vinculo = V.id LEFT JOIN public.tb_usuario_tipo as T ON U.tipo = T.id LEFT JOIN public.tb_usuario_setor as S ON U.setor = S.id LEFT JOIN public.tb_usuario_experiencia as E ON U.experiencia = E.id ";
	}

	@Override
	public String getDeleteStatment(Integer id) {
		return String.format("DELETE FROM public.tb_usuario WHERE (id = %s);", id.toString());
	}

}