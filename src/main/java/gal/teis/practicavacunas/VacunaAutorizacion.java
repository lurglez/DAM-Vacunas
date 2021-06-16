/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicavacunas;

import java.time.LocalDate;

/**
 * Una clase para almacenar los metodos destinados a dar valores propios a cada
 * vacuna. Implementa la interface IAutorizable.
 *
 * @author Lourdes Gonzalez
 */
public abstract class VacunaAutorizacion implements IAutorizable {

    LocalDate fechaResultado;

    /*decision*/
    protected boolean autorizar;
    protected boolean rechazar;
    protected boolean autorizada;
    protected boolean rechazada;

    protected boolean fase1;
    protected boolean fase2;
    protected boolean fase3;
    protected byte fasesCompletadas = 0;

    /**
     * Da el valor indicado a la FASE1.
     *
     * @param opcion es el valor dado por teclado a la fase.
     *
     * @return devuelve el valor de fase1.
     */
    public boolean fase1Superada(char opcion) {
        if (Character.toUpperCase(opcion) == 'S') {
            fase1 = true;
        } else {
            fase1 = false;
        }
        fasesCompletadas++;
        return fase1;
    }

    /**
     * Da el valor indicado a la FASE2.
     *
     * @param opcion es el valor dado por teclado a la fase.
     *
     * @return devuelve el valor de fase2.
     */
    public boolean fase2Superada(char opcion) {
        if (Character.toUpperCase(opcion) == 'S') {
            fase2 = true;
        } else {
            fase2 = false;
        }
        fasesCompletadas++;
        return fase2;
    }

    /**
     * Da el valor indicado a la FASE3.
     *
     * @param opcion es el valor dado por teclado a la fase.
     *
     * @return devuelve el valor de fase3.
     */
    public boolean fase3Superada(char opcion) {
        if (Character.toUpperCase(opcion) == 'S') {
            fase3 = true;
        } else {
            fase3 = false;
        }
        fasesCompletadas++;
        return fase3;
    }

    /**
     * Devuelve el valor de fase1
     *
     */
    public boolean getFase1() {
        return fase1;
    }

    /**
     * Devuelve el valor de fase2
     *
     */
    public boolean getFase2() {
        return fase2;
    }

    /**
     * Devuelve el valor de fase3
     *
     */
    public boolean getFase3() {
        return fase3;
    }

    /**
     * Devuelve el valor de fasesCompletadas
     *
     */
    public byte fasesCompletadas() {
        return fasesCompletadas;
    }

    /**
     * Devuelve el valor de fechaResultado.
     */
    public LocalDate fechaResultado() {
        return  fechaResultado;
    }

    /**
     * Autoriza la vacuna y modifica la fecha en lo que se dijo
     *
     * @param decision recoge el resultado indicado.
     *
     * @return devuelve true si ha sido autorizada
     */
 
    public boolean autorizar(char decision) {
        if (fasesCompletadas == 3 && fase3 && Character.toUpperCase(decision) == 'S') {
            autorizada = true;
        } else {
            autorizada = false;
        }
        fechaResultado = LocalDate.now();
        return autorizada;
    }

    /**
     * Rechaza la vacuna y modifica la fecha en lo que se dijo
     *
     * @param decision recoge el resultado indicado.
     *
     * @return devuelve true si ha sido rechazada
     */

    public boolean rechazar(char decision) {
        if (fasesCompletadas == 3 && fase3  && Character.toUpperCase(decision) != 'S') {
            rechazada = true;
        } else {
            rechazada = false;
        }
        fechaResultado = LocalDate.now();
        return rechazada;
    }

    /**
     * @return devuelve true si la vacuna ha sido autorizada.
     */
    public boolean getAutorizada() {
        return autorizada;
    }

    /**
     * @return devuelve true si la vacuna ha sido rechazada.
     */
    public boolean getRechazada() {
        return rechazada;
    }

    /**
     * Comprueba el valor de la última fase pasada.
     *
     * @return devuelve la fase y el valor dado.
     */
    public String ultimaFase() {
        String devolver = "";
        if (fasesCompletadas == 1) {
            devolver = ", fase 1: " + fase1;
        }
        if (fasesCompletadas == 2) {
            devolver = ", fase 2: " + fase2;
        }
        if (fasesCompletadas == 3) {
            devolver = ", fase 3: " + fase3;
        }
        return devolver;
    }

}
