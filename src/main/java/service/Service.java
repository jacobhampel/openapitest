package service;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;
import io.vertx.ext.web.api.generator.WebApiServiceGen;
import model.Pet;

@WebApiServiceGen
public interface Service {

    void listPets(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

    void createPets(Pet pet, OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

    void showPetById(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

    void listPetsSecurity(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

    void encodedParamTest(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

    void jsonEmptyBody(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

}
