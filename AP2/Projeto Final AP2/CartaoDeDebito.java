import java.time.LocalDateTime;

public class CartaoDeDebito extends Cartao{
    private double Saldo;

    CartaoDeDebito(String numeroDoCartao, int anoValidade, int mesValidade, String codigoDeSeguranca, double saldo){
        super(numeroDoCartao , anoValidade, mesValidade , codigoDeSeguranca);
        this.Saldo = saldo;
    }


    @Override public boolean VerificarCartao(double preco) {                         //Este m�todo verifica se � poss�vel utilizar o cat�o de d�bito para fazer o pagamento.
        if(preco>this.Saldo || this.Validade.isBefore(this.localDateTime)){          //Se o saldo for insuficiente ou o cart�o estiver vencido, n�o ser� poss�vel realizar o pagamento.
            return false;
        }
        else{
            return true;
        }
    }


    @Override  public void Pagar(double preco) {                                      //Neste m�todo � realizado o pagamento.
        if (preco<0){                                                                 //N�o ser� poss�vel pagar se o pre�o for negativo.
            System.out.printf("\n Valor informado menor que R$0.00\n");
        }
        else{                                                                         //Caso o pre�o seja v�lido, o m�todo Verificar Cart�o ser� acionado e dependendo de seu retorno, o pagamento ser� realizado ou n�o.
            if(VerificarCartao(preco)){
                this.Saldo = this.Saldo - preco;
                System.out.printf("\n Pagamento realizado com sucesso!!\n");
            }
            else {                                                                    // Caso n�o seja poss�vel pagar, uma mensagem informando o motivo ser� mostrada.

                String motivo = null;
                if(this.Validade.isBefore(this.localDateTime)){
                    motivo = "Cartao vencido!!";
                }
                if(preco>this.Saldo){
                    motivo = "Saldo insuficiente!!";
                }
                if(this.Validade.isBefore(this.localDateTime) && preco>this.Saldo){
                    motivo = "Cartao vencido e saldo insuficiente!!";
                }
                System.out.printf("\n Pagamento n�o realizado. Motivo: %s\n",motivo);
                System.exit(0);

            }

        }
    }

    public double getSaldo() {
        return this.Saldo;
    }
    public void setSaldo(double saldo) {
        this.Saldo = saldo;
    }

}

