package pacoteestrutura;


public class Pilha {
    //Implementacao de pilha em Java

    static class Stack {

    //armazena elementos da pilha
    private int arr[];
    //representa o topo da pilha
    private int topo;
    //capacidade total da pilha
    private int capacidade;
      

    // Creating a stack
    Stack(int tamanho) {
        // inicializa o array
        // inicializa as variáveis da pilha
        arr = new int[tamanho];
        capacidade = tamanho;
        topo = -1;
    }
      
    // push elements to the topo of stack
    public int push(int x) {
        if (isFull()) {
          System.out.println("Stack OverFlow");

          // terminates the program
          System.exit(1);
        }

        // insert element on topo of stack
        System.out.println("Inserting " + x);
        return arr[++topo] = x;
    }

    // pop elements from topo of stack
    public int pop() {

        // if stack is empty
        // no element to pop
        if (isEmpty()) {
          //System.out.println("STACK EMPTY");
          // terminates the program
          System.exit(1);
        }

        // pop element from topo of stack
        return arr[topo--];
    }

    // return tamanho of the stack
    public int getSize() {
        return topo + 1;
    }

    // return tamanho of the stack
    public int getTop() {
        return topo;
    }
    
    // return tamanho of the stack
    public int getArr(int i) {
        return arr[i];
    }
    
    // check if the stack is empty
    public Boolean isEmpty() {
        return topo == -1;
    }

    // check if the stack is full
    public Boolean isFull() {
        return topo == capacidade - 1;
    }

    // display elements of stack
    public void printStack() {
        for (int i = 0; i <= topo; i++) {
          System.out.print(arr[i] + ", ");
        }
    }

    }
}
