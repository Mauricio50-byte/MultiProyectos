public class Ejercicio162 {
    /*162. Realizar un programa que muestre por pantalla la tabla de multiplicar de
cualquier número positivo menor a 10. */
    public static void main(String[] args) {
        for(int i = 0; i <= 10; i++){
            System.out.println("La tabla del " + (i));
            for(int j=1;j<=10;j++){
                int result = i * j;
                System.out.print((i)+" x "+(j)+" = "+result+"\n");
            }
        System.out.println("#######################################");
        }
    }
}
