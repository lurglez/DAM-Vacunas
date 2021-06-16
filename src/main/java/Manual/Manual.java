/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manual;

/**
 * Una clase para mostrar información básica del programa Vacunas.
 *
 * @author Lourdes Gonzalez
 */
public class Manual {
    
   
    public static void manualVacunas() {
        System.out.println("Bienvenida/o a nuestra nueva aplicación: donde podrá gestionar las posibles vacunas para hacer frente al COVID.\n"
                + "A continuación le explicaremos brevemente como usar dicha aplicación.\n"
                +"\n"
                + "IMPORTANTE: En caso de no haber vacunas introducidas, saltará un mensaje por pantalla avisando de que no se dispone aún de datos.\n"
                + "\n"
                + "Punto 1:\n"
                + "   -Listar todas las vacunas y mostrar todos sus datos-\n"
                + "En este punto se le mostrará la infomación de todas las vacunas añadidas hasta el momento.\n"
                + "Esto incluye:\n"
                + "  -Código\n"
                + "  -Nombre\n"
                + "  -Principio Activo\n"
                + "  -Farmacéutica a la que pertenece\n"
                + "  -Precio\n"
                + "Si el almacén se encuentra vacío se le informará de ello.\n"
                + "\n"
                + "Punto 2:\n"
                + "   -Buscar vacuna-\n"
                + "Para buscar la vacuna de la que desee obtener información, simplemente escriba el código.\n"
                + "Se le facilitará una lista con los códigos disponibles para hacer más rápida y fácil su búsqueda.\n"
                + "En caso de introducir un código erróneo, se le informará por pantalla.\n"
                + "Si el almacén se encuentra vacío se le informará de ello.\n"
                + "\n"
                + "Punto 3:\n"
                + "   -Agregar vacuna-\n"
                + "Para agregar una vacuna, primeramente, le saldrá un mensaje previo donde debe confirmar si desea o no agregar"
                + " una nueva vacuna.\n"
                + "Después de ello, simplemente debe seguir los pasos que se le van indicando en pantalla.\n"
                + "Preste especial atención a la introducción del código. Pueden pasar varias cosas:\n"
                + "   1. El código no tiene el formato requerido.\n"
                + "   2. El código ya forma parte de la base de datos, es decir, la vacuna ya ha sido introducida con anterioridad y ha saltado una excepción.\n"
                + "   3. Ha introducido un código erróneo 3 veces y ha saltado una excepción.\n"
                + "  \n      Ojo, utilice una comilla , para establecer el precio en caso de ser necesario.\n"
                + "\n"
                + "Punto 4:\n"
                + "   -Eliminar vacuna.-\n"
                + "Para eliminar una vacuna simplemente debe de introducir su códido.\n"
                + "Si la vacuna es borrada, se le informará de ello.\n"
                + "Si la vacuna introducida no se encuentra en el almacén se le informará de ello.\n"
                + "Si el almacén se encuentra vacío se le informará de ello.\n"
                + "\n"
                + "Punto 5:\n"
                + "   -Introducir resultado de las fases de la vacuna.-\n"
                + "Para introducir los valores de las fases de cada vacuna debe de tener en cuenta que:\n"
                + "  -Cada fase sólo se podrá pasar una vez. En cuanto inserte el valor conveniente, no será posible cambiarlo.\n"
                + "  -Sólo podrá insertar el valor de la fase 2 si ha pasado previamente la 1 y el valor de la fase 3 si ha introducido el de la 2 (y este ha sido positivo).\n"
                + "  -Una vez una vacuna ha superado de manera positiva las 3 fases, pasa automaticamente a estar disponible para su autorización o rechazo.\n"
                + "  -Sólo podrá seguir introduciendo el valor a las fases de la vacuna si la fase previa ha sido superada.\n"
                + "\n"
                + "Punto 6:\n"
                + "   -Autorizar/Rechazar vacuna.-\n"
                + "Cuando una vacuna ha superado las 3 fases, es aquí donde se puede acceder a la opción de aceptarla o rechazarla definitivamente.\n"
                + "SOLO las vacunas que han pasado las 3 fases llegan a este punto.\n"
                + "Una vez una vacuna ha sido aceptada o rechazada, no será posible volver a rechazarla o aceptarla\n"
                + "Si la vacuna que intenta validar no está disponible para dicha acción, se le informará de ello.\n"
                + "Si el almacén se encuentra vacío se le informará de ello.\n"
                + "\n"
                + "Punto 7:\n"
                + "   -Ver vacunas autorizadas.-\n"
                + "En este apartado se podrá acceder a la lista de vacunas que han sido autorizadas por la EMA.\n"
                + "Si existen vacunas dentro de la base pero no están disponibles para esta acción, aparecerá en pantalla -búsqueda finalizada-\n"
                + "\n"
                + "Punto 8:\n"
                + "   -Ver vacunas rechazadas.-\n"
                + "En este apartado se podrá acceder a la lista de vacunas que han sido rechazadas por la EMA.\n"
                + "Si existen vacunas dentro de la base pero no están disponibles para esta acción, aparecerá en pantalla -búsqueda finalizada-\n"
                + "\n"
                + "Punto 9:\n"
                + "   -Ver vacunas pendientes de autorizar/rechazar.-\n"
                + "En este apartado se dipondrá de la información básica de aquellas vacunas que han superado las 3 fases con resultados"
                + " positivos y que están pendientes de ser revisadas por la EMA.\n"
                + "Si existen vacunas dentro de la base pero no están disponibles para esta acción, aparecerá en pantalla -búsqueda finalizada-\n"
                + "\n"
                + "Punto 10:\n"
                + "   -Ver la última fase investigada de cada vacuna almacenada.-\n"
                + "Aquí podrá comprobar en que nivel se encuentra cada vacuna.\n"
                + "Aparecerá el nombre seguido de la fase y si ésta ha sido pasada o no, para ello en pantalla aparecerá -TRUE- o -FALSE-.)\n"
                + "Si solo aparece el nombre de la vacuna, significará que esa vacuna está dentro de la base de datos pero aún no ha sido sometida a ninguna fase\n");
    }
}
