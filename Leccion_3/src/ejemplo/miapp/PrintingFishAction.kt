package ejemplo.miapp

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}