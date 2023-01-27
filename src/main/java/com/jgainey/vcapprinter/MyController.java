package com.jgainey.vcapprinter;

import org.apache.tomcat.jni.OS;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class MyController {

    @ResponseBody
    @GetMapping("print-vcap")
    public ResponseEntity<String> printVcap() {
        return new ResponseEntity<>(System.getenv("VCAP_SERVICES"), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("print-all")
    public ResponseEntity<String> printAll() {

        StringBuilder sb = new StringBuilder();

        Map<String, String> env = System.getenv();
        env.forEach((k, v) -> sb.append(k + ":" + v + "\n\n"));

        return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
    }

}
