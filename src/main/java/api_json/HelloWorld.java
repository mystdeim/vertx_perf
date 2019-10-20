package api_json;

import io.vertx.core.json.JsonObject;

public class HelloWorld {

    private final String hello;

    public HelloWorld(String hello) {
        this.hello = hello;
    }

    public String getHello() {
        return hello;
    }

    public JsonObject toJson() {
        return new JsonObject().put("hello", hello);
    }

}
