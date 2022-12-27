#include <stdio.h>
#include <stdlib.h>
#define true 1
#define false 0

typedef int bool;
typedef int TIPOCHAVE;

typedef struct aux{
	TIPOCHAVE chave;
	//outros registros
	struct aux *esq;
	struct aux *dir;
	int h;
} NO;

typedef NO* PONT;

PONT criaNo(TIPOCHAVE ch){
	PONT novoNo = (PONT)malloc(sizeof(NO));
	novoNo->esq = NULL;
	novoNo->dir = NULL;
	novoNo->chave = ch;
	novoNo->h = 0;
	return(novoNo);
}

PONT inicializa(){
	return(NULL);
}


int max(int a, int b){
	if(a>b) return a;
	return b;
}

PONT direita(PONT r){
	PONT aux;
	aux = r->esq;
	r->esq = aux->dir;
	aux->dir = r;
	
	r->h = max(altura(r->dir), altura(r->esq))+1;
	aux->h = max(altura(aux->esq), r->h)+1;
	
	return(aux);
}

PONT esquerda(PONT r){
	PONT aux;
	aux = r->dir;
	r->dir = aux->esq;
	aux->esq = r;
	
	r->h = max(altura(r->dir), altura(r->esq))+1;
	aux->h = max(altura(aux->dir), r->h)+1;
	
	return(aux);
}


PONT esquerdaDireita(PONT r){
	r->esq = esquerda(r->esq);
	return(direita(r));
}

PONT direitaEsquerda(PONT r){
	r->dir = direita(r->dir);
	return(esquerda(r));
}

int altura(PONT raiz){
	if(!raiz) return(-1);
	return(raiz->h);
}

PONT insere(PONT raiz, TIPOCHAVE ch){
	if(!raiz) ;printf("elemento inserido\n"); return(criaNo(ch));    //Se a raiz eh nula, um noh novo sera criado
	if(ch < raiz->chave){             //Testa os valores para verificar se a chave ira para a esquerda
		raiz->esq = insere(raiz->esq, ch); //Volta para o inicio do programa, ateh que seja alcancado o fim da arvore, onde o elemento sera inserido
		if((altura(raiz->esq) - altura(raiz->dir)) == 2){ //Testa para verificar se ha desbalanceamento, se a equacao igual a 2, ha desbalanceamento
			if(ch < raiz->esq->chave) raiz = direita(raiz);  //Se o elemento foi inserido a esquerda de seu pai, rotaciona para a direita
			
			else raiz = esquerdaDireita(raiz); //Se o elemento foi inserido para a direita de seu pai, rotaciona para a esquerda e direita
		}
	}
	else{                                                              //Para o caso onde o elemento ira para a DIREITA da raiz
		if (ch > raiz->chave){                                         //Testa para verificar se a chave ira para a direita
			raiz->dir = insere(raiz->dir, ch);                         //Se o elemento eh maior que o nodulo, coloca ele na direita
			if((altura(raiz->dir) - altura(raiz->esq)) == 2){          //Se a equacao igual a 2, ha desbalanceamento
				if(ch > raiz->dir->chave) raiz = esquerda(raiz);       //Se o elemento foi inserido a direita de seu pai, rotaciona para a esquerda
				
				else raiz = direitaEsquerda(raiz);                     //Se o elemento foi inserido a esquerda de seu pai, rotaciona para a direita e para a esquerda
			}
		}
	}
	
	raiz->h = max(altura(raiz->esq), altura(raiz->dir)) + 1;
	return(raiz);
}


PONT busca(PONT raiz, TIPOCHAVE ch){
	if(!raiz){
		return NULL;
	}
	if(ch == raiz->chave){
		return raiz;
	}
	if(ch < raiz->chave){
		return(busca(raiz->esq, ch));
	}
	return(busca(raiz->dir, ch));
}

void exibirArvore(PONT raiz){   //ordem: raiz-esquerda-direita
	if(raiz != NULL){
		printf("%i", raiz->chave);
		printf("(");
		exibirArvore(raiz->esq);
		exibirArvore(raiz->dir);
		printf(")");
	}
}

int numeroNos(PONT raiz){
	if(!raiz) return 0;
	return(numeroNos(raiz->esq) + 1 + numeroNos(raiz->dir));
}


int main(){
	PONT r = inicializa();
	PONT n = r;
	
	int i=0;
	
	for(i=0;i<=20; i++){  //tentando inserir 20 elementos.
		n = insere(r, i);
	}
	
	printf("%d\n%d\n", numeroNos(n), numeroNos(r));
	exibirArvore(n);
	exibirArvore(r);
	
	
	
	return 0;
}
