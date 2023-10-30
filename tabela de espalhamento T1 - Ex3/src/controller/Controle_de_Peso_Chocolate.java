package controller;

import model.ListaEncadeadaSimples_TipoGenerico;

public class Controle_de_Peso_Chocolate {
	
	
	public Controle_de_Peso_Chocolate() {
		super();
	}
	
	//L => Largura
	//C => Comprimento
	//h => Altura
	
	public void CalculaVolumeBarraEColocaNaLista(ListaEncadeadaSimples_TipoGenerico<Integer>[] lista, double L, double C,double h) throws Exception {
		int volume = (int)(L *C* h);
		int lugarNaLista = hash(volume);
		lista[lugarNaLista].addLast(volume);
	}

	private int hash(int V) throws Exception {
		if (V >= 50 && V <= 60) {
			return 0;
		} else if (V >= 100 && V <= 110) {
			return 1;
		} else if (V >= 150 && V <= 165) {
			return 2;
		} else if (V >= 200 && V <= 220) {
			return 3;
		} else if (V >= 260 && V <= 280) {
			return 4;
		} else {
			throw new Exception("Volume fora do pradrão, confirme os valores inseridos");
		}				
	}

}
