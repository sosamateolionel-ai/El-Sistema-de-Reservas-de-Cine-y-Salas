# Sistema de Reservas de Cine

## Descripción

Este proyecto consiste en un sistema de reservas de butacas para una sala de cine. Permite consultar la disponibilidad de los asientos, reservar varias butacas en una misma operación y emitir tickets cuando la reserva se realiza correctamente.

El sistema valida que todas las butacas solicitadas existan y estén disponibles antes de bloquearlas. Si alguna no existe o ya está ocupada, se cancela la reserva completa sin modificar las demás butacas.

## Funcionamiento

1. Se crea la sala de cine con tres filas y cinco butacas por fila.
2. Se inicializan todas las butacas como disponibles.
3. Se muestra el estado inicial de la sala.
4. Ana solicita las butacas A2, A3 y A4. Como están disponibles, se bloquean y se emiten los tickets correspondientes.
5. Martín solicita las butacas A4 y B1. Como A4 ya está ocupada, se rechaza la reserva completa.
6. Se muestra nuevamente el estado de la sala para comprobar qué butacas quedaron ocupadas.

## Clase `Butaca`

Representa una butaca individual dentro de la sala.

### Atributos

* `fila`: identifica la fila de la butaca.
* `numero`: indica el número de asiento.
* `ocupada`: determina si la butaca está ocupada o disponible.

### Métodos principales

* `getFila()`: devuelve la fila.
* `getNumero()`: devuelve el número de asiento.
* `isOcupada()`: indica si la butaca está ocupada.
* `setOcupada(boolean ocupada)`: modifica el estado de ocupación.
* `getCodigo()`: genera el código identificador de la butaca, por ejemplo, `A3`.

Todas las butacas comienzan disponibles.

## Clase `SalaCine`

Representa una sala de cine que administra sus butacas.

### Atributos

* `nombre`: nombre de la sala.
* `butacasPorFila`: cantidad de butacas por fila.
* `butacas`: lista que almacena todas las butacas de la sala.

### Métodos principales

* `buscarButaca(String codigo)`: busca una butaca por su código. Es un método privado de uso interno.
* `bloquearButacas(List<String> codigosButacas)`: valida que todas las butacas solicitadas existan y estén disponibles. Si la validación es correcta, las bloquea y devuelve `true`; de lo contrario, devuelve `false`.
* `mostrarEstado()`: muestra la distribución de las butacas y señala cuáles están ocupadas.

La validación se realiza en dos recorridos: primero se comprueban todas las butacas y después se bloquean. Esto evita que una reserva rechazada deje algunas butacas bloqueadas parcialmente.

## Clase `PlataformaReserva`

Se encarga de gestionar las solicitudes de los usuarios y comunicarse con la sala.

### Atributos

* `sala`: referencia al objeto `SalaCine` en el que se realizan las reservas.

### Métodos principales

* `reservar(String usuario, List<String> codigosButacas)`: envía la solicitud a la sala y comprueba el resultado.
* Si la reserva es exitosa, emite un ticket por cada butaca reservada.
* Si la reserva falla, informa que no se pudo completar.

La plataforma delega la validación de disponibilidad a `SalaCine`.

## Ejemplo de funcionamiento

La sala se crea con 3 filas y 5 butacas por fila, identificadas desde A1 hasta C5.

**Primera reserva: Ana**

* Solicita A2, A3 y A4.
* Las tres butacas están disponibles.
* La reserva se completa correctamente y se emiten tres tickets.

**Segunda reserva: Martín**

* Solicita A4 y B1.
* La butaca A4 ya está ocupada.
* La reserva se cancela y B1 permanece disponible.

Al finalizar, las únicas butacas ocupadas son A2, A3 y A4.

## Conceptos de programación utilizados

* **Programación orientada a objetos (POO):** organización del sistema mediante clases y objetos.
* **Encapsulamiento:** atributos privados y métodos públicos para acceder o modificar información.
* **Asociación entre clases:** `PlataformaReserva` mantiene una referencia a `SalaCine`.
* **Colecciones:** uso de `ArrayList` y `List` para almacenar las butacas.
* **Bucles `for`:** generación, búsqueda y recorrido de las butacas.
* **Condicionales:** validación de disponibilidad y existencia.
* **Valores booleanos:** comunicación del resultado de la reserva.
* **Validación previa:** comprobación de todas las butacas antes de modificar su estado.
* **`Arrays.asList()`:** creación de listas de códigos de butacas para las solicitudes.

## Tecnologías utilizadas

* Lenguaje: Java.
* Entorno de desarrollo recomendado: IntelliJ IDEA.

## Ejecución

<img width="945" height="632" alt="image" src="https://github.com/user-attachments/assets/4bd3dc95-7cd9-4127-b52b-c224d427f650" />
