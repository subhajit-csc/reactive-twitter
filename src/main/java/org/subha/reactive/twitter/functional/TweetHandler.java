package org.subha.reactive.twitter.functional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class TweetHandler {

    /**
     * Serves a plain_text
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> firstTweet(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(
                        Mono.just("Welcome to Reactive Twitter :) !!"), String.class
                );
    }

    /**
     * Serves a JSON stream
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> welcomeTweet(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(
                        Flux.just("Hi there !! ","  Welcome ", "to ", "Reactive Twitter :) !!")
                                .delayElements(Duration.ofSeconds(5)).log(), String.class
                );
    }
}