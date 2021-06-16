/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicavacunas;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Una clase para almacenar las vacunas creadas y gestionarlas. Posee los
 * métodos necesarios para ejecutar las distintas operaciones del menú que se
 * mustra en la clase Aplicación
 *
 * @author Lourdes Gonzalez
 */
public class VacAlmacen {

    HashMap<String, Vacuna> almacen = new HashMap<String, Vacuna>();

    public VacAlmacen(HashMap<String, Vacuna> almacen) {

    }

    /**
     * Recorre el HashMap e imprime los datos de las vacunas almacenadas.
     * Recurre al método toStringDatos de la clase Vacuna.
     *
     * @return el código identificativo y los datos de las vacunas almacenadas.
     */
    public String imprimirTodo() {
        Iterator<String> iterator = almacen.keySet().iterator();
        String imprimir = "";
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("-Código: " + key + " " + almacen.get(key).toStringDatos());
        }
        return imprimir;
    }

    /**
     * Recorre el HashMap e imprime los códigos de las vacunas almacenadas.
     *
     * @return el código identificativo de las vacunas almacenadas.
     */
    public String imprimirCod() {
        Iterator<String> iterator = almacen.keySet().iterator();
        String imprimir = "";
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("-Código: " + key);
        }
        return imprimir;
    }

    /**
     * Busca coincidencias entre el código introducido por teclado y el almacén.
     * Recurre al método toStringDatos de la clase Vacuna.
     *
     * @return los datos de la vacuna solicitada, en caso de encontrarla o un
     * mensaje que avisa de que no se ha encontrado.
     */
    public String buscarVacuna(String codigo) {
        String imprimir = "";
        if (almacen.containsKey(codigo)) {
            imprimir = almacen.get(codigo).toStringDatos();
        } else {
            imprimir = busquedaTerminada();
        }
        return imprimir;
    }

    /**
     * Guarda la vacuna creada.
     */
    public void setVacuna(String codigo, Vacuna Vacuna) {
        almacen.put(codigo, Vacuna);
    }

    /**
     * Indica si una vacuna ya existe en el almacén.
     *
     * @return true si el código ya existe, false si el código no existe.
     */
    public boolean repetida(String codigo) {
        boolean repe = false;
        for (String key : almacen.keySet()) {
            if (key.equals(codigo)) {
                repe = true;
            } else {
                repe = false;
            }
        }
        return repe;
    }

    /**
     * Borra la vacuna solicitada.
     *
     * @return true en caso de haber borrado la vacuna, false si la vacuna no se
     * encontraba en el almacén.
     */
    public boolean borrarVacuna(String nombre) {
        boolean borrado = false;
        if (almacen.containsKey(nombre)) {
            almacen.remove(nombre);
            borrado = true;
        }
        return borrado;
    }

    /**
     * Indica si una vacuna se encuentra o no en el almacén.
     *
     * @return true en caso de haber encontrado la vacuna, false si la vacuna no
     * se encontraba en el almacén.
     */
    public boolean seleccionarVacuna(String seleccionvacfases) {
        boolean seleccionada = false;
        if (almacen.containsKey(seleccionvacfases)) {
            seleccionada = true;
        }
        return seleccionada;
    }

    /**
     * Da el valor indicado a la FASE1. param opcion es el valor dado por
     * teclado a la fase.
     *
     * @return true en caso de haber superado la fase, false si no la ha
     * superado.
     */
    public boolean pasarFase1(String seleccionvacfases, char opcion, boolean fase1Superada) {
        for (String key : almacen.keySet()) {
            if (key.equals(seleccionvacfases)) {
                if (almacen.get(key).fase1Superada(opcion)) {
                    fase1Superada = true;
                } else {
                    fase1Superada = false;
                }
            }
        }
        return fase1Superada;
    }

    /**
     * Da el valor indicado a la FASE2. param opcion es el valor dado por
     * teclado a la fase.
     *
     * @return true en caso de haber superado la fase, false si no la ha
     * superado.
     */
    public boolean pasarFase2(String seleccionvacfases, char opcion, boolean fase2Superada) {

        for (String key : almacen.keySet()) {
            if (key.equals(seleccionvacfases)) {
                if (almacen.get(key).fase2Superada(opcion)) {
                    fase2Superada = true;
                } else {
                    fase2Superada = false;
                }
            }
        }
        return fase2Superada;
    }

    /**
     * Da el valor indicado a la FASE3.
     *
     * param opcion es el valor dado por teclado a la fase.
     *
     * @return true en caso de haber superado la fase, false si no la ha
     * superado.
     */
    public boolean pasarFase3(String seleccionvacfases, char opcion, boolean fase3Superada) {
        for (String key : almacen.keySet()) {
            if (key.equals(seleccionvacfases)) {
                if (almacen.get(key).fase3Superada(opcion)) {
                    fase3Superada = true;
                } else {
                    fase3Superada = false;
                }
            }
        }
        return fase3Superada;
    }

    /**
     * Comprueba si la vacuna no está disponible para ser aceptada. Recurre a
     * VacunaAlmacen para comprobar los datos.
     *
     * @return true en caso de cumplir los requisitos, false si no los cumple.
     */
    public boolean disponible(String seleccionvacfinal) {
        boolean disponible = false;
        if (almacen.containsKey(seleccionvacfinal)
                && almacen.get(seleccionvacfinal).fasesCompletadas() < 3
                || !almacen.get(seleccionvacfinal).getFase3()) {
            disponible = false;
        } else if (almacen.get(seleccionvacfinal).getAutorizada()
                || almacen.get(seleccionvacfinal).getRechazada()) {
            disponible = false;
        } else {
            disponible = true;
        }
        return disponible;
    }

    /**
     * Autoriza la vacuna.
     *
     * param decision recoge el resultado indicado.
     *
     * @return true si la vacuna ha sido aceptada.
     */
    public boolean autorizar(String seleccionvacfinal, char decision) {
        boolean aceptada = false;
        for (String key : almacen.keySet()) {
            if (key.equals(seleccionvacfinal)) {
                if (almacen.get(key).autorizar(decision)) {
                    aceptada = true;
                } else {
                    aceptada = false;
                }
            }
        }
        return aceptada;
    }

    /**
     * Rechaza la vac.
     *
     * param decision recoge el resultado indicado.
     *
     * @return true si la vacuna ha sido rechazada.
     */
    public boolean rechazar(String seleccionvacfinal, char decision) {
        boolean rechazada = false;
        for (String key : almacen.keySet()) {
            if (key.equals(seleccionvacfinal)) {
                if (almacen.get(key).rechazar(decision)) {
                    rechazada = true;
                } else {
                    rechazada = false;
                }
            }
        }
        return rechazada;
    }

    /**
     * Busca las vacunas que han sido autorizadas. Recurre al valor de
     * Autorizada en VacunaAutorizacion.
     *
     *
     * @return imprime los datos de las vacunas que han sido autorizadas.
     */
    public String getAutorizadas() {
        Iterator<String> iterator = almacen.keySet().iterator();
        String imprimir = "";
        for (String key : almacen.keySet()) {
            if (almacen.get(key).getAutorizada()) {
                System.out.println(almacen.get(key).toString());
            } else {
            }
        }
        return imprimir;
    }

    /**
     * Busca las vacunas que han sido rechazadas. Recurre al valor de Rechazada
     * en VacunaAutorizacion.
     *
     *
     * @return imprime los datos de las vacunas que han sido rechazadas.
     */
    public String getRechazadas() {
        Iterator<String> iterator = almacen.keySet().iterator();
        String imprimir = "";
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (almacen.get(key).getRechazada()) {
                System.out.println(almacen.get(key).toString());
            } else {
            }
        }
        return imprimir;
    }

    /**
     * Comprueba si la vacuna tiene los valores adecuados para poder ser
     * aceptada o rechada por la EMA. Recurre a VacunaAlmacen para comprobar los
     * datos.
     *
     * @return El código de las vacunas que cumplen los requisitos.
     */
    public String pendientes() {
        Iterator<String> iterator = almacen.keySet().iterator();
        String imprimir = "";
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (almacen.get(key).getFase3()
                    && !almacen.get(key).getAutorizada()
                    && !almacen.get(key).getRechazada()) {
                System.out.println("-Código: " + key + ", Nombre: " + almacen.get(key).getNombre());
            } else {
            }
        }
        return imprimir;
    }

    /**
     * Comprueba que existen vacunas almacenadas
     *
     * @return true en caso de que el almacén esté vacío, false si existen
     * vacunas registradas.
     */
    public boolean hayDatos() {
        boolean sindatos = false;
        if (almacen.isEmpty()) {
            sindatos = true;
        } else {
            sindatos = false;
        }
        return sindatos;
    }

    /**
     * Muestra la vacuna con el valor de la última fase a la que ha sido
     * sometida. Recurre a VacunaAlmacen para comprobar los datos.
     *
     * @return el nombre y el valor de la última fase pasada de la vacuna.
     */
    public String mostrarUltima() {
        String imprimir = "";
        Iterator<String> iterator = almacen.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(almacen.get(key).getNombre() + " " + almacen.get(key).ultimaFase());
        }
        return imprimir;
    }

    /**
     * Recoge el total de fases a las que se han sometido las vacunas.
     *
     * @return el número de fases recorridas.
     */
    public byte fasesCompletadas(String seleccionvacfases) {
        byte imprimir = 0;
        for (String key : almacen.keySet()) {
            if (key.equals(seleccionvacfases)) {
                imprimir = almacen.get(key).fasesCompletadas();
            }
        }
        return imprimir;
    }

    /**
     * Recoge y asigna el valor dado a la fase1.
     *
     * @param opcion recoge el resultado indicado.
     *
     */
    public void setFase1(String seleccionvacfases, char opcion) {
        for (String key : almacen.keySet()) {
            if (key.equals(seleccionvacfases)) {
                if (Character.toUpperCase(opcion) == 'S') {
                    almacen.get(key).fase1 = true;
                } else {
                    almacen.get(key).fase1 = false;
                }
            }
        }
    }

    /**
     * Recoge y asigna el valor dado a la fase2.
     *
     * @param opcion recoge el resultado indicado.
     *
     */
    public void setFase2(String seleccionvacfases, char opcion) {
        for (String key : almacen.keySet()) {
            if (key.equals(seleccionvacfases)) {
                if (Character.toUpperCase(opcion) == 'S') {
                    almacen.get(key).fase2 = true;
                } else {
                    almacen.get(key).fase2 = false;
                }
            }
        }
    }

    /**
     * Recoge y asigna el valor dado a la fase3.
     *
     * @param opcion recoge el resultado indicado.
     *
     */
    public void setFase3(String seleccionvacfases, char opcion) {
        for (String key : almacen.keySet()) {
            if (key.equals(seleccionvacfases)) {
                if (Character.toUpperCase(opcion) == 'S') {
                    almacen.get(key).fase3 = true;
                } else {
                    almacen.get(key).fase3 = false;
                }
            }
        }
    }

    /**
     * Indica si una vacuna se encuentra o no en el almacén.
     *
     * @return true en caso de haber encontrado la vacuna, false si la vacuna no
     * se encontraba en el almacén.
     */
    public boolean existe(String seleccionvacfinal) {
        boolean seleccionada = false;
        if (almacen.containsKey(seleccionvacfinal)) {
            seleccionada = true;
        } else {
            seleccionada = false;
        }
        return seleccionada;
    }
    
    /**
     * Recoge la fecha en la que una vacuna ha sido autorizada o rechazada.
     *
     * @return la fecha de autorización/rechazo
     */
    public String getFechaResultado(String seleccionvacfinal){
        String imprimir="";
        for (String key : almacen.keySet()) {
            if (key.equals(seleccionvacfinal)) {
            System.out.println(almacen.get(key).fechaResultado());
                }      
             } 
        return imprimir;
    }

    static String busquedaTerminada() {
        String datos = "";
        datos = "La búsqueda ha terminado. El código no se correspondía con ninguna vacuna en nuestra base.";
        return datos;
    }
}
