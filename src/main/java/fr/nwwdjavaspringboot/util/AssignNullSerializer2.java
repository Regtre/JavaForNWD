package fr.nwwdjavaspringboot.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class AssignNullSerializer2 extends JsonSerializer {

    public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException
    {
        // any JSON value you want...
        if(value==null) {
            jgen.writeString("''");
        }
    }

}
