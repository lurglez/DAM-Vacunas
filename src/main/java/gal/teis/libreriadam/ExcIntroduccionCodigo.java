/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.libreriadam;

/**
 *
 * @author Usuario
 */
public class ExcIntroduccionCodigo extends Exception  {
    
   
    public ExcIntroduccionCodigo (int intentos) {
        super("Demasiados intentos, el máximo es: "
                + intentos);
    }
    
  
    public ExcIntroduccionCodigo (String codigo) {
        System.out.println("Está intentando añadir una vacuna que ya existe.");
    }
    
}
