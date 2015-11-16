
/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
    // Atributo de tipo NumberDisplay para las horas
    private NumberDisplay horas = new NumberDisplay(24);
    // Atributo de tipo NumberDisplay para los minutos
    private NumberDisplay minutos = new NumberDisplay(60);
    // Atributo de tipo String para guardar la hora completa.
    private String horaFinal;
    
    /**
     * Constructor para crear un reloj con las horas y minutos fijadas a 0
     */
    public ClockDisplay()
    {
        // Fijamos mediante el metodo setValue de la clase NumberDisplay la hora por defecto a 0.
        horas.setValue(0);
        // Lo mismo con los minutos.
        minutos.setValue(0);
        // Fijamos nuestro String de 5 digitos con la hora y los minutos que dicta el constructor.
        horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
    
    /**
     * Constructor que crea un reloj con las horas y minutos pasados como parametros
     */
    public ClockDisplay(int hora, int minuto)
    {
        // Fijamos mediante el metodo setValue de la clase NumberDisplay la hora introducida como parametro.
        horas.setValue(hora);
        // Lo mismo con los minutos.
        minutos.setValue(minuto);
        // Fijamos nuestro String de 5 digitos con la hora y los minutos pasados como parametros del constructor.
        horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
    
    /**
     * Metodo para fijar el tiempo del reloj pasandole como parametros la hora y los minutos
     */
    public void setTime(int horaNueva, int minutoNuevo)
    {
        // Fijamos mediante el metodo setValue de la clase NumberDisplay la hora introducida como parametro.
        horas.setValue(horaNueva);
        // Lo mismo con los minutos.
        minutos.setValue(minutoNuevo);
        // Fijamos nuestro String de 5 digitos con la hora y los minutos pasados como parametros del metodo.
        horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
    
    /**
     * Metodo para mostrar un String que contendra la hora final de 5 digitos.
     */
    public String getTime()
    {
        // Primero creamos nuestro String de 5 digitos obteniendo los valores de cada display mediante el metodo getDisplayValue de la clase NumberDisplay.
        horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
        // Ahora devolvemos el String con la hora correctamente fiajda.
        return horaFinal; 
    }
    
    /**
     * Metodo para avanzar un minuto en nuestro reloj.
     */
    public void timeTick()
    {
        // Incrementamos los minutos llamando a el metodo increment de la clase NumberDisplay.
        minutos.increment();
        // Obtengo los minutos mediante un metodo de la clase NumberDisplay y si son igual a 0 quiere decir que tenemos que incrementar una hora.
        if( minutos.getValue() == 0) {
            horas.increment();
        }
        // Actualizamos nuestro String despues de haber aplicado las operaciones.
        horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
}
