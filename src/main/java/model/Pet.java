package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import java.io.IOException;

@DataObject(publicConverter = false)
public class Pet {


    private int id;
    private String name;
    private String tag;

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private static ObjectMapper mapper = new ObjectMapper();

    public Pet(int id, String name, String tag) {
        this.id = id;
        this.name = name;
        this.tag = tag;
    }

    public Pet(JsonObject object)
    {
        try {
            mapper.readValue(object.toString(), Pet.class);
        } catch (IOException e)
        {
            log.error("", e);
        }
    }

    public Pet() {

    }

    public JsonObject toJson() {
        try {
            return new JsonObject(mapper.writeValueAsString(this));
        } catch (JsonProcessingException e)
        {
            log.error("", e);
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
