package ejemplo.miapp

fun buildAquarium() {
    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}
fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

    fun main() {
        //buildAquarium()
//        makeFish()
        makeDecorations()
        println(Choice.name)
        Choice.showDescription("pick")
        Choice.showDescription("selection")
//        val twoLists = fish.partition { isFreshWater(it) }
//        println("freshwater: ${twoLists.first}")
//        println("saltwater: ${twoLists.second}")

        val equipment = "fish net" to "catching fish"
        println("${equipment.first} used for ${equipment.second}")

        val (tool, use) = equipment
        println("$tool is used for $use")

        val numbers = Triple(6, 9, 42)
        println(numbers.toString())
        println(numbers.toList())


        val (n1, n2, n3) = numbers
        println("$n1 $n2 $n3")

        val equipment2 = ("fish net" to "catching fish") to "equipment"
        println("${equipment2.first} is ${equipment2.second}\n")
        println("${equipment2.first.second}")

        val list = listOf(1, 5, 3, 4)
        println(list.sum())
//        val list2 = listOf("a", "bbb", "cc")
//        println(list2.sum())

//        val list2 = listOf("a", "bbb", "cc")
//        println(list2.sumBy { it.length })
        val list2 = listOf("a", "bbb", "cc")
        for (s in list2.listIterator()) {
            println("$s ")
        }

        val scientific = hashMapOf("guppy" to "poecilia reticulata", "catfish" to "corydoras", "zebra fish" to "danio rerio" )
        println (scientific.get("guppy"))
        println(scientific.get("zebra fish"))
//        println(scientific.get("swordtail")
//                println(scientific.getOrElse("swordtail") {"sorry, I don't know"})
    }
