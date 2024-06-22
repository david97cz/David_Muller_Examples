#include <stdio.h>
//funkce bez navratove hodnoty a vstupu
void infoFunction(){
  printf("Tento pripad je vykonavan pres funkce \n");
}

void infoChoosen(int choosen){
  printf("Vybrali jste funkcionalitu %d \n",choosen);
}

//funkce s navratovou hodnotou a 2 vstupy
int obvodObdelnika(int length, int width){
  return 2*length + 2*width;
}

int obsahObdelnika(int length, int width){
  return length*width;
}

int scanPar(char par[]){
  int l;
  printf("Zadejte %s \n", par);
  scanf("%d", &l);
  return l;

}

int * bubbleSort(int myArray[]){
  return myArray;
}

int main() {
  char vstup[50];
  int switch_1;
  float x,y,sum,prod;
  int len,wid;

  printf("Funkcionality:\n1 - zadejte libovolny vstup\n"
  "2 - soucin a soucet\n3 - obdelnik\n4 - matice\n");
  printf("Vyberte funkcionalitu: \n");
  scanf("%d", &switch_1);
  printf("Zadali jste: %d.\n", switch_1);
  //vybirani funkcionalit pomoci switche
  switch (switch_1)
  {
  case 1:
    infoChoosen(switch_1);
    printf("Zadejte vstup \n");
    scanf("%s", vstup);
    printf("Zadali jste: %s. \n", vstup);
    break;
  
  case 2:
    infoChoosen(switch_1);
    printf("Zvolte x: \n");
    scanf("%f", &x);
    printf("Zvolte y: \n");
    scanf("%f", &y);
    sum = x + y;
    prod = x*y;
    printf("soucet cisel x = %f a y = %f je %f \n",x,y,sum);
    printf("soucin cisel x = %f a y = %f je %f \n",x,y,prod);

    break;
  case 3:
    infoChoosen(switch_1);
    infoFunction();
    len = scanPar("delku");
    wid = scanPar("sirku");
    printf("Obvod obdelnika o delce %d a sirce %d je: %d \n",len,wid,obvodObdelnika(len,wid));
    printf("Obsah toho obdelnika je: %d \n",obsahObdelnika(len,wid));
    break;
  
  case 4:
    infoChoosen(switch_1);
    printf("Matice \n");
    len = scanPar("delku");
    wid = scanPar("sirku");
    if(len >= 10 || wid >= 10){
      printf("Prilis dlouhy vstupni parametr");
    } else {
      for (int i =1;i<len+1;i++){
        for (int j =1;j<wid+1;j++){
        printf(" %d,%d ",j,i);
        }
        printf("\n");
      }
      printf("Konec For cyklu");
    }
    break;
  
  
  }
  printf("\n ******   Konec programu   *******");
  return 0;
}
