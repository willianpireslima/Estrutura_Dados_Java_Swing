package pacoteestrutura;

public class Fila {
    // Implementação de fila em Java

    static public class Queue {
      int TAMANHO = 5;
      int items[];
      int dianteiro, traseiro;

      Queue(int size) {
        items= new int[size];
        TAMANHO = size;
        dianteiro = -1;
        traseiro = -1;
      }

      boolean isFull() {
        if (dianteiro == 0 && traseiro == TAMANHO - 1) {
          return true;
        }
        return false;
      }

      boolean isEmpty() {
        if (dianteiro == -1)
          return true;
        else
          return false;
      }

      int enFileirar(int element) {
        if (isFull()) {
          System.out.println("A fila esta cheia");
        } else {
          if (dianteiro == -1)
            dianteiro = 0;
          traseiro++;
          items[traseiro] = element;

        }
        return items[traseiro];
      }

      int desenFileirar() {
        int element;
        if (isEmpty()) {
          System.out.println("A fila esta vazia");
          return (-1);
        } else {
          element = items[dianteiro];
          if (dianteiro >= traseiro) {
            dianteiro = -1;
            traseiro = -1;
          } /* f tem apenas um elemento, então redefinimos a fila após excluí-la. */
          else {
            dianteiro++;
          }
          System.out.println("Deleted -> " + element);
          return (element);
        }
      }


    }
}
