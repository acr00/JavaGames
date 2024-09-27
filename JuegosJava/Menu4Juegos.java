package JuegosJava;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

// Importamos las librerias necesarias para el menu, en este caso voy a poner JOptionPane para poner 4 opciones y ImageIcon para poner
// una imagen en cada opcion y que sea mas interactivo

public class Menu4Juegos {
    public static void main(String[] args) {

        // Crear las opciones del menú

        String[] opciones =     { "Sudoku", "Conecta 4" , "Ahorcado" , "Adivina el número" };

        // Creamos los huecos para cada imagen que hemos elegido y ponemos la ruta de donde recogera esas imagenes

        ImageIcon Sicon1 =      new ImageIcon    ("C:\\Users\\adria\\Desktop\\ProyectosClase\\MenuJuegos\\IconSudoku.png");
        ImageIcon Cicon2 =      new ImageIcon    ("C:\\Users\\adria\\Desktop\\ProyectosClase\\MenuJuegos\\IconConecta4.png");
        ImageIcon Ahicon3 =     new ImageIcon    ("C:\\Users\\adria\\Desktop\\ProyectosClase\\MenuJuegos\\IconAhorcado.png");
        ImageIcon ANicon4 =     new ImageIcon    ("C:\\Users\\adria\\Desktop\\ProyectosClase\\MenuJuegos\\IconAdivinaNumero.png");

        // Mostrar el menú de opciones

        int seleccion = JOptionPane.showOptionDialog(null, "Selecciona un juego", "Menú de Juegos",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        // Realizar una acción según la opción seleccionada

        switch (seleccion) {
            case 0:

                // Opcion del juego de Sudoku con un cuadro de texto

                JOptionPane.showMessageDialog(null, " Has seleccionado Sudoku ",
                         "Sudoku", JOptionPane.INFORMATION_MESSAGE , Sicon1);
                         sudoku sudoku = new sudoku();
                         sudoku.play();
                break;
            case 1:
                // Lógica para el juego de Conecta 4
                JOptionPane.showMessageDialog(null, " Has seleccionado Conecta 4 ",
                         "Conecta 4", JOptionPane.INFORMATION_MESSAGE , Cicon2);
                         Conecta4 conecta4 = new Conecta4();
                         Conecta4.partida();
                break;
            case 2:
                // Lógica para el juego de Ahorcado
                JOptionPane.showMessageDialog(null, " Has seleccionado Ahorcado ",
                         "Ahorcado", JOptionPane.INFORMATION_MESSAGE , Ahicon3);
                break;
            case 3:
                // Lógica para el juego de Adivina el número
                JOptionPane.showMessageDialog(null, " Has seleccionado Adivina el número ",
                         "Adivina el número", JOptionPane.INFORMATION_MESSAGE , ANicon4);
                         adivinaElNumero juego = new adivinaElNumero();
                         juego.adivinaElNumero();
                break;
            default:
                JOptionPane.showMessageDialog(null, "No has seleccionado ninguna opción");
                break;

             }

    }//metodo main

    
} //class









