package endpoint;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import service.ServiceController;
import util.Runner;

public class Main extends AbstractVerticle {

public static void main(String... args)
{
    Runner.runExample(Main.class);
}

@Override
    public void start(Future<Void> fut)
{

    vertx.deployVerticle(new RestEndpoint());
    vertx.deployVerticle(new ServiceController());


}
}
