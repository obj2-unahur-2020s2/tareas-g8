package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class TareaTest : DescribeSpec({
  //*-*-*-*-*-*-*-* Empleados *-*-*-*-*-*-*-*
  val ezePereira = Empleado(500)
  val agusFiorda = Empleado(500)
  val fedeAloi = Empleado(1000)
  val romanGarcia = Empleado(1000)
  //*-*-*-*-*-*-*-* Tareas *-*-*-*-*-*-*-*
  val tarea1 = Tarea(15,romanGarcia, mutableListOf(ezePereira,agusFiorda),1000)
  val tarea2 = Tarea(15,romanGarcia, mutableListOf(ezePereira,agusFiorda),1000)
  val integradora = TareaDeIntegracion(fedeAloi, mutableListOf(tarea1,tarea2))
  describe("Una tarea") {

  it("Nomina de Empleados - deve devoler la lista de empleados + el responsable") {
    tarea1.nominaDeEmpleados().size.shouldBe(3)
  }
  it("Horas para finalizar tarea - como tiene 15 hs y son dos empleados debe dar 7") {
    tarea1.horasNecesarias().shouldBe(7)
    tarea1.horasNecesarias().shouldNotBe(5 )
  }
  it("Costo de una tarea - Segun la cantidad de horas = (7 * 500 * 2) + (15 * 1000) + 1000") {
    tarea1.costo().shouldBe(23000)
    tarea1.costo().shouldNotBe(20000 )
  }
  }
  describe("Tareas de integracion") {
    it("Nomina de Empleados - deve devoler la lista de empleados + el responsable") {
      integradora.nomina().size.shouldBe(7)
      integradora.nomina().size.shouldNotBe(5 )
    }
    it("Horas para finalizar tarea - como tiene 15 hs y son dos empleados debe dar 7") {
      integradora.horasNecesarias().shouldBe(15)
      integradora.horasNecesarias().shouldNotBe(13 )
    }
    it("Costo de una tarea - Son 23000 * 2 + el bonus del 3% = 47380") {
      integradora.costoTotal().shouldBe(47380)
      integradora.costoTotal().shouldNotBe(23000 )
    }
  }
})
