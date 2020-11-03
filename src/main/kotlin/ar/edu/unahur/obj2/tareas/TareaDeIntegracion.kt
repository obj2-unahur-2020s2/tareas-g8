package ar.edu.unahur.obj2.tareas

class TareaDeIntegracion(
    private var responsable: Empleado,
    private var tareasCoordinadas: MutableList<Tarea>) {

    private fun bonusResponsable() = tareasCoordinadas.sumBy { it.costo() } * .03
    private fun cantidadReuniones() = tareasCoordinadas.sumBy { it.horasNecesarias() } / 8
    fun horasNecesarias() = tareasCoordinadas.sumBy { it.horasNecesarias() } +
            this.cantidadReuniones()

    fun costoTotal() = tareasCoordinadas.sumBy { it.costo() } + bonusResponsable()
    fun nomina(): List<Empleado> {
        val subConjunto = mutableListOf<Empleado>()
        tareasCoordinadas.forEach {  subConjunto += it.nominaDeEmpleados() }
        subConjunto += responsable
        return subConjunto

    }
}