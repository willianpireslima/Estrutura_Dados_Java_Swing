package pacotearvore;

public class Arvore {
    
      static class BinarySearchTree {
        
        No.Node raiz;
        
        //Construtor
        BinarySearchTree() {
            raiz = null;
        }

        // Uma função utilitária para inserir
        // um novo nó com determinada chave no BST
        No.Node insert(No.Node node, int chave) {
            //Se a árvore estiver vazia, retorna um novo nó
            if (node == null) {
                node = new No.Node(chave);
                return node;
            }

            // Otherwise, recur down the tree
            if (chave < node.chave)
                node.esquerda = insert(node.esquerda, chave);
            else if (chave > node.chave)
                node.direita = insert(node.direita, chave);

           // Retorna o ponteiro do nó (inalterado)
            return node;
        }

        //Função utilitária para buscar uma chave em um BST
        No.Node search(No.Node raiz, int chave) {
            // Casos Base: raiz é nula ou chave está presente em raiz
            if (raiz == null || raiz.chave == chave)
                return raiz;

            //A chave é maior que a chave do raiz
            if (raiz.chave < chave)
                return search(raiz.direita, chave);

            //A chave é menor que a chave do raiz
            return search(raiz.esquerda, chave);
        }
        
    
        /* Dada uma árvore de busca binária e uma chave, esta função
         apaga a chave e retorna a nova raiz */
        No.Node deleteNode(No.Node raiz, int chave) {
            // Base case
            if (raiz == null)
                return raiz;

            // Recursive calls for ancestors of
            // node to be deleted
            if (raiz.chave > chave) {
                raiz.esquerda = deleteNode(raiz.esquerda, chave);
                return raiz;
            } else if (raiz.chave < chave) {
                raiz.direita = deleteNode(raiz.direita, chave);
                return raiz;
            }

            // Chegamos aqui quando raiz é o nó
            // Para ser deletado.

            // se uma das children esta vazia
            if (raiz.esquerda == null) {
                No.Node temp = raiz.direita;
                return temp;
            } else if (raiz.direita == null) {
                No.Node temp = raiz.esquerda;
                return temp;
            }

            // se ambas children existem
            else {

                No.Node succParent = raiz;

                // Find successor
                No.Node succ = raiz.direita;
                while (succ.esquerda != null) {
                    succParent = succ;
                    succ = succ.esquerda;
                }

                // Exclui o sucessor. Desde o sucessor
                // é sempre filho à esquerda de seu pai
                // podemos fazer com segurança a direita do sucessor
                // direita filho como esquerda de seu pai.
                //Se não houver sucesso, então atribua
                // succ.direita para succParent.direita
                if (succParent != raiz)
                    succParent.esquerda = succ.direita;
                else
                    succParent.direita = succ.direita;

                //Copiar dados do sucessor para raiz
                raiz.chave = succ.chave;

                //Excluir sucessor e retornar raiz
                return raiz;
            }
        } 
        
        // Uma função utilitária para fazer traversal inorder do BST
        String inorder(No.Node raiz) {
            String buff="";
            if (raiz != null) {
                buff += inorder(raiz.esquerda);
                buff += raiz.chave + " ";
                buff += inorder(raiz.direita);
            }
        return buff;    
        }
        
         // Preorder Traversal
        String preOrder(No.Node node){
          String buff = "";
            if (node == null)
                return "";

            // Visita o nó
            buff += node.chave + " ";

            // Atravessa a subárvore esquerda
            buff += preOrder(node.esquerda);

            // Atravessa a subárvore direita
            buff += preOrder(node.direita);

            return buff;
        }
        
         // Preorder Traversal
        String postOrder(No.Node node){
           String buff="";
           if (node == null)
            return "";

          //Atravessar subárvore esquerda
          buff += postOrder(node.esquerda);

          //Atravessar subárvore à direita
          buff += postOrder(node.direita);

          // Visita o no
          buff += node.chave + " ";
        
        return buff;
        }
        
         // Função para mostrar as arestas dos vértices da árvore
        String mostrarArestas(No.Node node) {
             String buff = "";
            if (node != null) {
            if (node.esquerda != null) {
                buff += "Aresta: " + node.chave + " -> " + node.esquerda.chave + "\n";
                buff += mostrarArestas(node.esquerda);
            }
            if (node.direita != null) {
                buff += "Aresta: " + node.chave + " -> " + node.direita.chave + "\n";
                buff += mostrarArestas(node.direita);
            }
        }    
        return buff;
        }
    }
}
