import java.time.LocalDateTime;
import java.util.ArrayList;

public class Voo {
	private String origem, destino;
	private double preco;
	private int assentosRestantes;
	private LocalDateTime dataPartida, dataVolta;
	private int indice;
	private ArrayList<String> assentos = new ArrayList<String>();

	public void setAssentos() { //Esse metodo vai adicionar os assentos ao voo, ele vai ser usado automaticamente dentro dos contstrutores
		this.assentos.add("1a");
		this.assentos.add("1b");
		this.assentos.add("1c");
		this.assentos.add("1d");
		this.assentos.add("1e");
		this.assentos.add("1f");
		this.assentos.add("2a");
		this.assentos.add("2b");
		this.assentos.add("2c");
		this.assentos.add("2d");
		this.assentos.add("2e");
		this.assentos.add("2f");
		this.assentosRestantes = this.assentos.size(); //esse metodo adiciona apenas um numero determinado x de assentos (12, no caso)
		//ele devera ser editado sempre que quisermos mudar o numero de assentos disponiveis.
		
	}
	
	Voo(){ //construtor vazio para o voo.
		origem = null;
		destino = null;
		preco = 0;
		assentosRestantes = 0;
		dataPartida = LocalDateTime.of(0, 1, 1, 0, 0);
		dataVolta = LocalDateTime.of(0, 1, 1, 0, 0);
		this.setAssentos();
	}
	
	Voo(String origem, String destino, double preco, int anoPartida, int mesPartida, int diaPartida, int horaPartida, int minutoPartida, int anoVolta, int mesVolta, int diaVolta, int horaVolta, int minutoVolta){
		this.origem = origem;
		this.destino = destino;
		this.preco = preco;
		assentosRestantes = 0;
		this.dataPartida = LocalDateTime.of(anoPartida, mesPartida, diaPartida, horaPartida, minutoPartida);
		this.dataVolta = LocalDateTime.of(anoVolta, mesVolta, diaVolta, horaVolta, minutoVolta);
		this.setAssentos();
	}
	
	public double getPreco() {
		return preco;
	}
	public int getAssentosRestantes() {
		return assentosRestantes;
	}
	public String getOrigem() {
		return origem;
	}
	public String getDestino() {
		return destino;
	}
	
	public String getHorarioIda() {
		return (dataPartida.getHour()+":"+dataPartida.getMinute());
	}
	public String getHorarioVolta() {
		return (dataVolta.getHour()+":"+dataVolta.getMinute());
	}
	//esses métodos retornam o horario no formato HH:MM
	public String getDataPartida() {
		return (dataPartida.getDayOfMonth()+"/"+dataPartida.getMonthValue()+"/"+dataPartida.getYear());
	}
	public String getDataVolta() {
		return (dataVolta.getDayOfMonth()+"/"+dataVolta.getMonthValue()+"/"+dataVolta.getYear());
	}
	//retornam o dia no formato DD/MM/AAAA
	public LocalDateTime getLocalDateTimePartida(){
		return this.dataPartida;
	}
	//retorna a data da partida no formato LocalDateTime, para permitir a comparação com a data atual
	public int getIndice(){
		return this.indice;
	}
	public void setIndice(int i){
		this.indice = i;
	}

	public ArrayList getAssentos(){
		return this.assentos;
	}

	
	public void ocupaAssento(String a) { //remove um assento do voo, se nao ha assentos disponveis ou se o assento a ser removido ja esta ocupado, retorna um erro.
		if(this.assentosRestantes > 0) {
			int flag = 0;
			for(int i = 0; i<this.assentos.size(); i++) {
				if(this.assentos.get(i).equals(a)) {
					this.assentos.set(i, "ocupado");
					this.assentosRestantes--;
					flag++;
				}
			}
			if (flag == 0) {
				System.out.printf("Assento nao disponivel.");
			}
		}
		
		else{
			System.out.printf("Nao ha assentos restantes no voo.");
		}
	}
	
	public void limpaAssentos() {
		this.assentos.clear();
		this.assentosRestantes = 0;
	}//remove todos os assentos do voo, usado para propósitos de teste
	
	public void mostraAssentosDisponiveis() {//printa um "mapa" dos assentos disponiveis no voo
		for (int i=0, j=1; i<assentos.size(); i++, j++) {
			if (this.assentos.get(i) == "ocupado") {
				System.out.printf("   ");
			}
			if (this.assentos.get(i) != "ocupado") {
				System.out.printf(this.assentos.get(i)+" ");
			}
			
			if(j==3) {
				System.out.printf("   ");
			}
			
			if(j==6) {
				System.out.printf("\n");
				j = 0;
			}
		}
	}
	
	

}
