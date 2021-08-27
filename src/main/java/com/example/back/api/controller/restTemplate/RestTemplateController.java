package com.example.back.api.controller.restTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/rest")
@RequiredArgsConstructor
public class RestTemplateController {

    private final ObjectMapper objectMapper;

    @GetMapping("/send/restTemplate")
    public ResponseEntity<String> SendRestTemplate() throws Exception {
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

//        Map<String, Object> map = new HashMap<>();
//        map.put("msg", "Hello");
//        String params = objectMapper.writeValueAsString(map); Object to Json
        String params = "Hello";

        HttpEntity entity = new HttpEntity(params, headers);

        org.springframework.web.client.RestTemplate restTemplate = new org.springframework.web.client.RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/api/rest/get/restTemplate", HttpMethod.POST, entity, String.class);

        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());

        return responseEntity;
    }

    @PostMapping("/get/restTemplate")
    public ResponseEntity<String> GetRestTemplate(@RequestBody String params) throws Exception {
        //objectMapper.readValue(params, String.class); Json to Object
        String resMsg = params + " World";
        return new ResponseEntity<>(resMsg, HttpStatus.OK);
    }
}
