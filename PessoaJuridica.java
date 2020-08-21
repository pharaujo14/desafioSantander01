package desafioSantander01;

public class PessoaJuridica extends Funcionario{
	
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public PessoaJuridica(String endereco, String nome, String email, String setor, String dataAd, 
			String ultimaFerias, double salario, String cnpj) {
		super(endereco, nome, email, setor, dataAd, ultimaFerias, salario);
		this.cnpj = cnpj;
	}
	
	
}
