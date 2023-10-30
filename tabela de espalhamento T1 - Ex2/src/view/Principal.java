package view;

import javax.swing.JOptionPane;

import controller.Controle_de_Moradores;

public class Principal {

	public static void main(String[] args) {
		Controle_de_Moradores  controle_moradores = new Controle_de_Moradores();

		try {
			int opc = Integer.parseInt(JOptionPane.showInputDialog(null,
					"INSIRA O NUMERO DA OPÇÃO DESEJADA\n"+
					"1 - Cadastrar Morador\n"+
					"2 - Consultar Quarto\n"+
					"3 - Excluir Morador\n"+
					"4 - Listar todos os Moradores do Andar\n"+
					"9 - Sair",
					"Sistema do Condomínio",
					JOptionPane.DEFAULT_OPTION));
			
			while(opc != 9) {
				switch (opc) {
					case 1:
						String name = JOptionPane.showInputDialog("Insira o nome do morador");
						int number = Integer.parseInt(JOptionPane.showInputDialog("Insira o número do apartamento"));
						String car = JOptionPane.showInputDialog("Insira o nome do veículo");
						String colorCar = JOptionPane.showInputDialog("Insira a cor do veículo");
						String codeCar = JOptionPane.showInputDialog("Insira a placa do veículo");
						
						controle_moradores.cadatrarMorador(name, number, car, colorCar, codeCar);
						break;
					
					case 2:
						number = Integer.parseInt(JOptionPane.showInputDialog("Insira o número do apartamento"));
						controle_moradores.consultarMorador(number);
						break;
				
					case 3:
						name = JOptionPane.showInputDialog("Insira o nome do morador");
						number = Integer.parseInt(JOptionPane.showInputDialog("Insira o número do apartamento"));
						controle_moradores.excluiMorador(name, number);
						break;
						
					case 4:
						String andar = JOptionPane.showInputDialog("Insira o número do Andar");
						controle_moradores.listarAndar(andar);
						
					case 9:
						//faz nada
						break;
				
					default:
						throw new IllegalArgumentException("Opção Invalida");
				}						
				opc = Integer.parseInt(JOptionPane.showInputDialog(null,"INSIRA O NUMERO DA OPÇÃO DESEJADA\n"+"1 - Cadastrar Morador\n"+"2 - Consultar Quarto\n"+"3 - Excluir Morador\n"+"4 - Listar todos os Moradores do Andar\n"+"9 - Sair","Sistema do Condomínio",JOptionPane.DEFAULT_OPTION));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
