package br.ufs.dcomp.guia.dataaccess.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import br.ufs.dcomp.guia.model.ItemGuia;

public class ItemGuiaDAO extends StrategyDAO<ItemGuia> {

	@Override
	public ItemGuia read(Integer id) {
		ItemGuia itemGuia = null;
		try {
			ResultSet r = this.dm.executeQuery(this.getSelectStatment(id));
			if (r.next()) {
				itemGuia = new ItemGuia();
				itemGuia.setId(r.getInt("id"));
				itemGuia.setTitle(r.getString("title"));
				itemGuia.setContent(r.getString("content"));
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
			"INSERT INTO public.tb_item_guia(title, content, idguia) VALUES (\'%s\', \'%s\', %s);",
			model.getTitle(), 
			model.getContent(),
			model.getIdPai().toString() 
		);
	}

	@Override
	public String getUpdateStatment(ItemGuia model) {
		return String.format(
			"UPDATE public.tb_item_guia SET title=\'%s\', content=\'%s\', idguia=%s WHERE (id = %s);",
			model.getTitle(),
			model.getContent(),
			model.getIdPai().toString(),
			model.getId().toString() 
		);
	}

	@Override
	public String getSelectStatment(Integer id) {
		return String.format(
			"SELECT id, title, content, idguia FROM public.tb_item_guia	WHERE (id = %s);",
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


}