package com.example.rest;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.util.function.UnaryOperator;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer(){
        return new RuntimeWiringConfigurer() {
            @Override
            public void configure(RuntimeWiring.Builder builder) {
                builder.type("Query", new UnaryOperator<TypeRuntimeWiring.Builder>() {
                    @Override
                    public TypeRuntimeWiring.Builder apply(TypeRuntimeWiring.Builder wiring) {
                        return wiring
                                .dataFetcher("performances", new DataFetcher() {
                                    @Override
                                    public Object get(DataFetchingEnvironment environment) throws Exception {
                                        return null;
                                    }
                                })
                    }
                })
            }
        }
    }
}