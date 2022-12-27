#include <stdio.h>

char casa[9] = {'1','2','3','4','5','6','7','8','9'};

void getInput(int jogador){
	int input = 0;
	printf("Jogador %d\n", jogador);
	printf("Insira em qual casa voce deseja jogar:\n");

	do{
		scanf("%d", &input);
		if(casa[input-1] == 'X' || casa[input-1] == 'O'){
			printf("Casa ja ocupada.\n");
		}
	}while(input == 0 || casa[input-1] == 'X' || casa[input-1] == 'O');
	
	if(jogador == 1) casa[input-1] = 'X';
	
	if(jogador == 2) casa[input-1] = 'O';
}

void tabuleiro(){
	system("cls");
    printf("\n\n\tJogo da Velha\n\n");

    printf("Jogador 1 (X)  -  Jogador 2 (O)\n\n\n");


    printf("     |     |     \n");
    printf("  %c  |  %c  |  %c \n", casa[0], casa[1], casa[2]);

    printf("_____|_____|_____\n");
    printf("     |     |     \n");

    printf("  %c  |  %c  |  %c \n", casa[3], casa[4], casa[5]);

    printf("_____|_____|_____\n");
    printf("     |     |     \n");

    printf("  %c  |  %c  |  %c \n", casa[6], casa[7], casa[8]);

    printf("     |     |     \n\n");
    
}

int determinaVitoria(){
	int i;
	int ganhador = 0;
	
	//Linhas
	for(i=0; i<3; i++){
		if(casa[i*3] == casa[(i*3)+1] && casa[(i*3)+1] == casa[(i*3)+2]){
			if(casa[i] == 'X') ganhador = 1;
			if(casa[i] == 'O') ganhador = 2;
		}
	}
	
	//Colunas
	for(i=0; i<3; i++){
		if(casa[i] == casa[i+3] && casa[i+3] == casa[i+6]){
			if(casa[i] == 'X') ganhador = 1;
			if(casa[i] == 'O') ganhador = 2;
		}
	}
	
	//Diagonais
	if(casa[0] == casa[4] && casa[4] == casa[8]){
		if(casa[0] == 'X') ganhador = 1;
		if(casa[0] == 'O') ganhador = 2;
	}
	if(casa[6] == casa[4] && casa[4] == casa[2]){
		if(casa[6] == 'X') ganhador = 1;
		if(casa[6] == 'O') ganhador = 2;
	}
	
	return ganhador;
}

int main(){
	int turno = 0;
	
	do{
		tabuleiro();
		getInput((turno%2)+1);
		turno++;
	}while(determinaVitoria() == 0 && turno<9);
	tabuleiro();
	printf("\nJogo encerrado!\n");
	if(determinaVitoria() == 0){
		printf("Empate.");
	}
	else{
	printf("Vitoria do jogador %d!", determinaVitoria());
	}
	return 0;
}
