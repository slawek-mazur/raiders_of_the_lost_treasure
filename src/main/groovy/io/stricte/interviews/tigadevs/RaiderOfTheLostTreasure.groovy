package io.stricte.interviews.tigadevs

import groovy.transform.Immutable

import static com.google.common.base.Preconditions.checkArgument
import static java.util.Objects.nonNull

class RaiderOfTheLostTreasure {

    private final Track track = new Track()

    private RaiderOfTheLostTreasure() {}

    static RaiderOfTheLostTreasure onTrack() { new RaiderOfTheLostTreasure() }

    QuestFindings lookupTreasureWithMapStartingAt(TreasureMap map, int xCoordinate, int yCoordinate) {
        checkArgument(nonNull(map), "no way to find a treasure without map")

        followTheCluesStartingAt(map, xCoordinate, yCoordinate)
    }

    private QuestFindings followTheCluesStartingAt(TreasureMap map, int xCoordinate, int yCoordinate) {
        int x = xCoordinate
        int y = yCoordinate
        while (true) {
            def clue = map.clueAt(x, y)
            if (track.isVisited(x, y)) {
                if (x == clue.x && y == clue.y) return new QuestFindings.SuccessfulTrack(track)
                else return QuestFindings.Failure.instance
            }
            track.markVisited(x, y)
            x = clue.x
            y = clue.y
        }
    }

    private QuestFindings recursivelyFollowTheCluesStartingAt(TreasureMap map, int x, int y) {
        def clue = map.clueAt(x, y)
        if (track.isVisited(x, y)) {
            if (x == clue.x && y == clue.y) return new QuestFindings.SuccessfulTrack(track)
            else return QuestFindings.Failure.instance
        }
        track.markVisited(x, y)
        recursivelyFollowTheCluesStartingAt(map, clue.x, clue.y)
    }

    @Immutable
    static class Track {

        private final Set<String> places = new LinkedHashSet<>()

        def isVisited(int x, int y) { places.contains(key(x, y)) }

        def markVisited(int x, int y) { places.add(key(x, y)) }

        private static def key(int x, int y) { "${x} ${y}" }

        def print() { places.join("\n") }
    }
}
