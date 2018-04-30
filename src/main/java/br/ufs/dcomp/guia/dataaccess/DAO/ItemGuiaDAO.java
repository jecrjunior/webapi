package br.ufs.dcomp.guia.dataaccess.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import br.ufs.dcomp.guia.model.ItemGuia;

public class ItemGuiaDAO extends DataAccessObject<ItemGuia> {

	@Override
	public ItemGuia read(Integer id) {
		ItemGuia itemGuia = null;
		try {
			ResultSet r = this.dm.executeQuery(this.getSelectStatment(id));
			if (r.next()) {
				itemGuia = new ItemGuia();
				itemGuia.setId(r.getInt("id"));
				itemGuia.setTitulo(r.getString("titulo"));
				itemGuia.setConteudo(r.getString("conteudo"));
				itemGuia.setIdPai(r.getInt("idguia"));
			}
		} catch (SQLException e) {
			itemGuia = null;
			e.printStackTrace();
		}
		return itemGuia;
	}

	@Override
	public String getInsertStatment(ItemGuia model) {
		return String.format(
			"INSERT INTO public.tb_item_guia(titulo, conteudo, idguia) VALUES (\'%s\', \'%s\', %s);",
			model.getTitulo(), 
			model.getConteudo(),
			model.getIdPai().toString() 
		);
	}

	@Override
	public String getUpdateStatment(ItemGuia model) {
		return String.format(
			"UPDATE public.tb_item_guia SET titulo=\'%s\', conteudo=\'%s\', idguia=%s WHERE (id = %s);",
			model.getTitulo(),
			model.getConteudo(),
			model.getIdPai().toString(),
			model.getId().toString() 
		);
	}

	@Override
	public String getSelectStatment(Integer id) {
		return String.format(
			this.getSelectAllStatment() +
			" WHERE (id = %s);",
			id.toString() 
		);
	}

	@Override
	public String getDeleteStatment(Integer id) {
		return String.format(
			"DELETE FROM public.tb_item_guia WHERE (id = %s);",
			id.toString() 
		);
	}

	@Override
	public List<ItemGuia> readAll() {
		List<ItemGuia> lstItemGuia = new LinkedList<ItemGuia>();
		try {
			ResultSet r = this.dm.executeQuery(this.getSelectAllStatment());
			while (r.next()) {
				ItemGuia itemGuia = new ItemGuia();
				itemGuia.setId(r.getInt("id"));
				itemGuia.setConteudo(r.getString("conteudo"));
				itemGuia.setTitulo(r.getString("titulo"));
				itemGuia.setIdPai(r.getInt("idguia"));
				lstItemGuia.add(itemGuia);
			}
		} catch (SQLException e) {
			lstItemGuia = null;
			e.printStackTrace();
		}		
		return lstItemGuia;
	}

	@Override
	public String getSelectAllStatment() {
		return "SELECT id, titulo, conteudo, idguia FROM public.tb_item_guia";
	}


	public String getSelectStatmentGuiaPai(Integer id) {
		return String.format(
			this.getSelectAllStatment() +
			" WHERE (idguia = %s);",
			id.toString()
		);
	}
	
	public ItemGuia readItemGuiaChildOf(Integer idpai) {
		ItemGuia itemGuia = null;
		try {
			ResultSet r = this.dm.executeQuery(this.getSelectStatmentGuiaPai(idpai));
			if (r.next()) {
				itemGuia = new ItemGuia();
				itemGuia.setId(r.getInt("id"));
				itemGuia.setTitulo(r.getString("titulo"));
				itemGuia.setConteudo(r.getString("conteudo"));
				itemGuia.setIdPai(r.getInt("idguia"));
			}
		} catch (SQLException e) {
			itemGuia = null;
			e.printStackTrace();
		}
		return itemGuia;
	}


}