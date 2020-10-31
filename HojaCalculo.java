
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -   
 *  
 */
public class HojaCalculo
{
    private String nombre;
    private Fila fila1;
    private Fila fila2;
    private Fila fila3;

    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre)    {
        this.nombre = nombre;
        this.fila1 = null;
        this.fila2 = null;
        this.fila3 = null;

    }

    /**
     * accesor para el nombre de la hoja
     */
    public String getNombre() {
        return this.nombre;

    }

    /**
     * accesor para la fila1
     */
    public Fila getFila1() {
        return fila1;

    }

    /**
     * accesor para la fila2
     */
    public Fila getFila2() {
        return fila2;

    }

    /**
     * accesor para la fila3
     */
    public Fila getFila3() {
        return fila3;

    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int contador = 0;
        if(fila1 != null){
            contador ++;
        }
        if(fila2 != null){
            contador ++;
        }
        if(fila3 != null){
            contador ++;
        }
        return contador;

    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if(getNumeroFilas() == 3){
            return true;
        }else{
            return false;
        }

    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if(hojaCompleta() == true){
            System.out.println(fila.getId() + " no se puede añadir en " + this.nombre);
        }else{
            if(fila1 == null){
                fila1= fila;
            }else if(fila2 == null){
                fila2 = fila;
            }else{
                fila3 = fila;
            }
        }

    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        addFila(new Fila(id, fecha, ingresos, gastos));
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        if(getNumeroFilas() == 1){
            return fila1.getIngresos();
        }
        if(getNumeroFilas() == 2){
            return fila1.getIngresos() + fila2.getIngresos();
        }
        if(getNumeroFilas() == 3){
            return fila1.getIngresos() + fila2.getIngresos() + fila3.getIngresos();
        }
        return 0;

    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        if(getNumeroFilas() == 1){
            return fila1.getGastos();
        }
        if(getNumeroFilas() == 2){
            return fila1.getGastos() + fila2.getGastos();
        }
        if(getNumeroFilas() == 3){
            return fila1.getGastos() + fila2.getGastos() + fila3.getGastos();
        }
        return 0;

    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        if(getNumeroFilas() == 1){
            return fila1.getBeneficio();
        }
        if(getNumeroFilas() == 2){
            return fila1.getBeneficio() + fila2.getBeneficio();
        }
        if(getNumeroFilas() == 3){
            return fila1.getBeneficio() + fila2.getBeneficio() + fila3.getBeneficio();
        }
        return 0;

    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String str = "";
        str += ("%8s" + this.nombre + "\n");
        str += String.format("%15s %15s %15s %15s", "FECHA", "INGRESOS", "GASTOS", "BENEFICIO");
        fila1.toString();
        fila2.toString();
        fila3.toString();
        str += ("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        str += String.format("%23s %15.2f€ %15.2f€ % 15.2f€ ", "", getTotalIngresos(), getTotalGastos(), getBeneficio());
        return str; 

    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo duplicado = new HojaCalculo("Duplicada " + this.nombre);
        duplicado.addFila(fila1);
        duplicado.addFila(fila2);
        duplicado.addFila(fila3);
        return duplicado;

    }

}
