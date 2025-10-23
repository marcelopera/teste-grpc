package br.com.truta;

import org.jboss.logging.Logger;

import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;

@GrpcService
public class TaskService implements TaskResource {

    @Inject
    Logger logger;

    @Inject
    DummyService service;

    @Override
    @RunOnVirtualThread
    public Uni<TaskCreationResult> createTask(Task request) {
        logger.info(request.getTaskId());
        service.realizaServico();
        return Uni.createFrom().item("Task: " + request.getTaskName() + " -> Created")
        .map(response -> TaskCreationResult.newBuilder().setStatus(1).build());
    }
    
    
}
