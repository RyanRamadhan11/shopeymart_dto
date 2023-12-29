package com.enigma.challenge_shopemart_dto.controller;

import com.enigma.challenge_shopemart_dto.constant.AppPath;
import com.enigma.challenge_shopemart_dto.dto.request.StoreRequest;
import com.enigma.challenge_shopemart_dto.dto.response.StoreResponse;
import com.enigma.challenge_shopemart_dto.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppPath.STORE)
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping
    public List<StoreResponse> getAllStores() {
        return storeService.getAll();
    }

    @PostMapping
    public StoreResponse create(@RequestBody StoreRequest storeRequest) {
        return storeService.create(storeRequest);
    }

    @PutMapping
    public StoreResponse updateStore(@RequestBody StoreRequest storeRequest) {
        return storeService.update(storeRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable String id) {
        storeService.delete(id);
    }

    @GetMapping("/{id}")
    public StoreResponse getById(@PathVariable String id) {
        return storeService.getById(id);
    }

}
