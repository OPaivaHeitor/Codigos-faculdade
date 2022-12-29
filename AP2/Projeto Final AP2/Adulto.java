public class Adulto implements Pessoa
{
  private String numeroDeIdentificacaoExclusivo;
  private String nome;

  Adulto()
  {
    nome = "nao preenchido";
    numeroDeIdentificacaoExclusivo = "nao preenchido";
  }
  public Adulto(String n,String numero)
  {
    nome = n;
    numeroDeIdentificacaoExclusivo = numero;
  }

  public String getNome()
  {
    return nome;
  }
  public void setNome(String n)
  {
    nome = n;
  }

  public String getIdentificacao()
  {
    return numeroDeIdentificacaoExclusivo;
  }

}