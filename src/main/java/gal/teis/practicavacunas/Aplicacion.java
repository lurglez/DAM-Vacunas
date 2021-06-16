/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicavacunas;

import gal.teis.libreriadam.ControlData;
import gal.teis.libreriadam.ExcIntroduccionCodigo;
import Manual.Manual;
import gal.teis.libreriadam.Menu;
import java.time.LocalDate;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lourdes Gonzalez
 */
public class Aplicacion {

    static Scanner sc = new Scanner(System.in);
    static String codigo = "";
    static String nombre;
    static String seleccionvacfases;
    static String seleccionvacfinal = "";
    static String principio_activo;
    static String farmaceutica;

    static int intentos = 0;

    static char contador = 0;
    static char opcion = 0;
    static char decision;

    static double precio_recomendado;

    static boolean correcto = false;
    static boolean cod = false;
    static boolean fases = false;
    static boolean salir = false;

    static ArrayList<Vacuna> lasVacunas = new ArrayList<Vacuna>();
    static HashMap<String, Vacuna> almacen = new HashMap<String, Vacuna>();
    static VacAlmacen al = new VacAlmacen(almacen);

    /**
     *
     */
    public static void main(String[] args) {

        do {
            switch (pintarMenu()) {
                case 1:
                    if (al.hayDatos()) {
                        sinDatos();
                    } else {
                        System.out.println(al.imprimirTodo());
                    }
                    break;
                case 2:
                    if (al.hayDatos()) {
                        sinDatos();
                    } else {
                        buscarVacuna();
                    }
                    break;
                case 3:
                    ingresarVacuna();
                    break;
                case 4:
                    if (al.hayDatos()) {
                        sinDatos();
                    } else {
                        eliminarVacuna();
                    }
                    break;
                case 5:
                    if (al.hayDatos()) {
                        sinDatos();
                    } else {
                        establecerFases();
                    }
                    break;
                case 6:
                    if (al.hayDatos()) {
                        sinDatos();
                    } else {
                        valoracionFinal();
                    }
                    break;
                case 7:
                    if (al.hayDatos()) {
                        sinDatos();
                    } else {
                        System.out.println(al.getAutorizadas());
                        finBusqueda();
                    }
                    break;
                case 8:
                    if (al.hayDatos()) {
                        sinDatos();
                    } else {
                        System.out.println(al.getRechazadas());
                        finBusqueda();
                    }
                    break;
                case 9:
                    if (al.hayDatos()) {
                        sinDatos();
                    } else {
                        System.out.println(al.pendientes());
                        finBusqueda();

                    }
                    break;
                case 10:
                    if (al.hayDatos()) {
                        sinDatos();
                    } else {
                        ultimaFase();
                    }
                    break;
                case 11:
                    Manual.manualVacunas();
                    break;
                case 12:
                    correcto = true;
            }

        } while (!correcto);
        System.out.println("¡Regrese pronto!");
        sc.close();
    }

    static byte pintarMenu() {
        byte opcion;
        boolean correcta;

        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            ArrayList<String> misOpciones = new ArrayList<String>();
            System.out.println("\n\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            misOpciones.add("Listar todas las vacunas y mostrar todos sus datos         *");
            misOpciones.add("Buscar vacuna                                              *");
            misOpciones.add("Agregar vacuna                                             *");
            misOpciones.add("Eliminar vacuna                                            *");
            misOpciones.add("Introducir resultado de las fases de la vacuna             *");
            misOpciones.add("Autorizar/Rechazar vacuna                                  *");
            misOpciones.add("Ver vacunas autorizadas                                    *");
            misOpciones.add("Ver vacunas rechazadas                                     *");
            misOpciones.add("Ver vacunas pendientes de autorizar/rechazar               *");
            misOpciones.add("Ver la última fase investigada de cada vacuna almacenada  *");
            misOpciones.add("Var MANUAL de la aplicación                               *");
            misOpciones.add("Salir de la Aplicación                                    *");

            /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
            Menu miMenu = new Menu(misOpciones);
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            opcion = ControlData.lerByte(sc);
            correcta = miMenu.rango(opcion);

        } while (!correcta);

        return opcion;
    }

    static byte opciones() {
        byte opcion;
        boolean correcta;
        ArrayList<String> misOpciones = new ArrayList<String>();
        /*Se crea un menú estableciendo dos opciones posibles*/
        misOpciones.add("SÍ");
        misOpciones.add("NO");
        Menu miMenu = new Menu(misOpciones);
        miMenu.printMenu();

        /*La clase ControlData permite hacer un control de tipo leído*/
        opcion = ControlData.lerByte(sc);
        correcta = miMenu.rango(opcion);
        return opcion;
    }

    /**
     * Menú que da opción a seleccionar las posibles fases de la vacuna.
     *
     * @return Devuelve la selección del usuario.
     */
    static byte fases() {
        byte opcion;
        boolean correcta;
        ArrayList<String> misOpciones = new ArrayList<String>();
        /*Se crea un menú estableciendo las fases de la vacuna*/
        misOpciones.add("PRIMERA");
        misOpciones.add("SEGUNDA");
        misOpciones.add("TERCERA");
        misOpciones.add("SALIR");
        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);
        miMenu.printMenu();

        /*La clase ControlData permite hacer un control de tipo leído*/
        opcion = ControlData.lerByte(sc);
        correcta = miMenu.rango(opcion);

        return opcion;
    }

    /**
     * Indica que no hay datos de vacunas almacenados hasta el momento.
     */
    static void sinDatos() {
        System.out.println("No hay datos almacenados hasta el momento.Pruebe a agregar los datos de una vacuna.");
    }

    /**
     * Indica que no se ha podido encontrar el valor introducido dentro del
     * HashMap.
     */
    static void busquedaTerminada() {
        System.out.println("La búsqueda ha terminado. El código no se correspondía con ninguna vacuna en nuestra base.");
    }

    /**
     * Indica que la vacuna ha superado la fase correspondiente.
     */
    static void pasoFase() {
        System.out.println("La Vacuna ha superado la  fase.\n"
                + "--------------------");
    }

    /**
     * Indica que la vacuna no ha superado la fase correspondiente.
     */
    static void noPasoFase() {
        System.out.println("La Vacuna NO ha superado la fase.\n"
                + "--------------------");

    }

    static void finBusqueda() {
        System.out.println("Búsqueda finalizada");
    }

    /**
     * @Return Devuelve una cadena de guiones para establecer una separación.
     */
    static void separacion() {
        System.out.println("--------------------");
    }

    /**
     * @Return Devuelve las pautas a seguir para introducir el código de la
     * vacuna.
     */
    static void pautas() {
        System.out.println(" -Primera letra: V.\n"
                + " -Segunda letra: Vocal mayúscula.\n"
                + " -3/4 siguientes letras: Minúsculas.\n"
                + " -2 siguientes números: Entre el 4 y el 7.\n");
    }

    /**
     * Busca una vacuna dentro del "almacen".
     *
     * @Return Devuelve los datos de la vacuna buscada.
     */
    static void buscarVacuna() {
        /*Informamos por pantalla de las vacunas disponibles*/
        System.out.println(al.imprimirCod());
        System.out.println("Ingrese el código de la vacuna que desea buscar. Arriba se le muestran los disponibles.");
        codigo = ControlData.lerString(sc);
        /*Recorremos las lista buscando coincidencias*/
 /*Monstramos la vacuna seleccionada, o un mensaje que advierte de que la vacuna no se encuentra agregada*/
        separacion();
        System.out.println(al.buscarVacuna(codigo));

    }

    /**
     * Se crea una vacuna solicitando todos los datos necesarios para ello.
     */
    static void datos() {
        /*Solicitamos nombre*/
        System.out.println("Ingrese el nombre de la Vacuna:");
        nombre = ControlData.lerNome(sc);
        /*Solicitamos farmaceutica*/
        System.out.println("A continuación debe ingresar la farmacéutica a la que pertenece:");
        farmaceutica = ControlData.lerString(sc);
        /*Solicitamos principio activo*/
        System.out.println("¿Cuál es el principio activo de la vacuna a ingresar?:");
        principio_activo = ControlData.lerString(sc);
        /*Solicitamos precio*/
        System.out.println("Ingrese el precio recomendado:");
        precio_recomendado = ControlData.lerDouble(sc);

        /*Creamos la vacuna y la añadimos a un arraylist*/
        Vacuna vacuna = new Vacuna(codigo, nombre, principio_activo, farmaceutica, precio_recomendado);
        lasVacunas.add(vacuna);
        /*Añadimos la vacuna al hashmap de la clase vacAlmacen*/
        al.setVacuna(codigo, vacuna);

        /*Informamos de que la vacuna se ha creado, enseñando el nombre de la misma*/
        System.out.println("Acaba de añadir la vacuna: " + vacuna.getNombre());
    }

    /**
     * Fase previa a la creación de la vacuna. Se establece el código y se
     * indica si es correcto.
     *
     * @Return Puede devolver dos tipos de excepciones (máximo de intentos o
     * vacuna repetida).
     */
    static void ingresarVacuna() {
        /*Opción de agregar una nueva vacuna a la lista*/
        System.out.println("A continuación, va a agregar una vacuna a nuestra base de datos.");
        /*Preguntamos si de verdad se desea añadir una vacuna*/
        System.out.println("¿Desea seguir adelante? Señale la opción deseada:");
        /*Imprimimos por pantalla las opciones SI y NO para facilitar la interacción programa-usuario*/
        switch (opciones()) {
            case 1:
             /*Entramos en un bucle, del cual no se sale hasta que el usuario introduzca un código correcto o hasta que salte la excepción*/
            try {
                do {
                    System.out.println("¿Cuál es su código? Recuerde que el código debe de seguir unas pautas:");
                    /*Imprimimos las pautas para la introducción del código*/
                    pautas();
                    codigo = ControlData.lerString(sc);
                    /*Establecemos las condiciones*/
                    Pattern pat = Pattern.compile("[V][AEIOU][a-z]{3,4}([4-7]{2}|[8])");
                    Matcher mat = pat.matcher(codigo);
                    if (mat.matches()) {
                        if (!al.repetida(codigo)) {
                            System.out.println("Código válido.");
                            /*Cambiamos el valor del boolean, salimos del bucle*/
                            cod = true;
                        } else {
                            /*Si la vacuna existiese, saltaría una excepción*/
                            System.out.println("La vacuna ya existe.");
                            throw new ExcIntroduccionCodigo(codigo);
                        }
                    } else {
                        /*Se informa que el código introducido no es válido*/
                        System.out.println("Código no válido.");
                        /*Contador de intentos aumenta, al llegar a 3 salta excepción*/
                        intentos++;
                        cod = false;
                        if (intentos == 3) {
                            /*Excepción por sobrepasar los intentos permitidos*/
                            throw new ExcIntroduccionCodigo(3);
                        }
                    }
                } while (!cod);
                /*Completamos los demás datos*/
                datos();
                /*Se recoge la excepción*/
            } catch (ExcIntroduccionCodigo e) {
                System.out.println(e.getMessage());
            }
            intentos = 0;
            break;
            case 2:
                /*En el caso de haberse equivocado en la selección, volvemos al menú principal*/
                System.out.println("Regresando al menú principal >>>>> ");
                break;
        }
    }

    /**
     * Se elimina una vacuna, para ello se introduce el código de ésta.
     *
     * @Return Indica si la vacuna ha sido eliminada o si no existía en el
     * almacén.
     */
    static void eliminarVacuna() {
        /*Procedemos a eliminar una vacuna de las creadas*/
        System.out.println("A continuación, va a eliminar una vacuna de la base de datos.");
        /*Una vez más, confirmamos que se desea eliminar una vacuna, para ello imprimimos las opciones por pantalla*/
        System.out.println("¿Desea seguir adelante? Señale la opción deseada:");
        switch (opciones()) {
            case 1:
                /*Solicitamos el código de la vacuna a eliminar*/
                System.out.println("Ingrese el código de la vacuna que desea eliminar:");
                nombre = ControlData.lerString(sc);
                /*La buscamos*/
                if (al.borrarVacuna(nombre)) {
                    /*Informamos de que se ha borrado la vacuna*/
                    System.out.println("La vacuna ha sido eliminada.");
                } else {
                    /*En caso de no encontrarse el código introducido, se informa por pantalla*/
                    busquedaTerminada();
                }
                break;
            case 2:
                System.out.println("Regresando al menú principal >>>>> ");
                break;
        }
    }

    /**
     * Se establecen las 3 fases de las vacunas. Se utiliza un menú para
     * seleccionar la fase deseada.+ Se utiliza "S" para aceptar la fase.
     * Cualquier otra letra para rechazarla.+ Se sale del menú seleccionando la
     * opción salir.
     */
    static void establecerFases() {
        do {
            /*Solicitamos introducir el resultado de las fases de las vacunas creadas*/
            System.out.println("¿De qué vacuna desea introducir los resultados de fase? -Introduzca su CÓDIGO-");
            /*Imprimimos por pantalla los códigos de las vacunas creadas hasta el momento*/
            System.out.println(al.imprimirCod());
            separacion();
            seleccionvacfases = ControlData.lerString(sc);
            for (Vacuna aux : lasVacunas) {
                try {
                    if (al.seleccionarVacuna(seleccionvacfases) && aux.getCodigo().equals(seleccionvacfases)) {
                        separacion();
                        System.out.println("Vacuna seleccionada.");
                        separacion();
                        System.out.println("Seleccione de que fase desea introducir el resultado: ");
                        /*Abrimos bucle del que se sale cuando se selecciona la opción correspondiente*/
                        do {
                            fases = false;
                            /*Imprimimos menú de fases*/
                            switch (fases()) {
                                case 1:
                                    /*Comprobamos que la fase no ha sido pasada previamente*/
                                    if (aux.fasesCompletadas() == 0) {
                                        System.out.println("¿Pasó la fase 1? Marque la letra (S) en caso afirmativo, o cualquier otra en caso negativo");
                                        opcion = ControlData.lerChar(sc);
                                        /*Si la vacuna ha pasado la fase 1*/
                                        if (al.pasarFase1(seleccionvacfases, opcion, fases)) {
                                            al.setFase1(seleccionvacfases, opcion);
                                            pasoFase();
                                            /*Si la vacuna no ha pasado la fase 1*/
                                        } else {
                                            al.setFase1(seleccionvacfases, opcion);
                                            noPasoFase();
                                        }
                                    } else {
                                        /*Si la vacuna ya ha pasado esta fase, informamos de ello*/
                                        System.out.println("Esta fase ya ha sido establecida previamente.");
                                        /*Indicamos también el resultado que tiene la fase*/
                                        if (aux.getFase1()) {
                                            System.out.println("El resultado establecido fue: FASE 1 SUPERADA.");
                                        } else {
                                            System.out.println("El resultado establecido fue: FASE 1 NO SUPERADA. ");
                                        }
                                        separacion();
                                    }
                                    break;
                                case 2:
                                    /*Comprobamos que la fase no ha sido pasada previamente*/
                                    if (aux.fasesCompletadas() == 1 && aux.getFase1()) {
                                        System.out.println("¿Pasó la fase 2? Marque la letra (S) en caso afirmativo, o cualquier otra en caso negativo");
                                        opcion = ControlData.lerChar(sc);
                                        /*Si la vacuna ha pasado la fase 2*/
                                        if (al.pasarFase2(seleccionvacfases, opcion, fases)) {
                                            al.setFase2(seleccionvacfases, opcion);
                                            pasoFase();
                                            /*Si la vacuna no ha pasado la fase 2*/
                                        } else {
                                            al.setFase2(seleccionvacfases, opcion);
                                            noPasoFase();
                                        }
                                        /*Si la vacuna ya ha pasado esta fase o necesita que se pase una fase anterior para acceder, informamos de ello*/
                                    } else if (aux.fasesCompletadas() == 2 || aux.fasesCompletadas() == 3 || !aux.getFase1()) {
                                        System.out.println("No puede establecer la fase 2 en estos momentos.");
                                        if (aux.getFase2()) {
                                            System.out.println("El resultado establecido previamente fue: FASE 2 SUPERADA.");
                                        } else if (!aux.getFase2() && aux.fasesCompletadas() == 2) {
                                            System.out.println("El resultado establecido fue: FASE 2 NO SUPERADA. ");
                                        } else {
                                            System.out.println("La vacuna debe superar las fases anteriores.");
                                        }
                                        separacion();
                                    }
                                    break;
                                case 3:
                                    /*Comprobamos que la fase no ha sido pasada previamente*/
                                    if (aux.fasesCompletadas() == 2 && aux.getFase2()) {
                                        System.out.println("¿Pasó la fase 3? Marque la letra (S) en caso afirmativo, o cualquier otra en caso negativo");
                                        opcion = ControlData.lerChar(sc);
                                        /*Si la vacuna ha pasado la fase 3*/
                                        if (al.pasarFase3(seleccionvacfases, opcion, fases)) {
                                            al.setFase3(seleccionvacfases, opcion);
                                            pasoFase();
                                            /*Indicamos que todas las fases han sido pasadas de manera positiva*/
                                            System.out.println("\n¡Todas las fases han sido completadas satisfactoriamente!\n");
                                            /*Si la vacuna no ha pasado la fase 3*/
                                        } else {
                                            al.setFase3(seleccionvacfases, opcion);
                                            noPasoFase();
                                        }
                                        /*Si la vacuna ya ha pasado esta fase o necesita que se pase una fase anterior para acceder, informamos de ello*/
                                    } else if (aux.fasesCompletadas() == 3 || !aux.getFase2()) {
                                        System.out.println("No puede establecer la fase 3 en estos momentos.");
                                        if (aux.getFase3() == true) {
                                            System.out.println("El resultado establecido previamente fue: FASE 3 SUPERADA. ");
                                        } else if (!aux.getFase3() && aux.fasesCompletadas() == 3) {
                                            System.out.println("El resultado establecido fue: FASE 3 NO SUPERADA. ");
                                        } else {
                                            System.out.println("La vacuna  debe superar las fases anteriores.");
                                        }
                                        separacion();
                                    }
                                    break;
                                case 4:
                                    System.out.println("Regresando al menú principal >>>>> ");
                                    fases = true;
                                    salir = true;
                                    break;
                            }
                        } while (!fases);
                    } 
                } catch (Exception e) {
                    /*Si la vacuna no se encuentra registrada*/
                    busquedaTerminada();
                    /*Salimos del bucle*/
                    salir = true;
                }
            }
             
        } while (!salir);
    }

    /**
     * Da la opción de aceptar o rechazar una vacuna.+ Una vez aceptada o
     * rechaza no se puede volver a realizar este paso.+ Imprime los códigos de
     * las vacunas dentro del almacén+ Si la vacuna no está disponible para su
     * autorización/rechazo lo indicará cuando se seleccione.
     */
    static void valoracionFinal() {
        System.out.println("¿Qué vacuna desea ACEPTAR/RECHAZAR?-Introduzca su CÓDIGO-");
        separacion();
        System.out.println("Las siguientes vacunas están dentro de nuestra base, pueden \n"
                + "no estar disponibles para su autorizción:");
        separacion();
        /*Imprimimos los códigos de las vacunas en la base de datos*/
        /*De TODAS las vacunas, estén o no listas para autorizar*/
        /*En caso de que no haya superado las fases para poder ser aceptada/rechazada, se informará por pantalla 
        una vez seleccionada*/
        System.out.println(al.imprimirCod());
        seleccionvacfinal = ControlData.lerString(sc);
        /*SSi la vacuna no existe, se informa*/
        if (!al.existe(seleccionvacfinal)) {
            System.out.println("La vacuna a la que intenta acceder no está en nuestra base de datos.");
        } else {
            /*Si la vacuna no está disponible para este paso, se informa*/
            if (!al.disponible(seleccionvacfinal)) {
                System.out.println("Esta vacuna no está disponible para su autorización.");
            } else {
                separacion();
                System.out.println("Vacuna seleccionada.");
                separacion();
                System.out.println("¿Va a autorizar el uso de esta vacuna? Marque la letra (S) en caso afirmativo, o cualquier otra en caso negativo");
                decision = ControlData.lerChar(sc);
                /*Damos el valor correspondiente a la vacuna e inforamamos de ello por pantalla*/
                if (al.autorizar(seleccionvacfinal, decision) || !al.rechazar(seleccionvacfinal, decision)) {
                    System.out.println("¡La Vacuna ha sido AUTORIZADA! Esta asignación se ha realizado en la fecha de:");
                    /*Se imprime la fecha en la que ha sido autorizada*/
                    System.out.println(al.getFechaResultado(seleccionvacfinal));
                    separacion();

                } else {
                    System.out.println("La Vacuna NO ha sido autorizada. Esta asignación se ha realizado en la fecha de:");
                    /*Se imprime la fecha en la que no ha sido autorizada*/
                    System.out.println(al.getFechaResultado(seleccionvacfinal));
                    separacion();
                }
            }
        }
    }

    /**
     * Imprime el nombre y el valor de la última fase establecida de cada
     * vacuna.
     */
    static void ultimaFase() {
        System.out.println("A continuación se devolverá el último resultado de todas las vacunas agregadas a la base\n");
        separacion();
        System.out.println("TRUE=ACEPTADA // FALSE=RECHAZADA // SOLO NOMBRE=NO SE HA SOMETIDO A NINGUNA FASE");
        separacion();
        /*Mostramos el nombre y el valor de la última fase superada de cada vacuna*/
        System.out.println(al.mostrarUltima());
    }
}
