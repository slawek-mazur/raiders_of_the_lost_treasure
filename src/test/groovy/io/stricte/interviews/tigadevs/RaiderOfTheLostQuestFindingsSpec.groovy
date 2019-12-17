package io.stricte.interviews.tigadevs

import spock.lang.Specification

class RaiderOfTheLostQuestFindingsSpec extends Specification {

    void "searching with malformed map should end with failure"() {

        given: 'a map'
        def map = Treasury.lookupMap("classpath:circular_map")

        and: 'coordinates'
        def x = 1
        def y = 1

        when: 'lookup is done'
        def outcome = RaiderOfTheLostTreasure.onTrack().lookupTreasureWithMapStartingAt(map, x, y)

        then: 'it should be a failure'
        outcome instanceof QuestFindings.Failure

        and:
        "NO TREASURE" == outcome.view()
    }

    void "legit map will result in successful track"() {

        given: 'a map'
        def map = Treasury.lookupMap("classpath:treasure_map1")

        and: 'coordinates'
        def x = 1
        def y = 1

        when: 'lookup is done'
        def outcome = RaiderOfTheLostTreasure.onTrack().lookupTreasureWithMapStartingAt(map, x, y)

        then: 'it should be successful'
        outcome instanceof QuestFindings.SuccessfulTrack

        and:
        "1 1\n5 5\n1 5\n2 1\n4 4\n3 2\n1 3\n2 5\n4 3" == outcome.view()
    }
}
