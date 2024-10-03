
import java.util.Scanner;

public class AdivinaElNumero {
    
    private final Scanner scanner = new Scanner(System.in);
    private boolean reiniciar = true;

    public static void main(String[] args) {
        AdivinaElNumero juego = new AdivinaElNumero();
        juego.iniciar();
    }

    public void iniciar() {
        while (reiniciar) {
            jugarPartida();
            preguntarReiniciar();
        }
    }

        
        private void jugarPartida(){

                int aleatorio = (int) (Math.random()*100) + 1;//eleccion de numero aleatorio entre 0 y 100


                //contadores
                int intento =0;
        
                int errores =0;
                
                while (aleatorio!=intento)
                {
                    //scanner para el jugador
                    System.out.println("Que numero crees que es (entre 0 y 100)?");
                    intento = scanner.nextInt();
                    errores++;
            
                    if (intento>100)//comprobar que no se mayor de 100
                        {System.out.println("ERROR. El numero esta entre 0 y 100");}
                    else if (intento>aleatorio)//si es menor delvolver info
                        {System.out.println("Numero es menor");}
                    else if (intento<aleatorio)//si es mayor devolver info
                        {System.out.println ("Numero es mayor");}
                    else//jugador acierta
                        {System.out.println ("Enhorabuena el numero es " + intento + " has usado "+ errores+" intentos para adivinar el numero");}
                }
            }
            //reinicio de juego
            private void preguntarReiniciar() {
                scanner.nextLine(); // Consume the newline left-over
                System.out.println("¿Quieres jugar otra vez? (si o no)");
                String respuesta = scanner.nextLine();
        
                // Check the response to determine if the game should restart
                if (respuesta.equalsIgnoreCase("si")) {
                    reiniciar = true;
                } else {
                    reiniciar = false;
                    System.out.println("Gracias por jugar.");
                }
            }
        }  