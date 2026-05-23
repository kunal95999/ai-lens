package com.ailens.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LensResponse {
    private String modelName;
    private String content;
    private long latencyMs;
    private boolean fromCache;
    private String error;
}
