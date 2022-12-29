import java.time.LocalDateTime;
public class PassagemDeCrianca extends Passagem{

  
  private final static double desconto = 0.5;


  public PassagemDeCrianca(Voo voo, Pessoa pessoa, String assento){
    super(voo,pessoa,assento);
  }


  public void imprimePassagem(){
    Crianca crianca = (Crianca)this.getPessoa();
     System.out.println("__________________________\n\nVENTI AIRLINES | PASSAGEM INFANTIL\n\n "+crianca.getNome()+"\n DATA/DATE: "+this.getVoo().getDataPartida()+" | HORA/TIME: "+this.getVoo().getHorarioIda()+"\n DE/FROM: "+this.getVoo().getOrigem()+" | A/TO: "+this.getVoo().getDestino()+"\n ASSENTO/SEAT: "+this.getAssento()+"\n__________________________");
    //passagem de ida
    System.out.println("__________________________\n\nVENTI AIRLINES | PASSAGEM INFANTIL\n\n "+crianca.getNome()+"\n DATA/DATE: "+this.getVoo().getDataVolta()+" | HORA/TIME: "+this.getVoo().getHorarioVolta()+"\n DE/FROM: "+this.getVoo().getDestino()+" | A/TO: "+this.getVoo().getOrigem()+"\n ASSENTO/SEAT: "+this.getAssento()+"\n__________________________");
    //passagem de volta
  }


  public double getDesconto(){
    return desconto;
  }

  public double getValor(){
    Crianca crianca = (Crianca) this.getPessoa();
    if(crianca.getIdade()<6){
      return (getVoo().getPreco()*desconto);
      //desconto é aplicado caso a criança tenha menos que 6 anos de idade.
    }
    else
    {
      return getVoo().getPreco();
       //desconto não é aplicado
    }
  }
}