import java.util.Scanner;

public class Ejercicio_23 {
/* 23.Juego del Rojo-amarillo-verde. El programa genera tres dígitos aleatorios distintos
entre 0 y 9. A estos dígitos se les asignan las posiciones 1, 2 y 3. El objetivo del
juego es adivinar los dígitos así como sus posiciones correctas en el menor número
de intentos posibles. Para cada intento, el jugador proporciona tres dígitos para las
posiciones 1, 2, y 3. El programa responde con una pista que consta de rojo,
amarillo y verde. Si un dígito adivinado está en la posición correcta la respuesta es
verde. Si el digito adivinado está en posición incorrecta, la respuesta es amarillo. Si
el dígito para una posición dada no coincide con ninguno de los tres dígitos, la
respuesta es rojo.*/
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int[] Digitos = new int[3];
        for(int i = 0;i < Digitos.length; i++){
            Digitos[i] = (int) (Math.random() * 10);
        }
        System.out.println("Binvenido al juego del Rojo-amarillo-verde");
        System.out.println("Intente adivinar los digitos de la mejor forma correcta");

        boolean adivinado = false;

        while (!adivinado) {
            System.out.print("Ingresa tus tres dígitos separados por espacios (0-9): ");
            int[] intento = new int[3];
            for (int i = 0; i < intento.length; i++) {
                intento[i] = lector.nextInt();
            }

            int Amarillo = 0;
            int Verde = 0;
            int rojo = 0;

            for (int i = 0; i < intento.length; i++) {
                if (intento[i] == Digitos[i]) {
                    Verde++;
                } else if (contiene(Digitos, intento[i])) {
                    Amarillo++;
                }else{
                    rojo++;
                }
            }

            System.out.println("Verdes: " + Verde);
            System.out.println("Amarillos: " + Amarillo);
            System.out.println("Rojos:"+ rojo);

            if (Verde == 3) {
                adivinado = true;
                System.out.println("¡Ganaste!");
            }
        }
    } 
    private static boolean contiene(int[] array, int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                return true;
            }
        }
		return false;
	}
}
