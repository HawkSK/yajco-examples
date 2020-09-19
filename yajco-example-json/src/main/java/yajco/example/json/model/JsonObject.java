package yajco.example.json.model;

import yajco.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class JsonObject extends JsonValue {
    private List<Member> members;

    @Before("{")
    @After("}")
    public JsonObject(@Separator(",") List<Member> members) {
        this.members = members;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public Map<JsonString, JsonValue> getValue() {
        Map<JsonString, JsonValue> map = new HashMap<>();
        for (Member m : members) {
            map.put(m.getName(), m.getValue());
        }
        return map;
    }

    @Override
    public String toString() {
        return this.members.stream()
                .map(Member::toString)
                .collect(joining(", ", "{", "}"));
    }
}
