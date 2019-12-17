package io.stricte.interviews.tigadevs

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class TreasureLookupControllerSpec extends Specification {

    @Inject
    @Client("/")
    RxHttpClient client

    void "treasure lookup wrong argument results in exception"() {
        when:
        HttpRequest request = HttpRequest.GET('/?startingPoint=67')
        client.toBlocking().exchange(request, String.class)

        then: "should thrown exception"
        def exception = thrown(HttpClientResponseException)

        and: "status should be internal server error"
        exception.response.status == HttpStatus.INTERNAL_SERVER_ERROR
    }

    void "treasure lookup"() {
        when:
        HttpRequest request = HttpRequest.GET('/?startingPoint=11')
        HttpResponse response = client.toBlocking().exchange(request, String.class)

        then: "status is ok"
        response.status == HttpStatus.OK

        and: "body is a track"
        response.body() == "1 1\n3 4\n4 2\n1 5\n2 5\n3 1\n5 4\n1 3\n3 2\n4 5\n3 5\n2 3\n4 3\n5 1\n2 1\n1 4\n4 1\n3 3\n5 2"
    }
}