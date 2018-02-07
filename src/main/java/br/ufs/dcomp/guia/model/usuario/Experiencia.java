package br.ufs.dcomp.guia.model.usuario;

public class Experiencia {
    private Integer id;
    private String descricao;
    private Integer minimo;
    private Integer maximo;
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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the minimo
	 */
	public Integer getMinimo() {
		return minimo;
	}
	/**
	 * @param minimo the minimo to set
	 */
	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
	}
	/**
	 * @return the maximo
	 */
	public Integer getMaximo() {
		return maximo;
	}
	/**
	 * @param maximo the maximo to set
	 */
	public void setMaximo(Integer maximo) {
		this.maximo = maximo;
	}
}