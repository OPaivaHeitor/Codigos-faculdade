import java.util.Random;
import java.util.ArrayList;
public class Compra{

  private int voucherCompra;
  private ArrayList<Passagem> passagens = new ArrayList<Passagem>();
  private Random gerador = new Random();
  private double somaPreco;
  

  Compra(){
    voucherCompra = gerador.nextInt(1000000);
  }
  //cada elemento do tipo compra gera para si um voucher/recibo aleatorio entre 0 e 1000000
  


  public void setVoucher(int a){
    voucherCompra = a;
  }
  
  public int getVoucher(){
    return voucherCompra;
  }
  //Setters para os atributos

  public void adicionaPassagem(Passagem a){
    this.passagens.add(a);
  }
  //durante a compra, para cada passagem compra ela sera adicionada por este metodo a arraylist 


  public double precoTotal(){
    somaPreco = 0;
    for(int i=0;i<passagens.size();i++){
  
      somaPreco += passagens.get(i).getValor();
    }

    return somaPreco;
  }
  //metodo que soma todos os elementos da compra e retorna o preço total por conveniencia



  public void imprimeCompra(){
    System.out.println(" Voucher:"+this.getVoucher()+" Total de passagens compradas: "+(this.passagens).size()+" valor da compra: "+this.precoTotal()); 
    
  }
  //metodo que imprime os detalhes da compra
  
  public void imprimePassagens(){
    for(int i=0;i<passagens.size();i++){
      this.passagens.get(i).imprimePassagem();
    }
  }
  //metodo que usa do comando de ImprimePassagem da classe passagem sobre a arraylist

}