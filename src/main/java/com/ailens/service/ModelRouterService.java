package com.ailens.service;

import com.ailens.exception.ModelNotFoundException;
import com.ailens.model.request.LensRequest;
import com.ailens.model.response.LensResponse;
import com.ailens.service.strategy.ModelStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ModelRouterService {

    private final Map<String, ModelStrategy> strategyMap;

    public ModelRouterService(List<ModelStrategy> strategies) {
        this.strategyMap = strategies.stream()
                .collect(Collectors.toMap(
                        ModelStrategy::getModelName,
                        Function.identity()
                ));
        log.info("Loaded {} model strategies: {}", strategyMap.size(), strategyMap.keySet());
    }

    public LensResponse route(LensRequest request) {
        ModelStrategy strategy = strategyMap.get(request.getModelName());
        if (strategy == null) {
            throw new ModelNotFoundException(
                    "No strategy found for model: " + request.getModelName()
            );
        }
        log.info("Routing request to model: {}", request.getModelName());
        long start = System.currentTimeMillis();
        LensResponse response = strategy.analyze(request);
        response.setLatencyMs(System.currentTimeMillis() - start);
        return response;
    }

    public List<String> getAvailableModels() {
        return List.copyOf(strategyMap.keySet());
    }
}
