import java.time.LocalDateTime;

public class CartaoDeDebito extends Cartao{
    private double Saldo;

    CartaoDeDebito(String numeroDoCartao, int anoValidade, int mesValidade, String codigoDeSeguranca, double saldo){
        super(numeroDoCartao , anoValidade, mesValidade , codigoDeSeguranca);
        this.Saldo = saldo;
    }


    @Override public boolean VerificarCartao(double preco) {                         //Este método verifica se é possível utilizar o catão de débito para fazer o pagamento.
        if(preco>this.Saldo || this.Validade.isBefore(this.localDateTime)){          //Se o saldo for insuficiente ou o cartão estiver vencido, não será possível realizar o pagamento.
            return false;
        }
        else{
            return true;
        }
    }


    @Override  public void Pagar(double preco) {                                      //Neste método é realizado o pagamento.
        if (preco<0){                                                                 //Não será possível pagar se o preço for negativo.
            System.out.printf("\n Valor informado menor que R$0.00\n");
        }
        else{                                                                         //Caso o preço seja válido, o método Verificar Cartão será acionado e dependendo de seu retorno, o pagamento será realizado ou não.
            if(VerificarCartao(preco)){
                this.Saldo = this.Saldo - preco;
                System.out.printf("\n Pagamento realizado com sucesso!!\n");
            }
            else {                                                                    // Caso não seja possível pagar, uma mensagem informando o motivo será mostrada.

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
                System.out.printf("\n Pagamento não realizado. Motivo: %s\n",motivo);
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

