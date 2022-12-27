#include <stdio.h>	// printf, scanf
#include <stdlib.h> // system
#include <ctype.h>  // toupper
#include <malloc.h>	// malloc, realloc

int main()
{
  int *pInt;
  int elemento, n=3, i=0;
  char Resposta;

  pInt = (int *) malloc(n * sizeof(int));
  if (pInt == NULL)
    printf("Nao ha memoria suficiente!");
  else {
    do {
  	  printf("%io. elemento do vetor: ", i+1);
      scanf("%i", &elemento);
      *(pInt + i) = elemento;
      i++;

      if (i >= n) {
        printf("Deseja continuar (S/N)? ");
        Resposta = getch();
        printf("\n");

   	    if (toupper(Resposta) == 'S') {
          pInt = (int *) realloc(pInt, (n+3) * sizeof(int));
          if (pInt == NULL) {
            printf("Nao ha memoria suficiente!");
            break;
          }
          else {
            n += 3;
          }
        }
	      else {
	        break;
        }
	    }
    } while (1);
  }

  printf("\nn: %i\n\n", n);
  for (i=0; i<n; i++) {
    printf("%i ", *(pInt + i));
  }

	system("pause > nul");
  free(pInt);
  return 0;
}
