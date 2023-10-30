package controller;

import model.ListaEncadeadaSimples_TipoGenerico;
import model_morador.Morador;

public class Controle_de_Moradores {

	@SuppressWarnings("unchecked")
	private ListaEncadeadaSimples_TipoGenerico<Morador>[] andares = new ListaEncadeadaSimples_TipoGenerico[10];

	public Controle_de_Moradores() {
		for (int i = 0; i < andares.length; i++) {// Preenche Vetor
			andares[i] = new ListaEncadeadaSimples_TipoGenerico<Morador>();
		}
	}
	
	//Exíbe moradores do andar
	public void listarAndar(String numAndar) throws Exception {
		numAndar = numAndar.toLowerCase();//tratamento de case
		if("t".equals(numAndar)) {//Térreo
			for(int ctd = 0; ctd < andares[0].size(); ctd++) {
				System.out.println(andares[0].getValue(ctd));//pega cada morador do andar e exibe.
			}
		}else {
			int num = Integer.parseInt(numAndar);//Transforma o número do andar em inteiro
			if(num > 0 && num < 10) {
				for(int ctd = 0; ctd < andares[num].size(); ctd++) {
					System.out.println(andares[num].getValue(ctd));//pega cada morador do andar e exibe.				
				}
			}else {
				throw new Exception("Andar Inexistente!");
			}
		}
		
	}
	
	// Cadastrar
	public void cadatrarMorador(String nomeMorador, int numeroApartamento, String veiculo, String corVeiculo, String placaVeiculo) throws Exception {
		Morador moradorSendoCadastrado = new Morador(nomeMorador, numeroApartamento, veiculo, corVeiculo, placaVeiculo);
		int andar = hash(numeroApartamento);
		
		andares[andar].addLast(moradorSendoCadastrado);

	}

	//Consultar
	public void consultarMorador(int numeroApartamento) throws Exception {
		int andar = hash(numeroApartamento);
		boolean encontrou = false;
		
		for(int ctd = 0; ctd < andares[andar].size();ctd++) {
			//verifica em cada nó da lista se existe algum morador com aquele número de quarto no andar.
			if(andares[andar].getValue(ctd).NumeroApartamento == numeroApartamento) {
				System.out.println("Este quarto está sendo ocupado pelo morador: ");
				System.out.println(andares[andar].getValue(ctd));
				encontrou = true;
			}
		}
		if(encontrou == false) {//caso o número de quarto não possua morador
			System.out.println("Não Existe nenhum morador ocupando este quarto");
		}
		
	}

	//Excluir
	public void excluiMorador(String nomeMorador, int numeroApartamento) throws Exception {
		int Andar = hash(numeroApartamento);
		
		for(int ctd = 0; ctd < andares[Andar].size(); ctd++) {
			if((andares[Andar].getValue(ctd).NomeMorador.equals(nomeMorador)) && (andares[Andar].getValue(ctd).NumeroApartamento == numeroApartamento)) {
				System.out.println("MORADOR EXCLUÍDO");
				System.out.println(andares[Andar].getValue(ctd));				
				andares[Andar].remove(ctd);
			}
		}
		
	}
	
	//Função Hash
	private int hash(int numeroApartamento) {
		int andar = 0;
		while (numeroApartamento >= 100) {
			numeroApartamento -= 100;
			andar += 1;
		}
		return andar;
	}

}
