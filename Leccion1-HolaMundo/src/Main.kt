//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    var otroNombre = "Ryan_M"
    var version = 1.0
    var git = "subiendo"
    println("Hello, " + name + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")

        if (i == 2){
            println("Soy 2 y mi nombre es" + otroNombre)

        }else if(i == 3 ){
            otroNombre = "RyanAnderson"
            kotlin.io.println("Ahora soy 3 y soy"+ otroNombre)
        }else if (i == 4){
            otroNombre = "php"
            println("Por fin soy 5, ahora intentare llamarme"+ name)
        }
    }
    version = 2.0
    val howTo = "Operaciones"

    fun sumar2Numeros(a: Int, b: Int) {
        val suma = a + b

        println("La suma es: $suma")
    }
    fun restar2Numeros(a:Int, b:Int){
        val resta = a-b
        println("La resta es: $resta")
    }
    fun multiplicar2Numeros(a:Int, b:Int){
        val multiplicacion = a*b
        println("La multiplicacion es: $multiplicacion")
    }
    fun division2Numeros(a:Int, b:Int){
        val division = a-b
        println("La division es: $division")
    }

    sumar2Numeros(10, 5)
    restar2Numeros(10, 5)
    multiplicar2Numeros(10, 5)
    division2Numeros(10, 5)

    // UPDATE CODELAB 1.2
    println("CodeLab 1.2, vamo alla")

    val primer_valor = 15
    val primer_valor_modificado = primer_valor.toDouble()
    println("El valor convertido es: $primer_valor_modificado")

    val b1: Byte = 1
    //val a1: Int = b1 Error del codeLab
    //val c1: String = b1 Error del CodeLab

    val numberOfFish = 5
    var numberOfPlants = 12
    "I have $numberOfFish fish" + " and $numberOfPlants plants"

    when (numberOfFish) {
        0  -> println("No hay peca'o")
        in 1..39 -> println("Hay alguito ahi!")
        else -> println("Balbaro aquaman!")
    }

    // probando el ? y el ?:

    //si eso
    if(numberOfPlants != null){
        numberOfPlants = numberOfPlants.dec()
    }

    // con ?

    numberOfPlants = numberOfPlants?.dec()

    // con ?:

    numberOfPlants = numberOfPlants?.dec() ?: 0

    val school = listOf("mackerel", "trout", "halibut")
    println(school)

    val myList = mutableListOf("tuna", "salmon", "shark")
    myList.remove("shark")

    val mix = arrayOf("fish", 2)
    val numbers = intArrayOf(1,2,3)

    val numbers3 = intArrayOf(4,5,6)
    val foo2 = numbers3 + numbers
    println(foo2[5])

    var bubbles = 0
    while (bubbles < 50) {
        bubbles++
    }
    println("$bubbles bubbles in the water\n")

    do {
        bubbles--
    } while (bubbles > 50)
    println("$bubbles bubbles in the water\n")

    repeat(2) {
        println("A fish is swimming")
    }
}