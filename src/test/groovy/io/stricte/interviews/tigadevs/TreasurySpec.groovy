package io.stricte.interviews.tigadevs

import spock.lang.Specification

class TreasurySpec extends Specification {

    void "load map from treasury"() {

        given: 'a map name'
        def mapName = "classpath:treasure_map1"

        when: 'map is loaded'
        def map = Treasury.lookupMap(mapName)

        then: 'it should not be null'
        null != map
    }
}
