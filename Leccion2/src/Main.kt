
import java.util.*

fun main() {
    // Will assign kotlin.Unit
    val testUnidad = println("Esto es una unidad de prueba")
    println(testUnidad)

    val temperatura = 30
    val haceCalor = if(temperatura > 25) "hace mucho calor" else "Se acepta esta temp"
    val mensaje = "Creo que ${if (temperatura > 25)"Hace mucho calor" else "Esta buena la temperatura"}"

    println(haceCalor)
    println(mensaje)

    fun funcionTest(){
        var mensaje = "Mensaje de prueba para la leccion 2"
        println(mensaje)
    }

    funcionTest()

    fun diaAlAzar() : String{
        val semana = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
        return  semana[Random().nextInt(semana.size)]
    }

    fun queComeHoy(dia:String) : String {
        return when (dia){
            "Lunes"->"Chuleta"
            "Martes"->"Pechuga"
            "Miercoles"->"Mulo"
            "Jueves"->"Pecho"
            else -> "De todo"
        }
    }
    fun haceCalor2(temperatura: Int) = temperatura > 30
    fun estaSucio(sucio: Int) = sucio > 30
    fun esDomingo(dia: String) = dia == "Domingo"

    fun sacarAPasear(dia: String, temperatura: Int = 22, sucio: Int = 10) : Boolean {
        return when {
            haceCalor2(temperatura) -> true
            estaSucio(sucio) -> true
            esDomingo(dia) -> true
            else -> false
        }
    }

    fun alimentarPerros(){
        val dia = diaAlAzar()
        val comida = queComeHoy(dia)
        println("Hoy es $dia y el perro come $comida")
        println("Hay que sacarlo a pasear: ${sacarAPasear(dia)}")
    }

    alimentarPerros()

    fun velocidadCanina(velocidad: String = "Rapido"){
        println("El perro es $velocidad")
    }

    velocidadCanina()
    velocidadCanina("Lento")
    velocidadCanina(velocidad = "Veloz")

    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println( decorations.filter {it[0] == 'p'})
    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")

    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    val newList = filtered.toList()
    println("new list: $newList")
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")

    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
    println("-----")
    println("Flat: ${mylist.flatten()}")

    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter))
    fun increaseDirty( start: Int ) = start + 1

    println(updateDirty(15, ::increaseDirty))
    var dirtyLevel = 19
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23}
    println(dirtyLevel)
}