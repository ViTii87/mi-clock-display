
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
        horas.setValue(0);
        minutos.setValue(0);      
        horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
    
    /**
     * Constructor que crea un reloj con las horas y minutos pasados como parametros
     */
    public ClockDisplay(int hora, int minuto)
    {
        horas.setValue(hora);
        minutos.setValue(minuto);
        horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
    
    /**
     * Metodo para fijar el tiempo del reloj pasandole como parametros la hora y los minutos
     */
    public void setTime(int horaNueva, int minutoNuevo)
    {
        horas.setValue(horaNueva);
        minutos.setValue(minutoNuevo);
        horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
    
    /**
     * Metodo para mostrar un String que contendra la hora final de 5 digitos.
     */
    public String getTime()
    {
        return horaFinal;  
    }
    
    /**
     * Metodo para avanzar un minuto en nuestro reloj.
     */
    public void timeTick()
    {
        minutos.increment();
        if( minutos.getValue() == 0) {
            horas.increment();
        }
        horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
}
