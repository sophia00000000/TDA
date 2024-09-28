import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Main {
    // ArrayList de pilas
    private ArrayList<Stack<Integer>> listaDePilas = new ArrayList<>();

    // Método para llenar el ArrayList con pilas llenas de números aleatorios
    public void llenarPilas(int cantidadDePilas, int cantidadPorPila) {
        Random random = new Random();

        for (int i = 0; i < cantidadDePilas; i++) {
            Stack<Integer> pila = new Stack<>();
            for (int j = 0; j < cantidadPorPila; j++) {
                // Llenar la pila con números aleatorios entre 1 y 100
                pila.push(random.nextInt(100) + 1);
            }
            listaDePilas.add(pila);
        }
    }

    // Método para mostrar el contenido de las pilas
    public void mostrarPilas() {
        for (int i = 0; i < listaDePilas.size(); i++) {
            System.out.println("Pila " + (i + 1) + ": " + listaDePilas.get(i));
        }
    }

    public static void main(String[] args) {
        Main programa = new Main();
        programa.llenarPilas(5, 10); // Crear 5 pilas, cada una con 10 números aleatorios
        programa.mostrarPilas(); // Mostrar el contenido de las pilas
    }
}
