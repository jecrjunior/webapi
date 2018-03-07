package br.ufs.dcomp.guia.dataaccess.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.sound.sampled.spi.FormatConversionProvider;

import br.ufs.dcomp.guia.model.usuario.Experiencia;
import br.ufs.dcomp.guia.model.usuario.Formacao;
import br.ufs.dcomp.guia.model.usuario.Setor;
import br.ufs.dcomp.guia.model.usuario.Tipo;
import br.ufs.dcomp.guia.model.usuario.Usuario;
import br.ufs.dcomp.guia.model.usuario.Vinculo;

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
				usuario.setSenha(r.getString("senha"));
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


	public Usuario read(String email, String senha) {
		Usuario usuario = null;
		try {
			ResultSet r = this.dm.executeQuery(
				String.format(
					this.getSelectStatment(0) + "OR (email = \'%s\' AND senha= \'%s\')",
					email, senha
				)
			);
			if (r.next()) {
				usuario = new Usuario();
				usuario.setId(r.getInt("id"));
				usuario.setEmail(r.getString("email"));
				usuario.setNome(r.getString("nome"));
				usuario.setSenha(r.getString("senha"));
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
				usuario.setSenha(r.getString("senha"));
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
				"INSERT INTO public.tb_usuario(nome, email, senha, formacao, vinculo, tipo, setor, experiencia) VALUES (\'%s\', \'%s\', %s, %s, %s, %s, %s);",
				model.getNome(), model.getEmail(), model.getSenha(), model.getFormacao().getId().toString(),
				model.getVinculo().getId().toString(), model.getTipo().getId().toString(),
				model.getSetor().getId().toString(), model.getExp().getId().toString());
	}

	@Override
	public String getUpdateStatment(Usuario model) {
		return String.format(
				"UPDATE public.tb_usuario SET nome=\'%s\', email=\'%s\', senha=\'%s\', formacao=%s, vinculo=%s, tipo=%s, setor=%s, experiencia=%s WHERE (id = %s);",
				model.getNome(), model.getEmail(), model.getSenha(), model.getFormacao().getId().toString(),
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
		return "SELECT U.id, U.nome, U.email, U.senha, U.formacao, F.descricao as desc_formacao, U.vinculo, V.descricao as desc_vinculo, U.tipo, T.descricao as desc_tipo, U.setor, S.descricao as desc_setor, U.experiencia, E.descricao as desc_experiencia "+ 	
		"FROM public.tb_usuario as U LEFT JOIN public.tb_usuario_formacao as F ON U.formacao = F.id LEFT JOIN public.tb_usuario_vinculo as V ON U.vinculo = V.id LEFT JOIN public.tb_usuario_tipo as T ON U.tipo = T.id LEFT JOIN public.tb_usuario_setor as S ON U.setor = S.id LEFT JOIN public.tb_usuario_experiencia as E ON U.experiencia = E.id ";
	}

	@Override
	public String getDeleteStatment(Integer id) {
		return String.format("DELETE FROM public.tb_usuario WHERE (id = %s);", id.toString());
	}


	public List<Formacao> readAllFormacao() {
		List<Formacao> lstFormacao = new ArrayList<Formacao>();
		try {
			ResultSet r = this.dm.executeQuery(
				"SELECT id, descricao FROM public.tb_usuario_formacao;");
			while (r.next()) {
				Formacao formacao = new Formacao();
				formacao.setId(r.getInt("id"));
				formacao.setDescricao(
					r.getString("descricao")
				);
				lstFormacao.add(formacao);
			}
		} catch (SQLException e) {
			lstFormacao = null;
			e.printStackTrace();
		}		
		return lstFormacao;
	}
	
	public List<Experiencia> readAllExperiencia() {
		List<Experiencia> lstExperiencia = new ArrayList<Experiencia>();
		try {
			ResultSet r = this.dm.executeQuery(
				"SELECT id, descricao, minimo, maximo FROM public.tb_usuario_experiencia;");
			while (r.next()) {
				Experiencia experiencia = new Experiencia();
				experiencia.setId(r.getInt("id"));
				experiencia.setDescricao(r.getString("descricao"));
				experiencia.setMinimo(r.getInt("minimo"));
				experiencia.setMaximo(r.getInt("maximo"));
				lstExperiencia.add(experiencia);
			}
		} catch (SQLException e) {
			lstExperiencia = null;
			e.printStackTrace();
		}		
		return lstExperiencia;
	}

	public List<Setor> readAllSetor() {
		List<Setor> lstSetor = new ArrayList<Setor>();
		try {
			ResultSet r = this.dm.executeQuery(
				"SELECT id, descricao FROM public.tb_usuario_setor;");
			while (r.next()) {
				Setor setor = new Setor();
				setor.setId(r.getInt("id"));
				setor.setDescricao(r.getString("descricao"));
				lstSetor.add(setor);
			}
		} catch (SQLException e) {
			lstSetor = null;
			e.printStackTrace();
		}		
		return lstSetor;
	}

	public List<Tipo> readAllTipo() {
		List<Tipo> lstTipo = new ArrayList<Tipo>();
		try {
			ResultSet r = this.dm.executeQuery(
				"SELECT id, descricao FROM public.tb_usuario_tipo;");
			while (r.next()) {
				Tipo tipo = new Tipo();
				tipo.setId(r.getInt("id"));
				tipo.setDescricao(r.getString("descricao"));
				lstTipo.add(tipo);
			}
		} catch (SQLException e) {
			lstTipo = null;
			e.printStackTrace();
		}		
		return lstTipo;
	}

	public List<Vinculo> readAllVinculo() {
		List<Vinculo> lstVinculo = new ArrayList<Vinculo>();
		try {
			ResultSet r = this.dm.executeQuery(
				"SELECT id, descricao FROM public.tb_usuario_vinculo;");
			while (r.next()) {
				Vinculo vinculo = new Vinculo();
				vinculo.setId(r.getInt("id"));
				vinculo.setDescricao(r.getString("descricao"));
				lstVinculo.add(vinculo);
			}
		} catch (SQLException e) {
			lstVinculo = null;
			e.printStackTrace();
		}		
		return lstVinculo;
	}


}