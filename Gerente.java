package desafioSantander01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Gerente extends PessoaFisica{
	
	private double bonificacao = this.getSalario() * 0.12;
	
	public Gerente(String endereco, String nome, String email, String setor, String dataAd, String ultimaFerias, double salario,
			String cpf, String nit) {
		super(endereco, nome, email, setor, dataAd, ultimaFerias, salario, cpf, nit);
	}
	
	@Override
	public void exibirBonificacao() {
		System.out.printf("A sua bonificação é de: R$%.2f %n", this.bonificacao);		
	}
	
	@Override
	public void demitir(Funcionario funcionario) {
		if(funcionario instanceof Gerente) {
			System.out.println("Você não está habilitado para essa operação");
		}else {
			LocalDateTime ld = LocalDateTime.now();
			String formattedDate = ld.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
			funcionario.setDataDe(formattedDate);
			System.out.printf("O funcionário %s foi demitido em : %s %n", funcionario.getNome(), funcionario.getDataDe());
		}
				
	}
	
	public void ajustarSalario(Funcionario funcionario) {
		double aumento = 0;
		if(funcionario instanceof Gerente) {
			System.out.println("Você não está habilitado para essa operação");
		}else {
			Scanner sc = new Scanner(System.in);
			System.out.print("Digite o acréscimo que será realizado (ex: 0,05): ");
			aumento = sc.nextDouble();
			if (aumento < 0) {
				System.out.println("Não é possível diminuir o salário");
			} else {
				funcionario.setSalario(funcionario.getSalario() + funcionario.getSalario() * aumento);
				System.out.printf("Aumento realizado com sucesso, o novo salário do funcionário %s é: %.2f %n", funcionario.getNome(), funcionario.getSalario());
			}
			sc.close();			
		}
				
	}

}
