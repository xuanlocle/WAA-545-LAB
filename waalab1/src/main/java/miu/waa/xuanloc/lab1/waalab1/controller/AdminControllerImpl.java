package miu.waa.xuanloc.lab1.waalab1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminControllerImpl implements AdminController {


    @GetMapping()
    @Override
    public ResponseEntity<?> adminHealth() {
        return ResponseEntity.ok("OK");
    }
}
