package com.ailens.service.strategy;

import com.ailens.model.request.LensRequest;
import com.ailens.model.response.LensResponse;

public interface ModelStrategy {
    LensResponse analyze(LensRequest request);
    String getModelName();
    boolean supportsVision();
}
