package com.ailens.controller;

import com.ailens.model.request.LensRequest;
import com.ailens.model.response.LensResponse;
import com.ailens.service.ModelRouterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lens")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LensController {

    private final ModelRouterService modelRouterService;

    @PostMapping("/analyze")
    public ResponseEntity<LensResponse> analyze(@RequestBody LensRequest request) {
        return ResponseEntity.ok(modelRouterService.route(request));
    }

    @GetMapping("/models")
    public ResponseEntity<List<String>> getAvailableModels() {
        return ResponseEntity.ok(modelRouterService.getAvailableModels());
    }
}