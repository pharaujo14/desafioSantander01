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
		System.out.printf("A sua bonifica��o � de: R$%.2f %n", this.bonificacao);		
	}
	
	@Override
	public void demitir(Funcionario funcionario) {
		if(funcionario instanceof Gerente) {
			System.out.println("Voc� n�o est� habilitado para essa opera��o");
		}else {
			LocalDateTime ld = LocalDateTime.now();
			String formattedDate = ld.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
			funcionario.setDataDe(formattedDate);
			System.out.printf("O funcion�rio %s foi demitido em : %s %n", funcionario.getNome(), funcionario.getDataDe());
		}
				
	}
	
	public void ajustarSalario(Funcionario funcionario) {
		double aumento = 0;
		if(funcionario instanceof Gerente) {
			System.out.println("Voc� n�o est� habilitado para essa opera��o");
		}else {
			Scanner sc = new Scanner(System.in);
			System.out.print("Digite o acr�scimo que ser� realizado (ex: 0,05): ");
			aumento = sc.nextDouble();
			if (aumento < 0) {
				System.out.println("N�o � poss�vel diminuir o sal�rio");
			} else {
				funcionario.setSalario(funcionario.getSalario() + funcionario.getSalario() * aumento);
				System.out.printf("Aumento realizado com sucesso, o novo sal�rio do funcion�rio %s �: %.2f %n", funcionario.getNome(), funcionario.getSalario());
			}
			sc.close();			
		}
				
	}

}
