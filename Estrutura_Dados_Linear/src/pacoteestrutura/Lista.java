package pacoteestrutura;

public class Lista {
    
    static class ListNode {
    int val;
    ListNode proximo;

    public ListNode(int val) {
        this.val = val;
    }

    // Método para inserir um novo nó no final da lista
    public ListNode inserir(int val) {
        ListNode newNode = new ListNode(val);
        ListNode current = this;
        while (current.proximo != null) {
            current = current.proximo;
        }
        current.proximo = newNode;
        return newNode; // Retorna o nó inserido
    }

  

    }

}
