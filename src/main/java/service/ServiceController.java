package service;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ServiceBinder;
import endpoint.RestEndpoint;

public class ServiceController extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut)
    {
        Service service = new ServiceImpl();
        final ServiceBinder serviceBinder =
                new ServiceBinder(vertx).setAddress(RestEndpoint.getEventBusAddress());
        serviceBinder.register(Service.class, service);
    }
}
