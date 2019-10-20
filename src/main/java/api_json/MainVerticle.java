package api_json;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.ext.web.Router;

public class MainVerticle {
    public static void main(String[] args) {
        try {
            new MainVerticle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MainVerticle() {
        var vOpts = new VertxOptions();
        vOpts.setEventLoopPoolSize(1);
        var vertx = Vertx.vertx(vOpts);
        var opts = new DeploymentOptions();
        opts.setInstances(4);
        vertx.deployVerticle(Verticle.class.getName(), opts);
    }

    public static class Verticle extends AbstractVerticle {
        @Override
        public void start() throws Exception {
            var router = Router.router(getVertx());
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
}
