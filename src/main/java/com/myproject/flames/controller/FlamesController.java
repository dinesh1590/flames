package com.myproject.flames.controller;

import com.myproject.flames.dto.FlamesModel;
import com.myproject.flames.service.FlamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlamesController {

    @Autowired
    private FlamesService flamesService;

    @PostMapping("/flames")
    public ResponseEntity<String> flames(@RequestBody FlamesModel flamesModel) {

      return new ResponseEntity<>(flamesService.flames(flamesModel), HttpStatus.OK);
    }



}
