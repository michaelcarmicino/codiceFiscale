package com.example.demo.codiceFiscaleController;

import com.example.demo.codiceFiscaleResponse.CodiceFiscaleResponse;
import com.example.demo.codiceFiscaleService.CodiceFiscaleService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class CodiceFiscaleController {

    @GetMapping("/api/{cf}")
    public CodiceFiscaleResponse getData(String cf){
        LocalDate anno = CodiceFiscaleService.estraiData(cf);
        int eta = CodiceFiscaleService.calcoloEta(anno.getYear());

        CodiceFiscaleResponse cfr = new CodiceFiscaleResponse(anno,eta);
        return cfr;
    }


}
