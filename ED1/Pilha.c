/******************************************************************************
//     pilhaDinamica.c
// Este programa gerencia pilhas (implementacao dinamica).
// As pilhas gerenciadas podem ter um numero arbitrario de elementos.
// Não usaremos sentinela ou cabeça nesta estrutura.
******************************************************************************/
#include <stdio.h>
#include <malloc.h>
#define true 1
#define false 0

typedef int bool;

typedef int TIPOCHAVE;

typedef struct {
  TIPOCHAVE chave;
  // outros campos...
} REGISTRO;

typedef struct aux {
  REGISTRO reg;
  struct aux* prox;
} ELEMENTO;

typedef ELEMENTO* PONT;

// o ponteiro topo aponta para o topo da pilha (será NULL caso a pilha esteja vazia)
typedef struct {
  PONT topo;
} PILHA;

/* Inicialização da pilha ligada (a pilha jah esta criada e eh apontada 
pelo endereco em p) */
void inicializarPilha(PILHA* p){
  p->topo = NULL;
} /* inicializarPILHA* /

/* Exibição da pilha seqüencial */
void exibirPilha(PILHA* p){
  PONT end = p->topo;
  printf("Pilha: \" ");
  while (end != NULL){
    printf("%i ", end->reg.chave); // soh lembrando TIPOCHAVE = int
    end = end->prox;
  }
  printf("\"\n");
} /* exibirPILHA*/ 


void exibirPilha2(PILHA p){
  PONT end = p.topo;
  printf("Pilha: \" ");
  while (end != NULL){
    printf("%i ", end->reg.chave); // soh lembrando TIPOCHAVE = int
    end = end->prox;
  }
  printf("\"\n");
}

/* Retornar o tamanho da pilha (numero de elementos) */
int tamanho(PILHA* p) {
  PONT end = p->topo;
  int tam = 0;
  while (end != NULL){
    tam++;
    end = end->prox;
  }
  return tam;
} /* tamanho */

int tamanho2(PILHA p) {
  PONT end = p.topo;
  int tam = 0;
  while (end != NULL){
    tam++;
    end = end->prox;
  }
  return tam;
}

bool estaVazia(PILHA* p) {
  if (p->topo == NULL) return true;
  return false;
}

/* Retornar o tamanho em bytes da pilha. Neste caso, isto depende do numero
   de elementos que estao sendo usados.   */
int tamanhoEmBytes(PILHA* p) {
  return(tamanho(p)*sizeof(ELEMENTO))+sizeof(PILHA); // sizeof(PILHA) = sizeof(PONT) pois a "PILHA" eh um ponteiro para o 1o elemento
} /* tamanhoEmBytes */

/* Exclusão do elemento do topo da pilha e copia deste elemento para o
   endereço apontado por reg */
bool excluirElemPilha(PILHA* p, REGISTRO* reg){
  if ( p->topo == NULL) return false;
  *reg = p->topo->reg;
  PONT apagar = p->topo;
  p->topo = p->topo->prox;
  free(apagar);
  return true;
} /* excluirElemPILHA* /

/* Exclui (e libera a memoria) de todos os elementos da PILHA */
void reinicializarPilha(PILHA* p){
  PONT apagar;
  PONT posicao = p->topo;
  while (posicao != NULL){
        apagar = posicao;
        posicao = posicao->prox;
        free(apagar);
  }
  p->topo = NULL;
} /* excluirElemPILHA* /


/* Inserção em pilha (sempre no topo)
   Notem que o método é bool mas sempre retornará true */
bool inserirElemPilha(PILHA* p, REGISTRO reg) {
  PONT novo = (PONT) malloc(sizeof(ELEMENTO));
  novo->reg = reg;
  novo->prox = p->topo;
  p->topo = novo;
  return true;
} /* inserirElemPILHA* /

/* retornarTopo - retorna o endereco do elemento do topo da pilha e (caso
   a pilha nao esteja vazia) retorna a chave desse elemento na memoria 
   apontada pelo ponteiro ch */
PONT retornarTopo(PILHA* p, TIPOCHAVE *ch){
  if (p->topo != NULL) *ch = p->topo->reg.chave;
  return p->topo;
} /* retornarTopo */

/* excluirElementoPilha2 - versao alternativa da funcao excluir, que retorna
NULL caso a pilha esteja vazia; caso contrario aloca memoria e copia o 
registro do 1o elemento da pilha, exclui este elemento e retorna o endereco do
registro alocado. */
REGISTRO* excluirElementoPilha2(PILHA* p){
  if (p->topo == NULL) return NULL;
  REGISTRO* res = (REGISTRO*) malloc(sizeof(REGISTRO));
  *res = p->topo->reg;
  PONT segundo = p->topo->prox;
  free(p->topo);
  p->topo = segundo;
  return res;
} /* excluirElementoPILHA2*/

/* buscaSequencial - realiza uma busca sequencial na pilha (a partir do topo) 
   e retorna o endereco do elemento buscado, se encontrar, ou NULL caso 
   contrário */
PONT buscaSequencial(PILHA* p, TIPOCHAVE ch) {
  PONT end = p->topo;
  while (end != NULL){
    if (end->reg.chave == ch) return end;
    end = end->prox;
  }
  return NULL;
} /* buscaSequencial */


void inserir(PILHA *l){
  TIPOCHAVE ch;
  scanf("%i",&ch);
  REGISTRO reg;
  reg.chave = ch;
  if (inserirElemPilha(l,reg)) printf("Elemento %i inserido corretamente.\n",ch);
  else printf("Nao foi possivel inserir elemento %i.\n",ch);
}

void exibirTopo(PILHA *l){
  TIPOCHAVE ch;
  PONT posicao = retornarTopo(l,&ch);
  if (posicao != NULL) printf("Elemento %i encontrado no endereco %p.\n",ch,posicao);
  else printf("Nao foi possivel encontrar nenhum elemento (pilha vazia).\n");
}


void excluir(PILHA *l){
  REGISTRO temp;
  if (excluirElemPilha(l, &temp)) printf("Elemento %i excluido corretamente.\n",temp.chave);
  else printf("Nao foi possivel excluir elemento (pilha vazia).\n");
}

void exibir(PILHA *l){
  exibirPilha(l);
}

void meuLog(PILHA *l){
  printf("Numero de elementos na pilha: %i.\n",tamanho(l));
  printf("Tamanho da pilha (em bytes): %i.\n",tamanhoEmBytes(l));
}

void help(){
  printf("Comandos validos: \n");
  printf("   i <chave1>: inserir elemento com chave=chave1\n");
  printf("   e : excluir topo da pilha\n");
  printf("   p : imprimir pilha\n");
  printf("   d : destruir (zerar) pilha\n");
  printf("   l : exibir log de utilizacao da pilha\n");
  printf("   h : exibir esta mensagem de ajuda\n");
  printf("   0 : exibir a chave e o endereco do primeiro elemento\n");
  printf("   q : sair\n");
}

void destruir(PILHA *l){
     reinicializarPilha(l);
     printf("Pilha zerada.\n");
}

int main(){
  PILHA pilha;
  inicializarPilha(&pilha);
  help();
  char comando = ' ';
  scanf("%c",&comando);
  while (comando != 'q'){
    switch (comando) {
      case 'i' : inserir(&pilha); break;
      case 'e' : excluir(&pilha); break;
      case 'p' : exibir(&pilha); break;
      case 'd' : destruir(&pilha); break;
      case 'l' : meuLog(&pilha); break;
      case 'h' : help(); break;
      case '0' : exibirTopo(&pilha); break;

      default: {while (comando != '\n') scanf("%c",&comando);};
    } 
    scanf("%c",&comando);
  }

  return 0;
}
