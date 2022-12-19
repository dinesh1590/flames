package com.myproject.flames.controller;

import com.myproject.flames.dto.FlamesModel;
import com.myproject.flames.dto.Response;
import com.myproject.flames.service.FlamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("http://localhost:4200")
@RestController
public class FlamesController {

    @Autowired
    private FlamesService flamesService;

    @PostMapping("/flames")
    public ResponseEntity<Response> flames(@RequestBody FlamesModel flamesModel) {

      return new ResponseEntity<>(flamesService.flames(flamesModel), HttpStatus.OK);
    }
}
