package desafioSantander01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Funcionario {
	
	private String endereco;
	private String nome;
	private String email;
	private String setor;
	private String dataAd;
	private String dataDe;
	private String ultimaFerias;
	private double salario;
	private boolean estaFerias = false;
		
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSetor() {
		return setor;
	}
	
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public String getDataAd() {
		return dataAd;
	}
	
	public void setDataAd(String dataAd) {
		this.dataAd = dataAd;
	}
	
	public String getDataDe() {
		return dataDe;
	}
	
	public void setDataDe(String dataDe) {
		this.dataDe = dataDe;
	}
	
	public String getUltimaFerias() {
		return ultimaFerias;
	}

	public void setUltimaFerias(String ultimaFerias) {
		this.ultimaFerias = ultimaFerias;
	}

	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public boolean isEstaFerias() {
		return estaFerias;
	}

	public void setEstaFerias(boolean estaFerias) {
		this.estaFerias = estaFerias;
	}

	public Funcionario(String endereco, String nome, String email, String setor, String dataAd, 
			String ultimaFerias, double salario) {
		this.endereco = endereco;
		this.nome = nome;
		this.email = email;
		this.setor = setor;
		this.dataAd = dataAd;
		this.ultimaFerias = ultimaFerias;
		this.salario = salario;
	}

	public void consultarContraCheque() {
		System.out.printf("O salário recebido nesse mês será de: R$ %.2f %n", getSalario());
	}
	
	public void trabalhar() {
		if (this.estaFerias == true) {
			System.out.println("Você está de férias, volte para casa");
		} else {
			System.out.printf("Bem vindo ao trabalho %s %n", this.getNome());
		}
	}
	
	public void pedirDemissao() {
		LocalDateTime ld = LocalDateTime.now();
		String formattedDate = ld.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
		this.setDataDe(formattedDate);
		System.out.printf("Demissão realizada com sucesso em: %s %n", getDataDe());
	}
	
	public void solicitarAumento() {
		int sorteio = 0;
		sorteio = (int) (1 + Math.random() * 60);
		
		if (sorteio % 2 == 0) {
			this.setSalario(getSalario() + getSalario() * 0.15);
			System.out.printf("Aumento aprovado, seu novo salário é de: R$ %.2f %n", this.getSalario());
		} else {
			System.out.println("Aumento reprovado");
		}
	}
	
	public void solicitarFerias() { 
		DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
		LocalDateTime dataAtual = LocalDateTime.now();
		LocalDateTime dataAdDate = LocalDateTime.parse(this.dataAd, mascara);
		LocalDateTime ultimasFeriasDate = LocalDateTime.parse(this.ultimaFerias, mascara);
		
		int intervaloAd = (int) ChronoUnit.DAYS.between(dataAdDate, dataAtual);
		int intervaloUltimasFerias = (int) ChronoUnit.DAYS.between(ultimasFeriasDate, dataAtual);
		
		if (intervaloAd > 330 && intervaloUltimasFerias > 120) {
			System.out.println("Férias aprovadas");
			
			String formattedDate = dataAtual.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
			this.ultimaFerias = formattedDate;
			this.estaFerias = true;
		} else {
			System.out.println("Você não pode tirar férias");
		}

	}
	

}
