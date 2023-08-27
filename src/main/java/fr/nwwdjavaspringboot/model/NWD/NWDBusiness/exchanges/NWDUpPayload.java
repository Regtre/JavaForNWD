package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.type.LogicalType;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NWDUpPayload implements Serializable {



    @Configuration
    public static class ObjectMapperConfig {
        @Bean
        public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
            return builder -> builder.postConfigurer(objectMapper -> {
                objectMapper.coercionConfigFor(LogicalType.Enum)
                        .setCoercion(CoercionInputShape.EmptyString, CoercionAction.AsNull);
            });
        }
    }
}
