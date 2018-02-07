package br.ufs.dcomp.guia.model;

import br.ufs.dcomp.guia.container.ILeaf;

public class ItemGuia implements IModel{
    private Integer id;
    private String title;
    private String content;
    private Integer idPai;
    private ILeaf itemGuia;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the idPai
	 */
	public Integer getIdPai() {
		return idPai;
	}
	/**
	 * @param idPai the idPai to set
	 */
	public void setIdPai(Integer idPai) {
		this.idPai = idPai;
	}
	/**
	 * @return the itemGuia
	 */
	public ILeaf getItemGuia() {
		return itemGuia;
	}
	/**
	 * @param itemGuia the itemGuia to set
	 */
	public void setItemGuia(ILeaf itemGuia) {
		this.itemGuia = itemGuia;
	}
}