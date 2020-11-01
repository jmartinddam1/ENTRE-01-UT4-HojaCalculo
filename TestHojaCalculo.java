
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - 
 *  
 */
public class TestHojaCalculo
{

    /**
     * Constructor  
     */
    public TestHojaCalculo()    {
        
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podrá guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1() {
          HojaCalculo hoja1 = new HojaCalculo("Hoja1");
          hoja1.addFila("fila1", new Fecha(4,10,2020), 25.50, 132);
          hoja1.addFila("fila2", new Fecha(5,10,2020), 300, 350);
          hoja1.addFila(new Fila("fila3"));
          hoja1.addFila(new Fila("fila4"));
          System.out.println(hoja1.toString());
          System.out.println(hoja1.duplicarHoja());


    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
          HojaCalculo hoja2 = new HojaCalculo("Hoja2");
          hoja2.addFila("fila1", new Fecha(7,10,2020), 260.00, 125.00);
          hoja2.addFila("fila2", new Fecha(8,10,2020), 125.00, 245);
          System.out.println(hoja2.toString());
          System.out.println(hoja2.duplicarHoja());

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
          HojaCalculo hoja3 = new HojaCalculo("Hoja3");
          hoja3.addFila("fila1", new Fecha(7,10,2020), 670.00, 234.00);
          System.out.println(hoja3.toString());
          System.out.println(hoja3.duplicarHoja());
        
    }

}
