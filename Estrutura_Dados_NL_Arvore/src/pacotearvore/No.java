package pacotearvore;

public class No {
    static class Node {
        int chave;
        Node esquerda, direita;

        public Node(int item) {
            chave = item;
            esquerda = direita = null;
        }
    }
}
