public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 4);

        grafo.mostrarMatriz();
        System.out.println();

        grafo.dfs(0);
        grafo.bfs(0);
    }
}