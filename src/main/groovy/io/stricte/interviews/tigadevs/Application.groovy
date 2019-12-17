package io.stricte.interviews.tigadevs

import groovy.transform.CompileStatic
import io.micronaut.runtime.Micronaut

@CompileStatic
class Application {
    static void main(String[] args) {
        Micronaut.run(Application)
    }
}