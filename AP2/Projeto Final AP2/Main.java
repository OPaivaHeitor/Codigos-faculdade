import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Main {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    LocalDateTime dataHoje;
    dataHoje = LocalDateTime.now();

    //criacao dos voos
    Voo vooGoianiaSaoPaulo1 = new Voo("Goiania", "Sao Paulo", 616,  2020, 12, 12, 17, 30, 2020, 12, 25, 20, 30); //Voo saindo de Goiania, destino a Sao Paulo, com preco de R$616,00 com ida 12/12/2020 17:30 e volta 25/12/2020 20:30
    
    Voo vooGoianiaSaoPaulo2 = new Voo("Goiania", "Sao Paulo", 724,  2020, 12, 20, 15, 00, 2020, 12, 30, 14, 00); //Voo saindo de Goiania, destino a Sao Paulo, com preco de R$724,00 com ida 20/12/2020 15:00 e volta 30/12/2020 14:00
    
    Voo vooGoianiaSaoPaulo3 = new Voo("Goiania", "Sao Paulo", 479,  2020, 12, 31, 7, 30, 2021, 01, 2, 20, 00);//Voo saindo de Goiania, destino a Sao Paulo, com preco de R$479,00 com ida 31/12/2020 7:30 e volta 25/12/2020 20:00

   
    Voo vooSaoPauloBrasilia1 = new Voo("Sao Paulo", "Brasilia", 320, 2020, 12, 13, 18, 40, 2020, 12, 24, 9, 35);//Voo saindo de Sao Paulo, destino a Brasilia, com preco de R$320,00 com ida 13/12/2020 18:40 e volta 24/12/2020 9:35
    
    Voo vooSaoPauloBrasilia2 = new Voo("Sao Paulo", "Brasilia", 369, 2020, 12, 21, 7, 35, 2020, 12, 31, 21, 50);//Voo saindo de Sao Paulo, destino a Brasilia, com preco de R$369,00 com ida 21/12/2020 7:35 e volta 31/12/2020 21:50
   
    Voo vooSaoPauloBrasilia3 = new Voo("Sao Paulo", "Brasilia", 383, 2020, 12, 30, 18, 40, 2021, 01, 12, 21, 00);//Voo saindo de Sao Paulo, destino a Brasilia, com preco de R$383,00 com ida 30/12/2020 18:40 e volta 12/01/2021 21:00
    

    Voo vooGoianiaRioDeJaneiro1 = new Voo("Goiania", "Rio de Janeiro", 700, 2021, 2, 20, 7, 30, 2021, 2, 24, 11, 00); //Voo saindo de Goiania, destino a Rio de Janeiro, com preco de R$700,00 com ida 20/02/2021 7:30 e volta 24/02/2021 11:00

    Voo vooGoianiaRioDeJaneiro2 = new Voo("Goiania", "Rio de Janeiro", 469, 2021, 3, 12, 15, 45, 2021, 4, 12, 6, 30);//Voo saindo de Goiania, destino a Rio de Janeiro, com preco de R$469,00 com ida 12/03/2021 15:45 e volta 04/12/2021 6:30

    Voo vooGoianiaRioDeJaneiro3 = new Voo("Goiania", "Rio de Janeiro", 564, 2021, 7, 30, 21, 00, 2021, 8, 24, 21, 00);//Voo saindo de Goiania, destino a Rio de Janeiro, com preco de R$564,00 com ida 30/07/2021 21:00 e volta 24/08/2021 21:00

    
    Voo vooSaoPauloGoiania1 = new Voo("Sao Paulo", "Goiania", 1703, 2020, 12, 12, 4, 00, 2021, 1, 2, 4, 00);//Voo saindo de Sao Paulo, destino a Goiania, com preco de R$1703,00 com ida 12/12/2020 4:00 e volta 2/01/2021 4:00

    Voo vooSaoPauloGoiania2 = new Voo("Sao Paulo", "Goiania", 926, 2020, 12, 29, 7, 10, 2021, 1, 21, 9, 15);//Voo saindo de Sao Paulo, destino a Goiania, com preco de R$926,00 com ida 29/12/2020 7:10 e volta 21/01/2021 9:15

    Voo vooSaoPauloGoiania3 = new Voo("Sao Paulo", "Goiania", 349, 2021, 6, 24, 5, 25, 2021, 8, 20, 14, 30);//Voo saindo de Sao Paulo, destino a Goiania, com preco de R$349,00 com ida 24/06/2021 5:25 e volta 20/08/2021 14:30 

    
    Voo vooSaoPauloRioDeJaneiro1 = new Voo("Sao Paulo", "Rio de Janeiro", 432, 2020, 12, 12, 5, 45, 2020, 12, 30, 16, 30);//Voo saindo de Sao Paulo, destino a Rio de Janeiro, com preco de R$432,00 com ida 12/12/2020 5:45 e volta 30/12/2020 16:30

    Voo vooSaoPauloRioDeJaneiro2 = new Voo("Sao Paulo", "Rio de Janeiro", 407, 2020, 12, 23, 8, 20, 2021, 2, 25, 19, 15);//Voo saindo de Sao Paulo, destino a Rio de Janeiro, com preco de R$407,00 com ida 21/12/2020 e volta 25/02/2021 19:15

    Voo vooSaoPauloRioDeJaneiro3 = new Voo("Sao Paulo", "Rio de Janeiro", 444, 2021, 4, 1, 4, 00, 2021, 4, 10, 4, 00);//Voo saindo de Sao Paulo, destino a Rio de Janeiro, com preco de R$444,00 com ida 01/04/2021 4:00 e volta 10/04/2021 4:00

   
    Voo vooGoianiaBrasilia1 = new Voo("Goiania", "Brasilia", 2410, 2020, 12, 14, 2, 35, 2021, 1, 3, 1, 45);//Voo saindo de Goiania, destino a Brasilia, com preco de R$2410,00 com ida 14/12/2020 2:35 e volta 03/01/2021 e volta 01:45

    Voo vooGoianiaBrasilia2 = new Voo("Goiania", "Brasilia", 1042, 2020, 12, 27, 15, 25, 2021, 3, 1, 11, 30);//Voo saindo de Goiania, destino a Brasilia, com preco de R$1042,00 com ida 27/12/2020 15:25 e volta 01/03/2021 11:30

    Voo vooGoianiaBrasilia3 = new Voo("Goiania", "Brasilia", 616, 2020, 12, 31, 23, 55, 2021, 1, 31, 23, 55);//Voo saindo de Goiania, destino a Brasilia, com preco de R$616,00 com ida 31/12/2020 e volta 31/01/2021 23:55


    Voo vooGoianiaNatal1 = new Voo("Goiania", "Natal", 1735, 2020, 12, 24, 23, 55, 2020, 12, 30, 16, 35);//Voo saindo de Goiania, destino a Natal, com preco de R$1735,00 com ida 24/12/2020 23:55 e volta 30/12/2020 16:35

    Voo vooGoianiaNatal2 = new Voo("Goiania", "Natal", 1652, 2020, 12, 30, 15, 45, 2021, 4, 25, 5, 10);//Voo saindo de Goiania, destino a Natal, com preco de R$1652,00 com ida 30/12/2020 21:00 e volta 25/04/2021 05:10

    Voo vooGoianiaNatal3 = new Voo("Goiania", "Natal", 2120, 2020, 12, 21, 21, 00, 2021, 1, 2, 12, 00);//Voo saindo de Goiania, destino a Natal, com preco de R$2120,00 com ida 21/12/2020 21:00 e volta 02/01/2021 12:00


    // Lista de voos disponiveis
    ArrayList<Voo> voos = new ArrayList<Voo>();

      voos.add(vooGoianiaSaoPaulo1);
    
      voos.add(vooGoianiaSaoPaulo2);
    
      voos.add(vooGoianiaSaoPaulo3);
      
    
      voos.add(vooSaoPauloBrasilia1); 
    
      voos.add(vooSaoPauloBrasilia2);
    
      voos.add(vooSaoPauloBrasilia3);
      
    
      voos.add(vooGoianiaRioDeJaneiro1);
      
      voos.add(vooGoianiaRioDeJaneiro2);

      voos.add(vooGoianiaRioDeJaneiro3);
      
    
      voos.add(vooSaoPauloGoiania1);

      voos.add(vooSaoPauloGoiania2);
      
      voos.add(vooSaoPauloGoiania3);

    
      voos.add(vooSaoPauloRioDeJaneiro1);

      voos.add(vooSaoPauloRioDeJaneiro2);
      
      voos.add(vooSaoPauloRioDeJaneiro3);

    
      voos.add(vooGoianiaBrasilia1);

      voos.add(vooGoianiaBrasilia2);
      
      voos.add(vooGoianiaBrasilia3);


      voos.add(vooGoianiaNatal1);

      voos.add(vooGoianiaNatal2);

      voos.add(vooGoianiaNatal3);

    // Lista de origens disponiveis
    ArrayList<String> origens = new ArrayList<String>();

    	for(int i=0; i<voos.size(); i++) {
    		if(origens.contains(voos.get(i).getOrigem()) == false) {
    			origens.add(voos.get(i).getOrigem());
    		}
    	}
    
    // Lista de destinos disponiveis
    ArrayList<String> destinos = new ArrayList<String>();

     	for(int i=0; i<voos.size(); i++) {
     		if(destinos.contains(voos.get(i).getDestino()) == false) {
     			destinos.add(voos.get(i).getDestino());
     		}
     	}     
    
    

    // Sistema de busca de voos
    ArrayList<Voo> voosPotenciais = new ArrayList<Voo>();
    
    String origem, destino;//Utilizados para permitir a visualizacao das origens e destinos disponiveis
    
    int flag = 0, indice;
    
    Voo vooMenu;//vooMenu eh utilizado para exibir os dados dos voos disponiveis para o cliente
    
    Voo voo = new Voo();//voo eh utilizado para armazenar o voo escolhido pelo cliente
    
    //Momento de selecao 
    //Mostra Lista com origens de voos
    System.out.printf("\n\n\nEscolha a origem do seu voo:\n");
      
      for(int i = 0; i<origens.size(); i++) {
    	  System.out.printf("%d. "+origens.get(i)+"\n", i+1);
    }
    
    System.out.printf("Selecione o indice da origem desejada: \n");

    int vooSelecionado = input.nextInt();
    if(vooSelecionado <= 0 || vooSelecionado > origens.size()){
      System.out.printf("\nIndice selecionado invalido, tente novamente.");
      System.exit(0);
    }
    
    origem = origens.get(vooSelecionado - 1);

    
      for(int i=0; i<3; i++) {
    	  System.out.printf("\n");
    }

    //A partir da selecao inicial mostra uma lista com possiveis destinos
    System.out.printf("Escolha o destino do seu voo:\n");
      
      for(int i = 0; i<destinos.size(); i++) {
    	  if(destinos.get(i).equals(origem) == false) {	
    		  System.out.printf("%d. "+destinos.get(i)+"\n", i+1);
    	}
    }
    
    System.out.printf("Selecione o indice do destino desejado: \n");

    vooSelecionado = input.nextInt();
    
    if(vooSelecionado <= 0 || vooSelecionado > destinos.size()) {
    	System.out.printf("\nIndice selecionado invalido, tente novamente.");
    	System.exit(0);
    }
    
    destino = destinos.get(vooSelecionado - 1);
    
    for(int i=0; i<3; i++) {
    	System.out.printf("\n");
    }
    
    //Lista de Voos com as especificacoes desejadas
    System.out.printf("Indice   Origem     Destino      preco     Partida       Volta\n");
    
    for(int i=0, j=1; i<voos.size(); i++) {
    	
      vooMenu = voos.get(i);
    	
      if(vooMenu.getOrigem().equals(origem) && vooMenu.getDestino().equals(destino) && vooMenu.getLocalDateTimePartida().isAfter(dataHoje)) {
    		
        System.out.printf("%d.       ", j);
    	
      	System.out.printf(vooMenu.getOrigem()+"    "+vooMenu.getDestino()+"    %.2f    "+vooMenu.getDataPartida()+"    "+vooMenu.getDataVolta()+"\n", vooMenu.getPreco());
    		
        voos.get(i).setIndice(j);
    	
      	voosPotenciais.add(vooMenu);
    	
      	j++;
    	
      	flag++;
    	}
    }
    
    //no caso de nenhum voo atender as especificacoes
    if(flag==0) {
      
      System.out.printf("Nao ha voos disponiveis que satisfacam os seus criterios.\n");
      
      System.exit(0);
    }
    else {
    	
      flag = 0;
    	
      System.out.printf("\nInsira o indice do voo desejado: \n");
    	
      indice = input.nextInt();
    	
      for(int i = 0; i<voosPotenciais.size(); i++) {
    		vooMenu = voosPotenciais.get(i);
    		
        if(indice == voosPotenciais.get(i).getIndice()) {
    			voo = voosPotenciais.get(i);
          System.out.printf("Voo selecionado!\n\n");
    			flag++;
    		}
    	}
    	if (flag == 0) {
    		System.out.printf("Indice invalido, tente novamente.");
        System.exit(0);
    	}

      
    }

    //Selecao do numero de adultos e criancas 
    System.out.printf("\n\n\nInsira o numero de adultos:\n");
    
    int adultos = input.nextInt();
    
    System.out.printf("Insira o numero de criancas:\n");
    
    int criancas = input.nextInt();
    
    if(adultos==0&&criancas==0)
    {
      System.out.println("Numero de passageiros invalido.");
      System.exit(0);
    }
    //Impede compra de 0 passagens
    else if(adultos+criancas>voo.getAssentosRestantes()){
      System.out.println("Nao ha assentos o suficiente disponiveis");
      System.exit(0);
    }
    //Verifica se o numero de passagens ultrapassa a quantidade de assentos disponiveis

    // Criacao do objeto compra que armazena as passagens que serao compradas
    Compra compra = new Compra();

  //Entrada das informacoes dos adultos
    for(int i=0; i<adultos; i++){
      System.out.println("\n\nNOME: ");
     
      
      input.nextLine();
      String nome = input.nextLine();
      
      String cpf;
      do{
        System.out.println("\nCPF: ");
        cpf = input.next();
        if(cpf.length()!=11){
          System.out.printf("\n O CPF deve possuir 11 digitos!!");
        }
      }while(cpf.length()!=11);//bloqueia entrada com menos de 11 digitos 
      
      Pessoa pessoa = new Adulto(nome,cpf);
      
      System.out.println("\nEscolha um assento: \n");
      
      voo.mostraAssentosDisponiveis();
      
      String assento = input.next();
      
      if(voo.getAssentos().contains(assento)){
    	  Passagem passagem = new Passagem(voo, pessoa, assento);
    	  compra.adicionaPassagem(passagem);
        //se o assento esta disponovel, cria a passagem.
      }
      else{
    	  System.out.println("O assento nao esta disponivel.");
        i--;
        
        System.out.println("Insira os dados novamente e escolha um assento diferente.");
        //se o assento nao esta disponivel, permite que tente novamente
      }
      
      
    }

    //Entrada das informacoes das criancas
    for(int i=0; i<criancas;i++){
      System.out.println("\n\nNOME: ");
      
  
      input.nextLine();
      String nome = input.nextLine();
      
      System.out.println("\nIDADE: ");
      
      int idade = input.nextInt();
      
      System.out.println("\nMATRICULA DA CERTIDAO DE NASCIMENTO: ");
      
      String matricula = input.next();
      
      Pessoa p = new Crianca(nome,idade,matricula);
      
      System.out.println("\nEscolha um assento: ");
      
      voo.mostraAssentosDisponiveis();
      
      String assento = input.next();
      
      if(voo.getAssentos().contains(assento)){
        Passagem passagem = new PassagemDeCrianca(voo, p, assento);
        compra.adicionaPassagem(passagem);
      }
      else{
        System.out.println("O assento nao esta disponivel.");
        i--;
        System.out.println("Insira os dados novamente e escolha um assento diferente.");
      }
    }


    //Entrada das informacoes do cartao a ser utilizado pelo cliente
    System.out.printf("\n\n\nInsira o numero correspondente ao tipo de cartao:\n (1.Credito)  (2.Debito)\n "); 
    int tipo = input.nextInt();
    
    if(tipo==1) {
      String numeroDoCartao,codigoDeSeguranca;
    	int anoDeVencimento,mesDeVencimento;

    	do{
	    	System.out.printf("\nDigite o numero de seu cartao de credito:\n");
	    	numeroDoCartao = input.next();
	    	if(numeroDoCartao.length()!=16){
	    	System.out.printf(" O número deve possuir 16 caracteres!");
	    	}
    	}while(numeroDoCartao.length()!=16);


    	do{      
        	System.out.printf("\nDigite o ano de vencimento de seu cartao de credito:\n");
          anoDeVencimento = input.nextInt();
	    	  if(anoDeVencimento>2200||anoDeVencimento<1968){
	    		System.out.printf(" Ano invalido!");
	        	}
    	}while(anoDeVencimento>2200||anoDeVencimento<1968);
	
	    do{      
    		System.out.printf("\nDigite o mes de vencimento de seu cartao de credito:\n");
    		mesDeVencimento = input.nextInt();
	    	if(mesDeVencimento<1||mesDeVencimento>12){
		  	System.out.printf(" Mes invalido!");
	    	}
    	}while(mesDeVencimento<1||mesDeVencimento>12);

    	do{
	    	System.out.printf("\nDigite o codigo de seguranca do seu cartao de credito:\n");
	    	codigoDeSeguranca = input.next();
	    	if(codigoDeSeguranca.length()!=3){
	    	System.out.printf(" O codigo deve possuir 3 caracteres!");
	    	}
	    }while(codigoDeSeguranca.length()!=3);
      
	
    	CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(numeroDoCartao, anoDeVencimento , mesDeVencimento , codigoDeSeguranca);
      
      cartaoDeCredito.Pagar(compra.precoTotal());
      
    }
    
    if(tipo==2){
	    String numeroDoCartao,codigoDeSeguranca;
    	int anoDeVencimento,mesDeVencimento;

    	do{
	    	System.out.printf("\nDigite o numero de seu cartao de debito:\n");
	    	numeroDoCartao = input.next();
	    	if(numeroDoCartao.length()!=16){
	    	System.out.printf(" O numero deve possuir 16 caracteres!");
	    	}
    	}while(numeroDoCartao.length()!=16);


    	do{      
        	System.out.printf("\nDigite o ano de vencimento de seu cartao de debito:\n");
          anoDeVencimento = input.nextInt();
	    	  if(anoDeVencimento>2200||anoDeVencimento<1968){
	    		System.out.printf(" Ano invalido!");
	        	}
    	}while(anoDeVencimento>2200||anoDeVencimento<1968);
	
	    do{      
    		System.out.printf("\nDigite o mes de vencimento de seu cartao de debito:\n");
    		mesDeVencimento = input.nextInt();
	    	if(mesDeVencimento<1||mesDeVencimento>12){
		  	System.out.printf(" Mes invalido!");
	    	}
    	}while(mesDeVencimento<1||mesDeVencimento>12);

    	do{
	    	System.out.printf("\nDigite o codigo de seguranca do seu cartao de debito:\n");
	    	codigoDeSeguranca = input.next();
	    	if(codigoDeSeguranca.length()!=3){
	    	System.out.printf(" O codigo deve possuir 3 caracteres!");
	    	}
	    }while(codigoDeSeguranca.length()!=3);
      
	
    	CartaoDeDebito cartaoDeDebito = new CartaoDeDebito(numeroDoCartao, anoDeVencimento , mesDeVencimento , codigoDeSeguranca, 5000);
      
      cartaoDeDebito.Pagar(compra.precoTotal());
    }
    
    if(tipo != 1 && tipo != 2) {
    	System.out.printf("Tipo de cartao invalido.");
    	
      System.exit(0);
    }

    //Impressao das informacoes da compra feita pelo cliente
    compra.imprimeCompra();

    System.out.println("\n");

    //Impressao dos bilhetes de passagem area
    compra.imprimePassagens();
    
 



  }      
}
