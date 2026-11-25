import java.util.LinkedList;
import java.util.Queue;

public class Grafo {
    private int numVertices;
    private int[][] matrizAdyacencia;

    // Constructor: inicializa la matriz de tamaño V x V con ceros
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.matrizAdyacencia = new int[numVertices][numVertices];
    }

    // Agrega una arista bidireccional (grafo no dirigido)
    public void agregarArista(int origen, int destino) {
        if (esValido(origen) && esValido(destino)) {
            matrizAdyacencia[origen][destino] = 1;
            matrizAdyacencia[destino][origen] = 1;
        } else {
            System.out.println("Error: Vértice fuera de rango.");
        }
    }

    private boolean esValido(int v) {
        return v >= 0 && v < numVertices;
    }

    // Muestra la matriz de adyacencia en consola
    public void mostrarMatriz() {
        System.out.println("=== Matriz de Adyacencia ===");
        System.out.print("   ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Algoritmo DFS (Búsqueda en Profundidad)
    public void dfs(int inicio) {
        if (!esValido(inicio)) return;
        boolean[] visitado = new boolean[numVertices];
        System.out.print("Recorrido DFS (desde nodo " + inicio + "): ");
        dfsRecursivo(inicio, visitado);
        System.out.println();
    }

    private void dfsRecursivo(int actual, boolean[] visitado) {
        visitado[actual] = true;
        System.out.print(actual + " ");

        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[actual][i] == 1 && !visitado[i]) {
                dfsRecursivo(i, visitado);
            }
        }
    }

    // Algoritmo BFS (Búsqueda en Anchura)
    public void bfs(int inicio) {
        if (!esValido(inicio)) return;
        boolean[] visitado = new boolean[numVertices];
        Queue<Integer> cola = new LinkedList<>();

        visitado[inicio] = true;
        cola.add(inicio);

        System.out.print("Recorrido BFS (desde nodo " + inicio + "): ");

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.print(actual + " ");

            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[actual][i] == 1 && !visitado[i]) {
                    visitado[i] = true;
                    cola.add(i);
                }
            }
        }
        System.out.println();
    }
}