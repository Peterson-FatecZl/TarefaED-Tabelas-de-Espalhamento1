package view;

import javax.swing.JOptionPane;

import controller.Controle_de_Peso_Chocolate;
import model.ListaEncadeadaSimples_TipoGenerico;

public class Principal {

	public static void main(String[] args) {

		@SuppressWarnings("unchecked")
		ListaEncadeadaSimples_TipoGenerico<Integer>[] tabelaComBarrasChocolate = new ListaEncadeadaSimples_TipoGenerico[5];
		Controle_de_Peso_Chocolate calcula = new Controle_de_Peso_Chocolate();
		String[] name = { "Bombons", "Pavês", "Brigadeiros", "Bolos", "Ovos de Pascoa" };

		for (int i = 0; i < tabelaComBarrasChocolate.length; i++) {
			tabelaComBarrasChocolate[i] = new ListaEncadeadaSimples_TipoGenerico<>();
		}
		try {
			int opc = Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Adiciona Barra\n2 - Visualiza Lista\n9 - Sair", "Insira a opção Desejada", -1));
			while (opc != 9) {
				switch (opc) {
				case 1:

					double l = Double.parseDouble(JOptionPane.showInputDialog("Insira a Largura da Barra de Chocolate"));
					double c = Double.parseDouble(JOptionPane.showInputDialog("Insira o Comprimento da Barra de Chocolate"));
					double h = Double.parseDouble(JOptionPane.showInputDialog("Insira a Altura da Barra de Chocolate"));

					calcula.CalculaVolumeBarraEColocaNaLista(tabelaComBarrasChocolate, l, c, h);
					break;

				case 2://visualiza cada linha da tabela, mostrando os volumes e ordem de entrada das barras de chocolate
					for (int i = 0; i < tabelaComBarrasChocolate.length; i++) {
						System.out.println("Quantidade de "+name[i]);
						for (int ctd = 0; ctd < tabelaComBarrasChocolate[i].size(); ctd++) {
							System.out.println((ctd+1)+"° "+tabelaComBarrasChocolate[i].getValue(ctd)+"g");
						}
						System.out.println("Total de "+name[i]+" "+tabelaComBarrasChocolate[i].size()+"\n");
					}
					break;
				case 9:
					// Pass
					break;

				default:
					throw new Exception("Opção Inválida");
				}
				opc = Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Adiciona Barra\n2 - Visualiza Lista\n9 - Sair", "Insira a opção Desejada", -1));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
