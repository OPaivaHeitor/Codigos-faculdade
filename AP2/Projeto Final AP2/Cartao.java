import java.time.LocalDateTime;

public abstract class Cartao {
    protected String NumeroDoCartao;
    protected LocalDateTime Validade;
    protected String CodigoDeSeguranca;
    protected LocalDateTime localDateTime;                                         //Este atributo será ultilizado para verificar se o cartão de crédito ou débito informado está vencido.

    //this.Validade = LocalDateTime.of(anoValidade, mesValidade, 31, 23, 59);
    Cartao (String numeroDoCartao,int anoValidade, int mesValidade,String codigoDeSeguranca){
        this.NumeroDoCartao = numeroDoCartao;

        if(mesValidade<8){
          if(mesValidade==2){
            this.Validade = LocalDateTime.of(anoValidade, mesValidade, 28, 23, 59);
          }
          else if(mesValidade%2==0){
            this.Validade = LocalDateTime.of(anoValidade, mesValidade, 30, 23, 59);
          }
          else{
            this.Validade = LocalDateTime.of(anoValidade, mesValidade, 31, 23, 59);
          }
        }
        else{
          if(mesValidade%2==0){
            this.Validade = LocalDateTime.of(anoValidade, mesValidade, 31, 23, 59);
          }
          else{
            this.Validade = LocalDateTime.of(anoValidade, mesValidade, 30, 23, 59);
          }
        }
        
        this.CodigoDeSeguranca = codigoDeSeguranca;
        this.localDateTime = LocalDateTime.now();
    }

    abstract public boolean VerificarCartao(double preco);
    abstract public void Pagar(double preco);                                     //Estes métodos abstratos serão sobreescritos em cada tipo de cartão pois cada um deles irá executa-los de uma maneira particular.


    public String getNumeroDoCartao() {
        return this.NumeroDoCartao;
    }

    public String getValidade(){
      return (Validade.getYear()+"/"+Validade.getMonthValue());
    }
    public String getCodigoDeSeguranca() {
        return this.CodigoDeSeguranca;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.NumeroDoCartao = numeroDoCartao;
    }
    public void setValidade(LocalDateTime validade) {
        this.Validade = validade;
    }
    public void setCodigoDeSeguranca(String codigoDeSeguranca) {
        this.CodigoDeSeguranca = codigoDeSeguranca;
    }


}
