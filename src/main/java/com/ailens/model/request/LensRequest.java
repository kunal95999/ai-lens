package com.ailens.model.request;

import lombok.Data;

@Data
public class LensRequest {
    private String modelName;
    private String imageBase64;
    private String imageUrl;
    private String userPrompt;
    private String mimeType;
}
