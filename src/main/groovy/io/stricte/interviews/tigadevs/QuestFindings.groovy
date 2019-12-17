package io.stricte.interviews.tigadevs

import io.stricte.interviews.tigadevs.RaiderOfTheLostTreasure.Track

interface QuestFindings {

    def view()

    class SuccessfulTrack implements QuestFindings {

        private final Track track

        SuccessfulTrack(Track track) { this.track = track }

        @Override
        def view() { track.print() }
    }

    @Singleton
    class Failure implements QuestFindings {

        @Override
        def view() { "NO TREASURE" }
    }
}
