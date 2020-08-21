package desafioSantander01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Supervisor extends PessoaFisica{
	
	private double bonificacao = 0;
	
	public Supervisor(String endereco, String nome, String email, String setor, String dataAd, String ultimaFerias, double salario,
			String cpf, String nit) {
		super(endereco, nome, email, setor, dataAd, ultimaFerias, salario, cpf, nit);
	}
	
	@Override
	public void exibirBonificacao() {
		bonificacao = this.getSalario() * 0.08;
		System.out.printf("A sua bonificação é de: R$%.2f %n", this.bonificacao);		
	}
	
	@Override
	public void demitir(Funcionario funcionario) {
		if(funcionario instanceof Gerente || funcionario instanceof Supervisor) {
			System.out.println("Você não está habilitado para essa operação");
		}else {
			LocalDateTime ld = LocalDateTime.now();
			String formattedDate = ld.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
			funcionario.setDataDe(formattedDate);
			System.out.printf("O funcionário %s foi demitido em : %s %n", funcionario.getNome(), funcionario.getDataDe());
		}
	}
	
}
