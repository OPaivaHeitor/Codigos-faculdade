/******************************************************************************
//     filaDinamica.c
// Este programa gerencia filas lineares ligadas (implementacao dinamica).
// As filas gerenciadas podem ter um numero arbitrario de elementos.
// Não usaremos sentinela ou cabeça nesta estrutura.
******************************************************************************/
#include <stdio.h>
#include <malloc.h>
#define ERRO -1
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
} ELEMENTO, *PONT;;

typedef struct {
  PONT inicio;
  PONT fim;
} FILA;

/* Inicialização da fila ligada (a fila jah esta criada e eh apontada 
pelo endereco em f) */
void inicializarFila(FILA* f){
  f->inicio = NULL;
  f->fim = NULL;
} /* inicializarFila */

/* Retornar o tamanho da fila (numero de elementos) */
int tamanho(FILA* f) {
  PONT end = f->inicio;
  int tam = 0;
  while (end != NULL){
    tam++;
    end = end->prox;
  }
  return tam;
} /* tamanho */

/* Retornar o tamanho em bytes da fila. Neste caso, isto depende do numero
   de elementos que estao sendo usados.   */
int tamanhoEmBytes(FILA* f) {
  return (tamanho(f)*sizeof(ELEMENTO)) + sizeof(FILA);
} /* tamanhoEmBytes */

/* Destruição da fila 
   libera a memoria de todos os elementos da fila*/
void destruirFila(FILA* f) {
  PONT end = f->inicio;
  while (end != NULL){
    PONT apagar = end;
    end = end->prox;
    free(apagar);
  }
  f->inicio = NULL;
  f->fim = NULL;
} /* destruirFila */


/* retornarPrimeiro - retorna o endereco do primeiro elemento da fila e (caso
   a fila nao esteja vazia) retorna a chave desse elemento na memoria 
   apontada pelo ponteiro ch */
PONT retornarPrimeiro(FILA* f, TIPOCHAVE *ch){
  if (f->inicio != NULL) *ch = f->inicio->reg.chave;
  return f->inicio;
} /* retornarPrimeiro */

/* retornarUltimo - retorna o endereco do ultimo elemento da fila e (caso
   a fila nao esteja vazia) retorna a chave desse elemento na memoria 
   apontada pelo ponteiro ch */
PONT retornarUltimo(FILA* f, TIPOCHAVE* ch){
  if (f->inicio == NULL) return NULL;
  *ch = f->fim->reg.chave;
  return f->fim;
} /* retornarUltimo */


/* Inserção no fim da fila */
bool inserirNaFila(FILA* f,REGISTRO reg) {
  PONT novo = (PONT) malloc(sizeof(ELEMENTO));
  novo->reg = reg;
  novo->prox = NULL;
  if (f->inicio==NULL){
     f->inicio = novo;
  }else{
     f->fim->prox = novo;
  }
  f->fim = novo;
  return true;
} /* inserir */

/* Excluir  */
bool excluirDaFila(FILA* f, REGISTRO* reg) {
  if (f->inicio==NULL){
    return false;                     
  }
  *reg = f->inicio->reg;
  PONT apagar = f->inicio;
  f->inicio = f->inicio->prox;
  free(apagar);
  if (f->inicio == NULL){
    f->fim = NULL;
  }
  return true;
} /* excluirDaFila */


/* Exibição da fila sequencial */
void exibirFila(FILA* f){
  PONT end = f->inicio;
  printf("Fila: \" ");
  while (end != NULL){
    printf("%d ", end->reg.chave); // soh lembrando TIPOCHAVE = int
    end = end->prox;
  }
  printf("\"\n");
} /* exibirFila */ 

/* Busca sequencial */
PONT buscaSeq(FILA* f,TIPOCHAVE ch){
  PONT pos = f->inicio;
  while (pos != NULL){
    if (pos->reg.chave == ch) return pos;
    pos = pos->prox;
  }
  return NULL;
} /* buscaSeq */

/* Busca sequencial com sentinela alocado dinamicamente */
PONT buscaSeqSent1(FILA* f,TIPOCHAVE ch){
  if (!f->inicio) return NULL;
  PONT sentinela = malloc(sizeof(ELEMENTO));
  sentinela->reg.chave = ch;
  f->fim->prox = sentinela;
  PONT pos = f->inicio;
  while (pos->reg.chave != ch) pos = pos->prox;
  free(sentinela);
  f->fim->prox = NULL;
  if (pos!=sentinela) return pos;
  return NULL;
} /* buscaSeqSent1 */

/* Busca sequencial com sentinela como variavel local */
PONT buscaSeqSent2(FILA* f,TIPOCHAVE ch){
  if (!f->inicio) return NULL;
  ELEMENTO sentinela;
  sentinela.reg.chave = ch;
  f->fim->prox = &sentinela;
  PONT pos = f->inicio;
  while (pos->reg.chave != ch) pos = pos->prox;
  f->fim->prox = NULL;
  if (pos!=&sentinela) return pos;
  return NULL;
} /* buscaSeqSent1 */


void inserir(FILA* f){
  TIPOCHAVE ch;
  scanf("%i",&ch);
  REGISTRO reg;
  reg.chave = ch;
  if (inserirNaFila(f,reg)) printf("Elemento %i inserido corretamente.\n",ch);
  else printf("Nao foi possivel inserir elemento %i.\n",ch);
}

void buscar(FILA* f){
  TIPOCHAVE ch;
  scanf("%i",&ch);
  PONT posicao = buscaSeq(f,ch);
  if (posicao != NULL) printf("Elemento %i encontrado no endereco %p (busca sequencial).\n",ch,posicao);
  else printf("Nao foi possivel encontrar elemento %i.\n",ch);
  posicao = buscaSeqSent1(f,ch);
  if (posicao != NULL) printf("Elemento %i encontrado no endereco %p (busca sequencial sentinela 1).\n",ch,posicao);
  else printf("Nao foi possivel encontrar elemento %i.\n",ch);
  posicao = buscaSeqSent2(f,ch);
  if (posicao != NULL) printf("Elemento %i encontrado no endereco %p (busca sequencial sentinela 2).\n",ch,posicao);
  else printf("Nao foi possivel encontrar elemento %i.\n",ch);
}

void exibirPrimeiro(FILA* f){
  TIPOCHAVE ch;
  PONT posicao = retornarPrimeiro(f,&ch);
  if (posicao != NULL) printf("Primeiro elemento %i encontrado no endereco %p.\n",ch,posicao);
  else printf("Nao foi possivel encontrar o primeiro elemento (fila vazia).\n");
}

void exibirUltimo(FILA* f){
  TIPOCHAVE ch;
  PONT posicao = retornarUltimo(f,&ch);
  if (posicao != NULL) printf("Ultimo elemento %i encontrado no endereco %p.\n",ch,posicao);
  else printf("Nao foi possivel encontrar o ultimo elemento (fila vazia).\n");
}

void excluir(FILA* f){
  TIPOCHAVE ch;
  REGISTRO excluido;
  if (excluirDaFila(f,&excluido)) printf("Elemento %i excluido corretamente.\n",excluido.chave);
  else printf("Nao foi possivel excluir elemento (fila vazio).\n");
}

void exibir(FILA* f){
  exibirFila(f);
}

void meuLog(FILA* f){
  printf("Numero de elementos na fila: %i.\n",tamanho(f));
  printf("Tamanho da fila (em bytes): %i.\n",tamanhoEmBytes(f));
}

void help(){
  printf("Comandos validos: \n");
  printf("   i <chave1>: inserir elemento com chave=chave1 no final da fila\n");
  printf("   e : exclui primeiro elemento da fila\n");
  printf("   p : imprimir fila\n");
  printf("   d : destruir (zerar) fila\n");
  printf("   l : exibir log de utilizacao da fila\n");
  printf("   h : exibir esta mensagem de ajuda\n");
  printf("   b <chave1>: exibir posicao do elemento com chave=chave1\n");
  printf("   0 : exibir a chave e o endereco do primeiro elemento\n");
  printf("   u : exibir a chave e o endereco do ultimo elemento\n");
  printf("   q : sair (quit)\n");
}

void destruir(FILA* f){
     destruirFila(f);
     printf("Fila zerada.\n");
}

int main(){
  FILA fila;
  inicializarFila(&fila);
  help();
  char comando = ' ';
  scanf("%c",&comando);
  while (comando != 'q'){
    switch (comando) {
      case 'i' : inserir(&fila); break;
      case 'e' : excluir(&fila); break;
      case 'p' : exibir(&fila); break;
      case 'd' : destruir(&fila); break;
      case 'l' : meuLog(&fila); break;
      case 'h' : help(); break;
      case 'b' : buscar(&fila); break;
      case '0' : exibirPrimeiro(&fila); break;
      case 'u' : exibirUltimo(&fila); break;

      default: {while (comando != '\n') scanf("%c",&comando);};
    } 
    scanf("%c",&comando);
  }

  return 0;
}



