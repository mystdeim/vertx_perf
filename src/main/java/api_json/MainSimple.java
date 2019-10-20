package api_json;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.ext.web.Router;

public class MainSimple {
    public static void main(String[] args) {
        try {
            new MainSimple();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MainSimple() {
        var vOpts = new VertxOptions();
        vOpts.setEventLoopPoolSize(4);
        var vertx = Vertx.vertx(vOpts);
        var router = Router.router(vertx);
        router.get("/api/test").handler(ctx -> {
            ctx.response()
                    .putHeader("content-type", "application/json; charset=utf-8")
                    .end(new HelloWorld("world").toJson().toString());
        });
        var httpServer = vertx.createHttpServer();
        httpServer.requestHandler(router).listen(8080);
        System.out.println("Started on http://localhost:8080");
    }
}
