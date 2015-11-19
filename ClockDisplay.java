
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
    // Atributo que usaremos para comprobar si estamos en las primeras 12 horas o las segundas
    private boolean bandera;
    // Atributo para decidir si usamos el formato nuevo o el antiguo
    private boolean formato;
    
    /**
     * Constructor para crear un reloj con las horas y minutos fijadas a 0, le pasaremos un booleano como parametro, si es TRUE representamos
     * la hora en el formato de 12 horas, si es false en el de 24
     */
    public ClockDisplay(boolean format)
    {
        // Fijamos mediante el metodo setValue de la clase NumberDisplay la hora por defecto a 0.
        horas.setValue(0);
        // Lo mismo con los minutos.
        minutos.setValue(0);
        // Actualizamos nuestro booleano.
        formato = format;
        // Llamamos a nuestro metodo para dejar la hora en el formato correcto.
        horaBuena(horas.getValue());
    }
    
    /**
     * Constructor que crea un reloj con las horas y minutos pasados como parametros
     */
    public ClockDisplay(int hora, int minuto, boolean format)
    {
        // Fijamos mediante el metodo setValue de la clase NumberDisplay la hora introducida como parametro.
        horas.setValue(hora);
        // Lo mismo con los minutos.
        minutos.setValue(minuto);
        //Actualizamos nuestro booleano.
        formato = format;
        // Llamamos a nuestro metodo para dejar la hora en el formato correcto.
        horaBuena(hora);
    }
    
    /**
     * Metodo para fijar el tiempo del reloj pasandole como parametros la hora y los minutos
     */
    public void setTime(int horaNueva, int minutoNuevo)
    {
        // Fijamos mediante el metodo setValue de la clase NumberDisplay los minutos pasados como parametro.
        minutos.setValue(minutoNuevo);

        // Llamamos a nuestro metodo para dejar la hora en el formato correcto, le pasamos las horas como parametro.
        horaBuena(horaNueva);
       
    }
    
    /**
     * Metodo para mostrar un String que contendra la hora final de 5 digitos.
     */
    public String getTime()
    {
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
            if(horas.getValue() == 12 && bandera==false){
                horas.setValue(0);
            }
        }
        // Actualizamos nuestro String despues de haber aplicado las operaciones en el formato correcto.
        horaBuena(horas.getValue());
    }
    
    /**
     * Metodo para dejar la hora en el formato correcto
     */
    public void horaBuena(int horaNueva){
        // Si formato es 12 horas entonces ejecutamos nuestro metodo para cambiar el formato al correcto
        if(formato == true){
            // Si la hora es menos que 12 tiene que ser A.M.
            if(horaNueva<12){
                // Fijamos la nueva hora
                horas.setValue(horaNueva);
                // Pondremos nuestra bandera a True, quiere decir que estamos en las primeras 12 horas
                bandera=true;
                // Devolvemos la hora con el nuevo formato
                horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue() +  " A.M.";
            }
            else {
                // Si no la hora tendra que ser las 12 del mediodia con el formato P.M.
                if(horaNueva==12){
                    // Fijamos la nueva hora
                    horas.setValue(horaNueva);
                    // Pondremos nuestra bandera a False, quiere decir que estamos en las segundas 12 horas
                    bandera=false;
                    // Devolvemos la hora con el nuevo formato
                    horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " P.M.";
                }
                else{
                    // Fijamos la hora correspondiente de la tarde
                    horas.setValue(horaNueva-12);
                    // Pondremos nuestra bandera a False, quiere decir que estamos en las segundas 12 horas
                    bandera=false;
                    // Devolvemos la hora con el nuevo formato
                    horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " P.M.";
                }
            }
        }else{
            // Si le decimos a nuestro reloj que queremos horas en formato 24 horas
            horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
        }
    }
    
    public void alternarHora(boolean formato){
       horaBuena(horas.getValue());
    }
}
