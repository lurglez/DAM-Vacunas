/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicavacunas;

/**
 *
 * @author a20marialgl
 */
public interface IAutorizable {
/*La interfaz IAutorizable se usará para autorizar o no los objetos creados a partir de
Vacuna y tendrá dos métodos:
• boolean autorizar() que hace que una vacuna esté autorizada para su uso.
• boolean rechazar() que hace que una vacuna no esté autorizada para su uso.
El valor devuelto de los dos métodos indica si la operación se ha realizado o no. */
    
 public boolean autorizar();
 public boolean rechazar();
    
}
