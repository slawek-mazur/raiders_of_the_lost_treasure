package io.stricte.interviews.tigadevs

import static com.google.common.base.Preconditions.checkArgument
import static java.util.Objects.nonNull

class TreasureMap {

    private final Clue[][] clues = new Clue[5][5]

    void addClue(int x, int y, Clue clue) {
        checkArgument(x >= 1 && x <= 5, "x needs to be between 1 and 5 inclusively")
        checkArgument(y >= 1 && y <= 5, "y needs to be between 1 and 5 inclusively")
        checkArgument(nonNull(clue), "clue is required")

        clues[x - 1][y - 1] = clue
    }

    Clue clueAt(int x, int y) {
        checkArgument(x >= 1 && x <= 5, "x needs to be between 1 and 5 inclusively")
        checkArgument(y >= 1 && y <= 5, "y needs to be between 1 and 5 inclusively")

        clues[x - 1][y - 1]
    }

    @Override
    String toString() {
        def builder = new StringBuilder("")
        clues.each { clue ->
            builder.append(Arrays.toString(clue))
        }
        builder.toString()
    }
}
