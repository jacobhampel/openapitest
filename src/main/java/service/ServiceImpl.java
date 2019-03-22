package service;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;
import model.Pet;

public class ServiceImpl implements Service {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void listPets(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) {
        log.info("listPets");
        resultHandler.handle(
                Future.succeededFuture(
                        OperationResponse.completedWithPlainText(Buffer.buffer("listPets"))
                )
        );
    }

    @Override
    public void createPets(Pet pet, OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) {
        log.info("createPets");
        resultHandler.handle(
                Future.succeededFuture(
                        OperationResponse.completedWithPlainText(Buffer.buffer("createPets"))
                )
        );
    }

    @Override
    public void showPetById(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) {
        log.info("showPetById");
        resultHandler.handle(
                Future.succeededFuture(
                        OperationResponse.completedWithPlainText(Buffer.buffer("showPetById"))
                )
        );
    }

    @Override
    public void encodedParamTest(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) {
        log.info("encodedParamTest");
        resultHandler.handle(
                Future.succeededFuture(
                        OperationResponse.completedWithPlainText(Buffer.buffer("encodedParamTest"))
                )
        );
    }

    @Override
    public void jsonEmptyBody(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) {
        log.info("jsonEmptyBody");
        resultHandler.handle(
                Future.succeededFuture(
                        OperationResponse.completedWithPlainText(Buffer.buffer("jsonEmptyBody"))
                )
        );
    }

    @Override
    public void listPetsSecurity(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) {
        log.info("listPetsSecurity");
        context.getUser();
        resultHandler.handle(
                Future.succeededFuture(
                        OperationResponse.completedWithPlainText(Buffer.buffer("listPetsSecurity"))
                )
        );
    }
}
