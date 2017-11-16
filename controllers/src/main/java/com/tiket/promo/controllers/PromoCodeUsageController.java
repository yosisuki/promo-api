package com.tiket.promo.controllers;

import com.tiket.promo.apiservice.UsePromoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/promo-code")
public class PromoCodeUsageController {
    private UsePromoCodeService usePromoCodeService;

    @Autowired
    public PromoCodeUsageController(UsePromoCodeService usePromoCodeService) { this.usePromoCodeService = usePromoCodeService; }

    @PostMapping(path="/use")
    public @ResponseBody String postUse(
            @RequestParam(value="code", required = true) String code,
            @RequestParam(value="code", required = true) Double totalAmount
    ) {
        this.usePromoCodeService.use(code, totalAmount);
        return "Inserted Succesfully";
    }
}
