package model_morador;

public class Morador {
	public String NomeMorador;
	public int NumeroApartamento;
	public String ModeloCarro;
	public String CorCarro;
	public String PlacaCarro;
	
	public Morador() {
		super();
	}
	
	public Morador(String nomeMorador, int numeroApartamento, String modeloCarro, String corCarro, String placaCarro) {
		 this.NomeMorador = nomeMorador;
		 this.NumeroApartamento = numeroApartamento;
		 this.ModeloCarro = modeloCarro;
		 this.CorCarro = corCarro;
		 this.PlacaCarro = placaCarro;
	}
	
	public String toString() {
		return "Nome: "+NomeMorador+"\nApartamento: "+NumeroApartamento+"\nVeículo: "+ModeloCarro+"\nCor do Veículo: " +CorCarro+"\nPlaca: "+PlacaCarro+"\n";
	}
}
