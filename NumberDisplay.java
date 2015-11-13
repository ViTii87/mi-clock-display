
/**
 * Write a description of class NumberDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumberDisplay
{
    // Atributo que difinira el valor del digito.
    private int valor;
    // Atributo que definira el limite del valor.
    private int limite;

    /**
     * Constructor para crear displays con un valor y un limite pasado como parametro.
     */
    public NumberDisplay(int limiteDisplay)
    {
        valor = 0;
        limite = limiteDisplay;
    }

    
    /**
     * Metodo que nos permitira fijar el valor de nuestro display.
     */
    public void setValue(int valorDisplay){
        // Si el valor pasado como parametro es menor o igual que el limite establecido en el constructor entonces le asignamos al atributo el valor introducido.
        if((valorDisplay <= limite) && (valorDisplay >= 0)){
            valor = valorDisplay;
        }
        else{
            // Si el valor introducido es mas grande que el limite entonces indicamos al usuario un mensaje de error.
            System.out.println("El valor introducido:" + valorDisplay + " se sale de los limites del display [0 - " + limite + "]");
        }
        
    }
    
    /**
     * Metodo para obtener un string con los digitos introducidos.
     */
    public String getDisplayValue(){
        // Creamos una variable local para almacenar nuestro valor del display.
        String digitos = "" + valor;
        // si el valor es menor que 10 entonces tendremos que añadirle un digito delante de nuestro valor.
        if(valor < 10){
            digitos = "0" + valor;
        }
        return digitos;
    }
}
