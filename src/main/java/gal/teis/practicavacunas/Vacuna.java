/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicavacunas;

/**
 * Una clase para crear vacunas y mostrar los valores propios de cada una.
 * Extiende de VacunaAutorizacion.
 *
 * @author Lourdes Gonzalez
 */
public class Vacuna extends VacunaAutorizacion {

    protected String codigo;
    protected String nombre;
    protected String principio_activo;
    protected String farmaceutica;
    protected double precio_recomendado;

    /**
     * Constructor vacio
     */
    public Vacuna() {
    }

    /**
     * Constructor vacuna
     */
    public Vacuna(String codigo, String nombre, String principio_activo, String farmaceutica, double precio_recomendado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.principio_activo = principio_activo;
        this.farmaceutica = farmaceutica;
        this.precio_recomendado = precio_recomendado;
    }

    /**
     * Establece el precio
     *
     * param precio contiene el precio introducido
     */
    public void setPrecio(double precio) {
        this.precio_recomendado = precio;
    }

    /**
     * Devuelve el nombre
     *
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el precio
     *
     */
    public double getPrecio() {
        return precio_recomendado;
    }

    /**
     * Devuelve el codigo
     *
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Modifica el hashCode para usar el código como valor.
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result + prime + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    /**
     * Se establecen las posiblidades de equals
     *
     */
    @Override
    public boolean equals(Object obj) {
        Vacuna other = (Vacuna) obj;
        if (codigo == other.codigo) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        if (codigo != other.codigo) {
            return false;
        }
        return true;
    }

    /**
     * Modifica el toString
     *
     * @return si autorizada es true devuelve todos los datos, si rechazada es
     * true, devuelve los seleccionados
     */
    @Override
    public String toString() {

        String datos = "";
        if (this.autorizada) {
            datos = "---------------------------------\n"
                    + " Datos de la vacuna: \n"
                    + "  Código: " + this.codigo + "\n"
                    + "  Nombre: " + this.nombre + "\n"
                    + "  P. Activo: " + this.principio_activo + "\n"
                    + "  Farmacéutica: " + this.farmaceutica + "\n"
                    + "  Precio: " + this.precio_recomendado + "\n"
                    + "  Fecha aceptada: " + this.fechaResultado + "\n"
                    + "---------------------------------\n";
        }
        if (this.rechazada) {
            datos = "---------------------------------\n"
                    + "Datos de la vacuna: \n"
                    + "  Código: " + this.codigo + "\n"
                    + "  Nombre: " + this.nombre + "\n"
                    + "  P. Activo: " + this.principio_activo + "\n"
                    + "  Fecha rechazada: " + this.fechaResultado + "\n"
                    + "---------------------------------\n";
        }
        return datos;
    }

    /**
     * Devuelve todos los datos
     *
     */
    public String toStringDatos() {
        String datos = "";
        datos = "\n"
                + "-Datos de la vacuna: \n"
                + "   Nombre: " + this.nombre + "\n"
                + "   P. Activo: " + this.principio_activo + "\n"
                + "   Farmacéutica: " + this.farmaceutica + "\n"
                + "   Precio: " + this.precio_recomendado + "\n"
                + "---------------------------------\n";

        return datos;
    }

    @Override
    public boolean autorizar() {
        return super.autorizada;
    }

    @Override
    public boolean rechazar() {
        return super.rechazada;
    }

}
