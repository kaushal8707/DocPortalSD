package com.always.learner.DocPortalSD;
import com.always.learner.config.RibbonConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController
{
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/doctors")
    public String getDoctors(){
        //String url = "http://DOCTOR-SERVICE-APP/allDoctors";//http://localhost:9081/allDoctors";

        //to customize ribbon client with eureka only
        String url = "http://doctor-service-app/allDoctors";//http://localhost:9081/allDoctors";
        return restTemplate.getForObject(url, String.class);
    }
}
