package com.tiket.promo.controllers;

import com.tiket.promo.apiservice.PromoCodeUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/promo-code")
public class PromoCodeUsageController {
    private PromoCodeUsageService promoCodeUsageService;

    @Autowired
    public PromoCodeUsageController(PromoCodeUsageService promoCodeUsageService){
        this.promoCodeUsageService = promoCodeUsageService;
    }

    @PostMapping(path="/use")
    public @ResponseBody String postUse(
            @RequestParam(value="code", required = true) String code
    ) {
        this.promoCodeUsageService.usePromoCode(code);
        return "Inserted Succesfully";
    }
}
