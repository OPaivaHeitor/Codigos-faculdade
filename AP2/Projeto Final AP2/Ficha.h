#include<stdio.h>
#include <malloc.h>
#include<stdlib.h>
#include <string.h>

//Lista
typedef char PALAVRA[50];
typedef int TIPOCHAVE;

typedef struct 
{
  TIPOCHAVE Chave;
  PALAVRA Palavra[50];
  //outros campos
}REGISTRO;

typedef struct aux
{
  REGISTRO reg;
  struct aux* prox;
}ELEMENTO;

typedef ELEMENTO* PONT;

typedef struct
{
  PONT inicio;
}LISTA;

void InicializarLista(LISTA* lista);
PONT Busca(LISTA* lista,TIPOCHAVE ch,PONT* ant);
void InserirElemento(LISTA* lista,REGISTRO reg);
//






//Pilha
typedef int NUMERO;

typedef struct
{
  NUMERO numero;
 // outros campos
}REGISTROPILHA;

typedef struct aux_pilha
{
  REGISTROPILHA reg_pilha;
  struct aux_pilha* prox_pilha;
}ELEMENTOPILHA;

typedef ELEMENTOPILHA* PONTPILHA;

typedef struct
{
  PONTPILHA topo;
}PILHA;

void inicializarPilha(PILHA* pilha);
void exibirPilha(PILHA* pilha);
void inserirElemPilha(PILHA* pilha,REGISTROPILHA reg_pilha);
//





//Ficha

typedef struct
{
  LISTA condicoes_previas;
  LISTA alergias;
  LISTA intolerancias;
  LISTA deficiencias;
  LISTA medicacoes;
  LISTA plano_de_saude;
  char nome_completo[50];
  char endereco[60];
  char tipo_sanguineo[3];
  int telefone_de_emergencia;
}FICHA;
