# EJERCICIO REPASO 2ª EVALUACIÓN (POO)

## HOTEL SPA COMPLUTUM

Nuestro objetivo es realizar una aplicación para la gestión de reservas del HOTEL SPA COMPLUTUM ****

Debes tener en cuenta que las reservas del Hotel se pueden realizar sobre:
- Habitacion.
- ServicioSPA.

Para un mismo cliente habrá tantas reservas como habitaciones diferentes necesite y como servicios de SPA desee.

Las clases **Habitación y ServicioSPA** deben implementar la interface **Reservable**. Por tanto de cada reserva (habitación o servicio de spa) se podrá calcular el precio de dicha reserva (método calcularPrecioReserva) y obtener la factura de la misma (obtenerFacturaReserva).

### HABITACIÓN

Una  Habitacion tiene los siguientes atributos que la definen:

- cliente: será un objeto de tipo Cliente. Esta clase está definida por la referenciaCliente, nombreApellidos, email y movil.
- numero: número de habitación.
- diaReserva: día de entrada al hotel.
- cantidadNoches: número de noches reservadas.
- tipo: es de tipo enumerado TipoHabitación. 

El **precio de una habitación** se calcula como el total del precio base (50 euros) por el número de días más el extra por el tipo de habitación (TipoHabitación)

### SERVICIO DE SPA

Un ServicioSPA tendrá los siguientes atributos:

- referenciaCliente: es una cadena de texto con la referencia del cliente.
- tipo: es de tipo enumerado TipoSPA.
- diaHoraCita: día y hora del servicio de spa.

El **precio de un servicio de SPA** se obtiene directamente del tipo de servicio (TipoSPA).

### HOTEL

A continuación se describen los métodos que se deben implementar en el Hotel. El nombre de los mismos describen su funcionalidad:

```
1) public ArrayList<Habitacion> obtenerReservasHabitacionOrdenadasDeFormaNatural();

2) public ArrayList<ServicioSPA> obtenerReservasServicioSPAOrdenadosPorReferenciaCliente();

(*) Día y hora de la cita se muestra en formato yyyy/MM/dd hh:mm:ss

3) public ArrayList<Reservable> obtenerReservasPorReferenciaCliente(String referenciaCliente) throws ReferenciaClienteNoEncontradaException;

(*) Si no se encuentra la referencia del cliente se deberá de lanzar una excepción propia (checked) llamada ReferenciaClienteNoEncontradaException, 

capturando la referencia del cliente y el LocalDateTime del momento cuando se produce la excepción.

El mensaje de la excepción será por ejemplo: “Número de referencia KK000001 no encontrada en la fecha 24/02/2023 19:27:41”

4) public ArrayList<Habitacion> obtenerReservasHabitacionPorCliente(Cliente cliente) 

(*)El objeto cliente por el que buscar se considerará igual si coinciden todos sus atributos(referenciaCliente, nombreApellidos, email, movil).

5) public String obtenerFacturaReservaPorPosicion(int posicion);

(*) Observa que día y hora de la cita se muestra en formato yyyy/MM/dd hh:mm:ss

(*) Observa que en la factura de la reserva de una habitación no se muestra el número de días sino la fecha de salida (calculada a partir del día de entrada y el número de noches)



```
