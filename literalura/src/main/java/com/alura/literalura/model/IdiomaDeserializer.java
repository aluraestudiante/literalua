package com.alura.literalura.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class IdiomaDeserializer extends StdDeserializer<Idioma> {

    public IdiomaDeserializer() {
        this(null);
    }

    public IdiomaDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Idioma deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        Idioma idioma = new Idioma();
        idioma.setLanguage(node.asText());
        return idioma;
    }
}
