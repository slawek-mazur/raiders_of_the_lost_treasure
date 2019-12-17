package io.stricte.interviews.tigadevs

import io.micronaut.core.io.ResourceResolver
import io.micronaut.core.io.scan.ClassPathResourceLoader

class Treasury {

    static TreasureMap lookupMap(String mapName) {
        def loader = new ResourceResolver().getLoader(ClassPathResourceLoader.class).get()
        def resource = loader.getResource(mapName).orElseThrow()

        def map = new TreasureMap()

        resource.openStream().withCloseable { it ->
            int x = 1, y = 1, clueX = -1, clueY = -1, coordinate

            for (int position = 1; (coordinate = it.read()) != -1; position++) {
                if (1 == position) {
                    clueX = coordinate - 48
                } else if (2 == position) {
                    clueY = coordinate - 48
                } else {
                    map.addClue(x, y, Clue.of(clueX, clueY))
                    if (++y == 6) {
                        y = 1
                        x++
                    }
                    position = 0
                }
            }
            map.addClue(x, y, Clue.of(clueX, clueY))
        }
        map
    }
}
