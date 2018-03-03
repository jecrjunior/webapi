package br.ufs.dcomp.guia.model.usuario;

import br.ufs.dcomp.guia.model.IModel;

public class Usuario implements IModel {
    private Integer id;
    private String nome;
	private String email;
	private String senha;
    private Experiencia exp;
    private Formacao formacao;
    private Setor setor;
    private Tipo tipo;
	private Vinculo vinculo;
	
	public Usuario() {
		this.exp = new Experiencia();
		this.formacao = new Formacao();
		this.setor = new Setor();
		this.tipo = new Tipo();
		this.vinculo = new Vinculo();
	}

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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the exp
	 */
	public Experiencia getExp() {
		return exp;
	}
	/**
	 * @param exp the exp to set
	 */
	public void setExp(Experiencia exp) {
		this.exp = exp;
	}
	/**
	 * @return the formacao
	 */
	public Formacao getFormacao() {
		return formacao;
	}
	/**
	 * @param formacao the formacao to set
	 */
	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
	/**
	 * @return the setor
	 */
	public Setor getSetor() {
		return setor;
	}
	/**
	 * @param setor the setor to set
	 */
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	/**
	 * @return the tipo
	 */
	public Tipo getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the vinculo
	 */
	public Vinculo getVinculo() {
		return vinculo;
	}
	/**
	 * @param vinculo the vinculo to set
	 */
	public void setVinculo(Vinculo vinculo) {
		this.vinculo = vinculo;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
}