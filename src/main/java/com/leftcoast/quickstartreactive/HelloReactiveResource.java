package com.leftcoast.quickstartreactive;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestStreamElementType;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloreactive")
public class HelloReactiveResource {

    private final HelloReactiveService helloReactiveService;

    @Inject
    public HelloReactiveResource(HelloReactiveService helloReactiveService) {
        this.helloReactiveService = helloReactiveService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public Uni<String> hello(final String name) {

        return helloReactiveService.hello(name);

    }

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    @Path("/{name}/{number}")
    public Multi<String> multiHello(final String name, final int number) {

        return helloReactiveService.multiHello(name, number);

    }

}