/******************************************************************************
     dequeDinamico.c
  Este programa gerencia deques (filas com duas pontas)- implementacao dinamica.
  Os deques gerenciados podem ter um numero arbitrario de elementos.
  Nesta implementacao utilizaremos um no cabeca.
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


typedef struct auxElem {
  REGISTRO reg;
  struct auxElem* ant;
  struct auxElem* prox;
} ELEMENTO;

typedef ELEMENTO* PONT;

typedef struct {
  PONT cabeca;
} DEQUE;

/* Inicialização do deque (o deque jah esta criado e eh apontado 
pelo endereco em d) */
void inicializarDeque(DEQUE* d){
  d->cabeca = (PONT) malloc(sizeof(ELEMENTO));
  d->cabeca->prox = d->cabeca;
  d->cabeca->ant = d->cabeca;
} /* inicializarDeque */

/* Exibição do DEQUE a partir do inicio1 */
void exibirDequeInicio(DEQUE* d){
  PONT end = d->cabeca->prox;
  printf("Deque partindo do início: \" ");
  while (end != d->cabeca){
    printf("%i ", end->reg.chave); // soh lembrando TIPOCHAVE = int
    end = end->prox;
  }
  printf("\"\n");
} /* exibirDequeInicio */ 

/* Exibição do DEQUE a partir do inicio2 */
void exibirDequeFim(DEQUE* d){
  PONT end = d->cabeca->ant;
  printf("Deque partindo do fim: \" ");
  while (end != d->cabeca){
    printf("%i ", end->reg.chave); // soh lembrando TIPOCHAVE = int
    end = end->ant;
  }
  printf("\"\n");
} /* exibirDequeFim */ 

/* Retornar o tamanho do deque (numero de elementos) */
int tamanho(DEQUE* d) {
  PONT end = d->cabeca->prox;
  int tam = 0;
 while (end != d->cabeca){
    tam++;
    end = end->prox;
  }
  return tam;
} /* tamanho */

int tamanho2(DEQUE* d) {
  PONT end = d->cabeca->ant;
  int tam = 0;
 while (end != d->cabeca){
    tam++;
    end = end->ant;
  }
  return tam;
}

/* Retornar o tamanho em bytes da lista. Neste caso, isto depende do numero
   de elementos que estao sendo usados.   */
int tamanhoEmBytes(DEQUE* d) {
  return((tamanho(d)+1)*sizeof(ELEMENTO))+sizeof(DEQUE);
} /* tamanhoEmBytes */

/* Busca sequencial */
PONT buscaSeq(DEQUE* d, TIPOCHAVE ch){
  PONT pos = d->cabeca->prox;
  d->cabeca->reg.chave = ch;
  while (pos->reg.chave != ch) pos = pos->prox;
  if (pos != d->cabeca) return pos;
  return NULL;
} /* buscaSeq */

/* Exclusão do primeiro elemento, entrada 1 do deque 
   e colocar o valor da chave do elemento memoria apontada por ch*/
bool excluirElemDequeInicio(DEQUE* d, REGISTRO* reg){
  if (d->cabeca->prox == d->cabeca) return false;  // deque vazio
  PONT apagar = d->cabeca->prox;
  *reg = apagar->reg;
  d->cabeca->prox = apagar->prox;
  apagar->prox->ant = d->cabeca;
  free(apagar);
  return true;
} /* excluirElemDequeInicio */

/* Exclusão do primeiro elemento, entrada 2 do deque
   e colocar o valor da chave do elemento memoria apontada por ch*/
bool excluirElemDequeFim(DEQUE* d, REGISTRO* reg){
  if (d->cabeca->prox == d->cabeca) return false;  // deque vazio
  PONT apagar = d->cabeca->ant;
  *reg = apagar->reg;
  d->cabeca->ant = apagar->ant;
  apagar->ant->prox = d->cabeca;
  free(apagar);
  return true;
} /* excluirElemDequeFim */

/* Reinicialização/Destruição do deque
   libera a memoria de todos os elementos do deque*/
void reinicializarDeque(DEQUE* d) {
  PONT end = d->cabeca->prox;
  while (end != d->cabeca){
    PONT apagar = end;
    end = end->prox;
    free(apagar);
  }
  d->cabeca->prox = d->cabeca;
  d->cabeca->ant = d->cabeca;
} /* reinicializarDeque */

/* Inserção no deque, entrada 1 */
bool inserirDequeInicio(DEQUE* d,REGISTRO reg) {
  PONT i = (PONT) malloc(sizeof(ELEMENTO));
  i->reg = reg;
  i->ant = d->cabeca;
  i->prox = d->cabeca->prox;
  d->cabeca->prox = i;
  i->prox->ant = i;
  return true;
} /* inserirDequeInicio */

/* Inserção no deque, entrada 2 */
bool inserirDequeFim(DEQUE* d,REGISTRO reg) {
  PONT i = (PONT) malloc(sizeof(ELEMENTO));
  i->reg = reg;
  i->prox = d->cabeca;
  i->ant = d->cabeca->ant;
  d->cabeca->ant = i;
  i->ant->prox = i;
  return true;
} /* inserirDequeFim */

/* retornarPrimeiro1 - retorna o endereco do primeiro elemento do deque 1 */
PONT retornarPrimeiro1(DEQUE* d, TIPOCHAVE* ch){
  if (d->cabeca->prox != d->cabeca) *ch = d->cabeca->prox->reg.chave;
  else return NULL;
  return d->cabeca->prox;
} /* retornarPrimeiro1 */

/* retornarPrimeiro2 - retorna o endereco do primeiro elemento do deque 2*/
PONT retornarPrimeiro2(DEQUE* d, TIPOCHAVE* ch){
  if (d->cabeca->ant != d->cabeca) *ch = d->cabeca->ant->reg.chave;
  else return NULL;
  return d->cabeca->ant;
} /* retornarPrimeiro2 */


void inserir1(DEQUE* d){
  TIPOCHAVE ch;
  scanf("%i",&ch);
  REGISTRO reg;
  reg.chave = ch;
  if (inserirDequeInicio(d,reg)) printf("Elemento %i inserido corretamente na entrada 1.\n",ch);
  else printf("Nao foi possivel inserir elemento %i.\n",ch);
}

void inserir2(DEQUE* d){
  TIPOCHAVE ch;
  scanf("%i",&ch);
  REGISTRO reg;
  reg.chave = ch;
  if (inserirDequeFim(d,reg)) printf("Elemento %i inserido corretamente na entrada 2.\n",ch);
  else printf("Nao foi possivel inserir elemento %i.\n",ch);
}

void buscar(DEQUE* d){
  TIPOCHAVE ch;
  scanf("%i",&ch);
  PONT posicao = buscaSeq(d,ch);
  if (posicao != NULL) printf("Elemento %i encontrado no endereco %p.\n",ch,posicao);
  else printf("Nao foi possivel encontrar elemento %i.\n",ch);
}

void exibirPrimeiro1(DEQUE* d){
  TIPOCHAVE ch;
  PONT posicao = retornarPrimeiro1(d,&ch);
  if (posicao != NULL) printf("Primeiro elemento entrada 1: %i encontrado no endereco %p.\n",ch,posicao);
  else printf("Nao foi possivel encontrar o primeiro elemento (deque vazio).\n");
}

void exibirPrimeiro2(DEQUE* d){
  TIPOCHAVE ch;
  PONT posicao = retornarPrimeiro2(d,&ch);
  if (posicao != NULL) printf("Primeiro elemento entrada 2: %i encontrado no endereco %p.\n",ch,posicao);
  else printf("Nao foi possivel encontrar o primeiro elemento (deque vazio).\n");
}

void excluir1(DEQUE* d){
  REGISTRO ch;
  if (excluirElemDequeInicio(d,&ch)) printf("Elemento %i excluido corretamente da entrada 1.\n",ch.chave);
  else printf("Nao foi possivel excluir elemento entrada 1 - deque vazio.\n");
}

void excluir2(DEQUE* d){
  REGISTRO ch;
  if (excluirElemDequeFim(d, &ch)) printf("Elemento %i excluido corretamente da entrada 2.\n",ch.chave);
  else printf("Nao foi possivel excluir elemento entrada 2 - deque vazio.\n");
}


void exibir1(DEQUE* d){
  exibirDequeInicio(d);
}

void exibir2(DEQUE* d){
  exibirDequeFim(d);
}

void meuLog(DEQUE* d){
  printf("Numero de elementos no deque: %i.\n",tamanho(d));
  printf("Tamanho do deque (em bytes): %i.\n",tamanhoEmBytes(d));
}

void help(){
  printf("Comandos validos: \n");
  printf("   i <chave1>: inserir elemento com chave=chave1, na entrada 1\n");
  printf("   j <chave1>: inserir elemento com chave=chave1, na entrada 2\n");
  printf("   e : excluir elemento com chave=chave1, na entrada 1\n");
  printf("   f : excluir elemento com chave=chave1, na entrada 2\n");
  printf("   o : imprimir deque a partir da entrada 1\n");
  printf("   p : imprimir deque a partir da entrada 2\n");
  printf("   d : destruir (zerar) lista\n");
  printf("   l : exibir log de utilizacao do deque\n");
  printf("   h : exibir esta mensagem de ajuda\n");
  printf("   1 : exibir a chave e o endereco do primeiro elemento, entrada 1\n");
  printf("   2 : exibir a chave e o endereco do primeiro elemento, entrada 2\n");
  printf("   q : sair\n");
}

void destruir(DEQUE* d){
     reinicializarDeque(d);
     printf("Deque zerado.\n");
}

int main(){
  DEQUE deque;
  inicializarDeque(&deque);
  help();
  char comando = ' ';
  scanf("%c",&comando);
  while (comando != 'q'){
    switch (comando) {
      case 'i' : inserir1(&deque); break;
      case 'j' : inserir2(&deque); break;
      case 'e' : excluir1(&deque); break;
      case 'f' : excluir2(&deque); break;
      case 'o' : exibir1(&deque); break;
      case 'p' : exibir2(&deque); break;
      case 'd' : destruir(&deque); break;
      case 'l' : meuLog(&deque); break;
      case 'h' : help(); break;
      case '1' : exibirPrimeiro1(&deque); break;
      case '2' : exibirPrimeiro2(&deque); break;

      default: {while (comando != '\n') scanf("%c",&comando);};
    } 
    scanf("%c",&comando);
  }

  return 0;
}
