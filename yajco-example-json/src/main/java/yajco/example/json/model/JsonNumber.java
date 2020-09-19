package yajco.example.json.model;

import yajco.annotation.Token;

import java.text.NumberFormat;
import java.util.Locale;

public class JsonNumber extends JsonValue {
    private float value;

    public JsonNumber(@Token("NUMBER") float value){
        this.value = value;
    }

    @Override
    public Float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return NumberFormat.getInstance(Locale.ROOT).format(value);
    }
}
