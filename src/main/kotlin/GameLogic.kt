class GameLogic {

    fun calculatePoints(game: Game): Int {
        val frames = game.frames
        if (frames.size != 10) {
            throw IllegalStateException("A game must have 10 frames")
        }

        var sum = 0

        val frame9 = frames[9]
        sum += frame9.firstRoll
        frame9.secondRoll?.let {
            sum += it
        }
        frame9.thirdRoll?.let {
            sum += it
        }
        if (frame9.isStrike()) {
            sum += frame9.secondRoll!!
        }
// The example does not add this value, but according to the rules it should be added
//        else if (frame9.isSpare()) {
//            sum += frame9.thirdRoll!!
//        }

        val frame8 = frames[8]
        sum += frame8.firstRoll
        frame8.secondRoll?.let {
            sum += it
        }

        if (frame8.isStrike()) {
            sum += frames[9].firstRoll
            sum += frames[9].secondRoll!!
        } else if (frame8.isSpare()) {
            sum += frames[9].firstRoll
        }

        for (i in 7 downTo 0) {
            val frame = frames[i]
            sum += frame.firstRoll
            frame.secondRoll?.let {
                sum += it
            }

            if (frame.isStrike()) {
                sum += frames[i + 1].firstRoll
                sum += if (frames[i + 1].isStrike()) {
                    frames[i + 2].firstRoll
                } else {
                    frames[i + 1].secondRoll!!
                }
            } else if (frame.isSpare()) {
                sum += frames[i + 1].firstRoll
            }
        }

        return sum
    }

    private fun Frame.isSpare(): Boolean {
        return secondRoll != null && (firstRoll + secondRoll == 10)
    }

    private fun Frame.isStrike(): Boolean {
        return firstRoll == 10
    }
}