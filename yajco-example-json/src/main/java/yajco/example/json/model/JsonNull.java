package yajco.example.json.model;

import yajco.annotation.Before;

public class JsonNull extends JsonValue {

    @Before("null")
    public JsonNull(){
    }

    public Object getValue() {
        return null;
    }

    @Override
    public String toString() {
        return "null";
    }
}
