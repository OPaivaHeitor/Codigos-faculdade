import java.time.LocalDateTime;

public class CartaoDeCredito  extends  Cartao{
    private double Fatura;
    private double LimiteDaFatura;

    CartaoDeCredito(String numeroDoCartao, int anoValidade, int mesValidade, String codigoDeSeguranca){
        super(numeroDoCartao , anoValidade, mesValidade , codigoDeSeguranca);
        this.Fatura = 0;
        this.LimiteDaFatura = 5000;
    }


    @Override public boolean VerificarCartao(double preco) {                                       //Este m�todo verifica se � poss�vel utilizar o cat�o de cr�dito para fazer o pagamento.
        if(this.Validade.isBefore(this.localDateTime) || (this.Fatura+preco>this.LimiteDaFatura)){ //Se o cart�o estiver vencido ou o limite da fatura foi atingido, n�o ser� poss�vel realizar o pagamento.
            return false;
        }
        else {
            return true;
        }
    }


    @Override public void Pagar(double preco) {                                                   //Neste m�todo � realizado o pagamento.
        if (preco<0){                                                                             //N�o ser� poss�vel pagar se o pre�o for negativo.
            System.out.printf("\n Valor informado menor que R$0.00\n");
        }
        else{                                                                                     //Caso o pre�o seja v�lido, o m�todo Verificar Cart�o ser� acionado e dependendo de seu retorno, o pagamento ser� realizado ou n�o.
            if(VerificarCartao(preco)){
                this.Fatura = this.Fatura + preco;
                System.out.printf("\n Pagamento realizado com sucesso!!\n");
            }
            else {                                                                                 // Caso n�o seja poss�vel pagar, uma mensagem informando o motivo ser� mostrada.
                String motivo = null;
                if(this.Validade.isBefore(this.localDateTime)){
                    motivo = "Cartao vencido!!";
                }
                if(this.Fatura+preco>this.LimiteDaFatura){
                    motivo = "Esta compra ultrapassar� o limite do cartao!!";
                }
                if((this.Validade.isBefore(this.localDateTime)) && (this.Fatura+preco>this.LimiteDaFatura)){
                    motivo = "Cartao vencido e esta compra ultrapassar� o limite do cart�o!!";
                }
                System.out.printf("\n Pagamento n�o realizado. Motivo: %s\n",motivo);
                System.exit(0);
            }
        }

    }

    public double getFatura() {
        return Fatura;
    }
    public void setFatura(double fatura) {
        Fatura = fatura;
    }

}
