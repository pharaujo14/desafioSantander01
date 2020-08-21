package desafioSantander01;

public class FuncionarioApp {
	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario("Rua x", "Paulo", "pharaujo14@gmail.com", "sistemas", "11-01-2014 11:30", "11-01-2019 11:30", 5700.00);
		f1.consultarContraCheque();
		f1.trabalhar();
		f1.solicitarAumento();
		f1.solicitarFerias();
		f1.trabalhar();
		f1.solicitarFerias();
		System.out.printf("Suas últimas férias foram em: %s %n", f1.getUltimaFerias());
		System.out.println("-------------------------------------------------------");
		
		Supervisor s1 = new Supervisor("Rua x", "João", "joao@gmail.com", "contabil", "01-01-2010 08:00", "01-01-2020 08:00", 15000.00, "000.000.000-00", "123456");
		s1.trabalhar();
		s1.exibirBonificacao();
		s1.demitir(f1);
		System.out.println("-------------------------------------------------------");
		
		Supervisor s2 = new Supervisor("Rua x", "Mario", "mario@gmail.com", "contabil", "01-01-2010 08:00", "01-01-2020 08:00", 15000.00, "000.000.000-00", "123456");
		s2.trabalhar();
		s2.demitir(s1);
		System.out.println("-------------------------------------------------------");
		
		Gerente g1 = new Gerente("Rua x", "Gustavo", "gustavo@gmail.com", "diretoria", "01-01-1990 08:00", "01-01-2020 08:00", 30000.00, "000.000.000-00", "123456");
		g1.trabalhar();
		g1.exibirBonificacao();
		g1.ajustarSalario(s1);
		g1.demitir(s1);
		System.out.println("-------------------------------------------------------");
		
		Gerente g2 = new Gerente("Rua x", "Pedro", "pedro@gmail.com", "diretoria", "01-01-1990 08:00", "01-01-2020 08:00", 30000.00, "000.000.000-00", "123456");
		g2.trabalhar();
		g2.demitir(s2);
		g2.ajustarSalario(g1);
		g2.demitir(g1);
	}
	

}
