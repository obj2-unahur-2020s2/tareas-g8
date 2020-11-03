package ar.edu.unahur.obj2.tareas

class Tarea(
    private val horasEstimadas: Int,
    private val responsable: Empleado,
    private val empleados: MutableList<Empleado>,
    private val costoDeInfraestructura: Int) {

    fun horasNecesarias() = horasEstimadas / empleados.size
    fun costo() = costoDeInfraestructura +
            empleados.sumBy { it.valorHora * this.horasNecesarias() } +
            responsable.valorHora * horasEstimadas
    fun nominaDeEmpleados() = empleados+responsable

}
