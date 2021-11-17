package org.subha.reactive.twitter.functional;

import io.netty.handler.ssl.SslClientHelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class TweetRouter {

    @Bean
    public RouterFunction<ServerResponse> functionalRoutes(TweetHandler tweetHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/functional/firstTweet")
                        , tweetHandler::firstTweet)
                .andRoute(RequestPredicates.GET("functional/welcomeTweet")
                        , tweetHandler::welcomeTweet);
    }
}