package JuegosJava;
import javax.swing.JOptionPane;

public class AdivinaElNumero {
    public static void main(String[] args) {
        adivinaElNumero();
    }

    public static void adivinaElNumero() {
        int numSecreto = (int) (Math.random() * 101); // Generar número aleatorio entre 0 y 100
        int intentos = 0;
        int numUsuario = -1;

        while (numUsuario != numSecreto) {
            String respuesta = JOptionPane.showInputDialog(null, "Adivina el número entre 0 y 100:");
            if (respuesta == null) {
                JOptionPane.showMessageDialog(null, "Juego cancelado");
                return;
            }
            try {
                numUsuario = Integer.parseInt(respuesta);
                if (numUsuario < 0 || numUsuario > 100) {
                    JOptionPane.showMessageDialog(null, "Por favor, introduce un número entre 0 y 100");
                    continue;
                }
                intentos++;
                if (numUsuario < numSecreto) {
                    JOptionPane.showMessageDialog(null, "El número es mayor");
                } else if (numUsuario > numSecreto) {
                    JOptionPane.showMessageDialog(null, "El número es menor");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Felicidades! Has adivinado el número en " + intentos + " intentos.");
                    int reiniciar = JOptionPane.showConfirmDialog(null, "¿Quieres jugar de nuevo?", "Reiniciar juego", JOptionPane.YES_NO_OPTION);
                    if (reiniciar == JOptionPane.YES_OPTION) {
                        adivinaElNumero(); // Reiniciar el juego
                    } else {
                        JOptionPane.showMessageDialog(null, "Gracias por jugar");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido");
            }
        }
    }
}