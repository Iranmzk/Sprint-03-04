package demo.sprint.configuration;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;

import java.time.format.DateTimeFormatter;


public class Jackson {
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(){
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.serializers(new LocalDateSerializer(DateTimeFormatter.ISO_DATE));
            jacksonObjectMapperBuilder.deserializers(new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE));
        };
    }
}
