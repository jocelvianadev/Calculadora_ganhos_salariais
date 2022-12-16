package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	
	private String nome;
	private Double salarioBase;
	private NivelTrabalhador nivel;
	
	//Composição
	private Departamento departamento;
	private List<HoraContrato> contratos = new ArrayList<>();
	
	//Construtor vazio
	public Trabalhador() {
		
	}
	//Construtor com argumentos
	//Obs: composição "tem muitos" não é inclusa no construtor (no caso a lista contratos)
	public Trabalhador(String nome, Double salarioBase, NivelTrabalhador nivel, Departamento departamento) {
		this.nome = nome;
		this.salarioBase = salarioBase;
		this.nivel = nivel;
		this.departamento = departamento;
	}
	
	//Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public NivelTrabalhador getNivel() {
		return nivel;
	}
	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public List<HoraContrato> getContratos() {
		return contratos;
	}
	
	//Métodos da classe
	//=================================================
	//Adicionar
	public void adicionarContrato(HoraContrato contrato) {
		contratos.add(contrato);
	}
	
	//Remover
	public void removerContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}
	
	//Calcular ganhos
	public double ganhos(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for(HoraContrato c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if(ano == c_ano && mes == c_mes) {
				soma += c.valorTotal()
;			}
		}
		return soma;
	}
	
}
