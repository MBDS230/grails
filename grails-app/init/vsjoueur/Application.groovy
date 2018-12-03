package vsjoueur

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        Thread threadCron = new Thread(new MessageCron());
        threadCron.start();
        GrailsApp.run(Application, args)
    }
}