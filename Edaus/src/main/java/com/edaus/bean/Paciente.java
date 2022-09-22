package com.edaus.bean;

public class Paciente {
	
	private int id;
	private String nome;
	private String email;
	private String celular;
	private String senha;
	private String sexo;
	private String cpf;
	
	public int getid() {
		return this.id;
	}
	
	public String getidString() {
		return String.valueOf(this.id);
	}
	
	public void setid(int id) {
		this.id = id;
	}
	public String getnome() {
		return nome;
	}
	public void setnome(String nome) {
		this.nome = nome;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getcelular() {
		return celular;
	}
	public void setcelular(String celular) {
		this.celular = celular;
	}
	public String getsenha() {
		return senha;
	}
	public void setsenha(String senha) {
		this.senha = senha;
	}
	public String getsexo() {
		return sexo;
	}
	public void setsexo(String sexo) {
		this.sexo = sexo;
	}
	public String getcpf() {
		return cpf;
	}
	public void setcpf(String cpf) {
		this.cpf = cpf;
	}
}