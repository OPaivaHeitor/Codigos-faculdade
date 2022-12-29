#include "Ficha.h"

//Lista
void InicializarLista(LISTA* lista)
{
  lista-> inicio = NULL;
}

PONT Busca(LISTA* lista,TIPOCHAVE ch,PONT* ant)
{
  *ant = NULL;
  PONT atual = lista->inicio;
  while((atual!=NULL)&&(atual->reg.Chave<ch))
  {
    *ant = atual;
    atual = atual->prox;
  }
  if((atual!=NULL)&&(atual->reg.Chave==ch))
  {
    return atual;
  }
  return NULL;
}

void InserirElemento(LISTA* lista,REGISTRO reg)
{
  TIPOCHAVE ch = reg.Chave;
  PONT ant,i;
  i =  Busca(lista,ch,&ant);
  if(i!=NULL)
  {
    printf("Elemento nao inserido");
  }
  i = (PONT) malloc(sizeof(ELEMENTO));
  i->reg = reg;
  if(ant == NULL)
  {
    i->prox = lista->inicio;
    lista->inicio = i;
  }
  else 
  {
    i->prox = ant->prox;
    ant->prox = i;
  }
  printf("Elemento inserido com sucesso");
}
//



//Pilha
void inicializarPilha(PILHA* pilha)
{
  pilha->topo = NULL;
}

void exibirPilha(PILHA* pilha)
{
  PONTPILHA end = pilha->topo;
  printf("Pilha: ");
  while( end != NULL)
  {
    printf("%i",end->reg_pilha.numero);
    end = end->prox_pilha;
  }
}

void inserirElemPilha(PILHA* pilha,REGISTROPILHA reg_pilha)
{
  PONTPILHA novo = (PONTPILHA) malloc(sizeof(ELEMENTOPILHA));
  novo->reg_pilha = reg_pilha;
  novo->prox_pilha = pilha->topo;
  pilha->topo = novo;
}

//

