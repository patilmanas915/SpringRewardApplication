package org.manas.springrewardapplication.WebLayer;

import org.manas.springrewardapplication.DTO.OutPut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ItemController {

    @GetMapping("/getItems")
    public String  getItems() {

        RestTemplate restTemplate = new RestTemplate();
        Map<String,URI> attributes = new HashMap<>();
        URI uri = URI.create("");
        attributes.put("url",uri);
        return restTemplate.getForObject("https://relaxing-safely-leech.ngrok-free.app/scrape?url=https://www.amazon.in/dp/B0CVGZQ3RR/ref=sspa_dk_detail_3?psc=1&pd_rd_i=B0CVGZQ3RR&pd_rd_w=B96LQ&content-id=amzn1.sym.413ef885-ae1b-472f-afa4-d683cda6ad0d&pf_rd_p=413ef885-ae1b-472f-afa4-d683cda6ad0d&pf_rd_r=1GJ67QZX9K9T2QYW1624&pd_rd_wg=MQmDJ&pd_rd_r=5677e548-020e-4fe4-a180-fe951163a68d&s=automotive&sp_csd=d2lkZ2V0TmFtZT1zcF9kZXRhaWw", String.class);
    }
}
