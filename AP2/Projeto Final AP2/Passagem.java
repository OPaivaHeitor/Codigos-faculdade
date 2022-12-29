import java.time.LocalDateTime;
public class Passagem{


  private Voo voo;
  private String assento;
  private Pessoa pessoa;


  public Passagem(Voo voo, Pessoa pessoa, String assento){
    this.voo = voo;
    this.pessoa = pessoa;
    this.assento = assento; 
    voo.ocupaAssento(assento); //coloca o assento como ocupado dentro do voo.
  }


  public void imprimePassagem(){
    Adulto adulto = (Adulto)this.getPessoa();
    System.out.println("__________________________\n\nVENTI AIRLINES\n\n "+adulto.getNome()+"\n DATA/DATE: "+this.getVoo().getDataPartida()+" | HORA/TIME: "+this.getVoo().getHorarioIda()+"\n DE/FROM: "+this.getVoo().getOrigem()+" | A/TO: "+this.getVoo().getDestino()+"\n ASSENTO/SEAT: "+this.getAssento()+"\n__________________________");
    //passagem de ida
    System.out.println("__________________________\n\nVENTI AIRLINES\n\n "+adulto.getNome()+" \n DATA/DATE: "+this.getVoo().getDataVolta()+" | HORA/TIME: "+this.getVoo().getHorarioVolta()+"\n DE/FROM: "+this.getVoo().getDestino()+" | A/TO: "+this.getVoo().getOrigem()+"\n ASSENTO/SEAT: "+this.getAssento()+"\n__________________________");
    //passagem de volta
  }
  
  public Voo getVoo(){
    return voo;
  }
  public void setVoo(Voo voo){
    this.voo = voo;
  }

  public String getAssento(){
    return assento;
  }
  public void setAssento(String assento){
    this.assento=assento;
    voo.ocupaAssento(assento);
  }


  public Pessoa getPessoa(){
    return pessoa;
  }
  public void setPessoa(Pessoa pessoa){
    this.pessoa = pessoa;
  }

  public double getValor(){
    return getVoo().getPreco();
  }

  
}