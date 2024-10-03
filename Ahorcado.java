import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

// PALABRA
        
        String [] palabras = {"perro", "gato", "serpiente"}; // palabras ahorcado
        Random r = new Random(); //eleccion random
        int n = r.nextInt(palabras.length); // rango
        String palabraSecreta = palabras[n];//palabra secreta

//GUIONES

        int letras = palabraSecreta.length();// medir numero de letras
        //sustitucion de letras por guiones
        char [] guiones = new char [letras];
        for (int i=0; i<guiones.length; i++)
            {guiones[i]= '_';}
        

    boolean fin = false;//control de si el juego a terminado
    int intentos=6;//cuenta de intentos 

    while (!fin && intentos>0) //mientras que el juego no termine se ejecutara elte bucle
    {
    //estado del juego
    System.out.println(guiones);
    dibujo (intentos);
    System.out.println("Introduce una letra");

    
    char intento =scanner.next().charAt(0); //devuelve el carácter ubicado en el índice especificado de String. 
    boolean acierto=false;

//comprobar si la letra esta en la palabra secreta

    for (int i=0; i < palabraSecreta.length(); i++)
        {
        if (palabraSecreta.charAt(i) == intento)
            {guiones[i]=intento;
            acierto = true;}
        }

        if(!acierto)
        { 
            --intentos;
            System.out.println("No has acertado. Tienes "+ intentos + " intentos");
        
            if (intentos==0) 
            {System.out.println("HAS PERDIDO. La palabra era "+ palabraSecreta);}
        }
        else
        {
            fin = !continuidad(guiones);
            if (fin) 
            {System.out.println("¡HAS GANADO!. LA PALAGRA ERA "+ palabraSecreta);}
        }

    }

    }



//para comprobar si se ha ganado el juego comprobando si quedan guiones
static boolean continuidad (char [] array) {

    for (char a:array) 
    {
    if(a=='_')
        {return true;}
    }
    return false;}
 
//basandose en el numero de intentos que quedan se hace cada dibujo
static void dibujo (int intentos){

switch (intentos){
    
    case 6 -> {
        System.out.println("  ---------  ");
        System.out.println(" |         | ");
        System.out.println(" |           ");
        System.out.println(" |           ");
        System.out.println(" |           ");
        System.out.println(" |           ");
        System.out.println(" |           ");
        System.out.println(" |           ");
            }
            case 5 -> {
                System.out.println("  ---------  ");
                System.out.println(" |         | ");
                System.out.println(" |         O ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
            }
            case 4 -> {
                System.out.println("  ---------  ");
                System.out.println(" |         | ");
                System.out.println(" |         O ");
                System.out.println(" |         | ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
            }
            case 3 -> {
                System.out.println("  ---------  ");
                System.out.println(" |         | ");
                System.out.println(" |         O ");
                System.out.println(" |        /| ");
                System.out.println(" |           ");
                System.out.println(" |           ");
            }
            case 2 -> {
                System.out.println("  ---------  ");
                System.out.println(" |         | ");
                System.out.println(" |         O ");
                System.out.println(" |        /|\\ ");
                System.out.println(" |           ");
            }
            case 1 -> {
                System.out.println("  ---------  ");
                System.out.println(" |         | ");
                System.out.println(" |         O ");
                System.out.println(" |        /|\\ ");
                System.out.println(" |        /  ");
            }
            case 0 -> {
                System.out.println("  ---------  ");
                System.out.println(" |         | ");
                System.out.println(" |         O ");
                System.out.println(" |        /|\\ ");
                System.out.println(" |        / \\ ");
            }
        }
    }
}


