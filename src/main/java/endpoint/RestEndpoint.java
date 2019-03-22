package endpoint;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import service.Service;

public class RestEndpoint extends AbstractVerticle {
    private static final String EVENT_BUS_ADDRESS = "address";
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public static String getEventBusAddress() {
        return EVENT_BUS_ADDRESS;
    }

    @Override
    public void start(Future<Void> fut) {
        log.info("Started");
        OpenAPI3RouterFactory.create(vertx, "src/main/resources/openApi.yaml", ar -> {
            if (ar.succeeded()) {
                // Spec loaded with success
                OpenAPI3RouterFactory routerFactory = ar.result();
                routerFactory.mountServiceInterface(Service.class, EVENT_BUS_ADDRESS);

                Router router = routerFactory.getRouter();
                HttpServer httpServer = vertx.createHttpServer();
                httpServer.requestHandler(router);
                httpServer.listen(8080);

            } else {
                // Something went wrong during router factory initialization
                Throwable exception = ar.cause();
                log.error("", exception);
                fut.fail(exception);
            }
        });


    }
}
