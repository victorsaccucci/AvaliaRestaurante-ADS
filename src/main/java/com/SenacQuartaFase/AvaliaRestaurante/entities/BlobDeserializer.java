package com.SenacQuartaFase.AvaliaRestaurante.entities;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

public class BlobDeserializer extends StdDeserializer<Blob> {

    protected BlobDeserializer() {
        super(Blob.class);
    }

    @Override
    public Blob deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        byte[] data = node.binaryValue();
        try {
            return new SerialBlob(data);
        } catch (SQLException e) {
            throw new IOException("Failed to deserialize Blob", e);
        }
    }
}
