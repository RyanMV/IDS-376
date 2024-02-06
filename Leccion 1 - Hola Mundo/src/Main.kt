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
}