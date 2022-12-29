import java.time.LocalDateTime;

public class CartaoDeCredito  extends  Cartao{
    private double Fatura;
    private double LimiteDaFatura;

    CartaoDeCredito(String numeroDoCartao, int anoValidade, int mesValidade, String codigoDeSeguranca){
        super(numeroDoCartao , anoValidade, mesValidade , codigoDeSeguranca);
        this.Fatura = 0;
        this.LimiteDaFatura = 5000;
    }


    @Override public boolean VerificarCartao(double preco) {                                       //Este método verifica se é possível utilizar o catão de crédito para fazer o pagamento.
        if(this.Validade.isBefore(this.localDateTime) || (this.Fatura+preco>this.LimiteDaFatura)){ //Se o cartão estiver vencido ou o limite da fatura foi atingido, não será possível realizar o pagamento.
            return false;
        }
        else {
            return true;
        }
    }


    @Override public void Pagar(double preco) {                                                   //Neste método é realizado o pagamento.
        if (preco<0){                                                                             //Não será possível pagar se o preço for negativo.
            System.out.printf("\n Valor informado menor que R$0.00\n");
        }
        else{                                                                                     //Caso o preço seja válido, o método Verificar Cartão será acionado e dependendo de seu retorno, o pagamento será realizado ou não.
            if(VerificarCartao(preco)){
                this.Fatura = this.Fatura + preco;
                System.out.printf("\n Pagamento realizado com sucesso!!\n");
            }
            else {                                                                                 // Caso não seja possível pagar, uma mensagem informando o motivo será mostrada.
                String motivo = null;
                if(this.Validade.isBefore(this.localDateTime)){
                    motivo = "Cartao vencido!!";
                }
                if(this.Fatura+preco>this.LimiteDaFatura){
                    motivo = "Esta compra ultrapassará o limite do cartao!!";
                }
                if((this.Validade.isBefore(this.localDateTime)) && (this.Fatura+preco>this.LimiteDaFatura)){
                    motivo = "Cartao vencido e esta compra ultrapassará o limite do cartão!!";
                }
                System.out.printf("\n Pagamento não realizado. Motivo: %s\n",motivo);
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
