public class Crianca implements Pessoa
{
  private int idade;
  private String nome;
  private String matriculaDeCertidaoDeNascimento;

  Crianca()
  {
    nome = "Nao preenchido";
    idade = 0;
    matriculaDeCertidaoDeNascimento = "Nao preenchido";
  }
  public Crianca(String n,int i,String matricula)
  {
    nome = n;
    idade = i;
    matriculaDeCertidaoDeNascimento = matricula;
  }

  public void setIdade(int i)
  {
    idade = i;
  }
  public int getIdade()
  {
    return idade;
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
    return matriculaDeCertidaoDeNascimento;
  }
}