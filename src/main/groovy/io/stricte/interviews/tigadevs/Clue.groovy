package io.stricte.interviews.tigadevs

import groovy.transform.Immutable

import static com.google.common.base.Preconditions.checkArgument

@Immutable
class Clue {
    final int x
    final int y

    static Clue of(int x, int y) {
        checkArgument(x >= 1 && x <= 5, "x needs to be between 1 and 5 inclusively")
        checkArgument(y >= 1 && y <= 5, "y needs to be between 1 and 5 inclusively")

        new Clue(x, y)
    }

    @Override
    String toString() { "${x} ${y}" }
}
