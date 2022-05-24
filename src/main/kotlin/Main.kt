fun main(args: Array<String>) {
    val frames = args
        .map { it.split(",") }
        .map { Frame(
            it[0].toInt(),
            it.getOrNull(1)?.toInt(),
            it.getOrNull(2)?.toInt()
        ) }
    val game = Game(frames)
    val points = GameLogic().calculatePoints(game)
    println(points)
}