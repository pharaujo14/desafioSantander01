package desafioSantander01;

public class PessoaFisica extends Funcionario{
	
	private String cpf;
	private String nit;	
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}
	
	public PessoaFisica(String endereco, String nome, String email, String setor, String dataAd, 
			String ultimaFerias, double salario, String cpf, String nit) {
		super(endereco, nome, email, setor, dataAd, ultimaFerias, salario);
		this.cpf = cpf;
		this.nit = nit;
	}


	public void exibirBonificacao() {
		System.out.println("Você não está habilitado para bonificação");		
	}
	
	public void demitir(Funcionario funcionario) {
		System.out.println("Você não está habilitado para essa operação");
	}
	

}
