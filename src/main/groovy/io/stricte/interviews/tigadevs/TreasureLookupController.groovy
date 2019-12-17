package io.stricte.interviews.tigadevs

import groovy.transform.CompileStatic
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.QueryValue

@CompileStatic
@Controller("/")
class TreasureLookupController {

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    HttpResponse startAt(@QueryValue String startingPoint) {

        def map = Treasury.lookupMap("treasure_map")

        int x = startingPoint.charAt(0) - 48 as int
        int y = startingPoint.charAt(1) - 48 as int

        QuestFindings outcome = RaiderOfTheLostTreasure.onTrack()
                .lookupTreasureWithMapStartingAt(map, x, y)

        def status = outcome instanceof QuestFindings.Failure ?
                HttpStatus.NOT_FOUND : HttpStatus.OK

        HttpResponse.status(status).body(outcome.view())
    }
}