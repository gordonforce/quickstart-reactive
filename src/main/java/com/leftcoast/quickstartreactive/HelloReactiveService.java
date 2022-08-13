package com.leftcoast.quickstartreactive;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;

@ApplicationScoped
public class HelloReactiveService {

    public Uni<String> hello(final String name) {

        return Uni.createFrom().item(name).onItem().transform(s -> "hello " + name);

    }

    public Multi<String> multiHello(final String name, final int number) {

        return Multi.createFrom()
                .ticks()
                .every(Duration.ofSeconds(3))
                .onItem()
                .transform(n -> "hello " + name + n)
                .select()
                .first(number);

    }

}
