package com.tiket.promo.controllers;

import com.tiket.promo.apiservice.PromoCodeService;
import com.tiket.promo.entities.PromoCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/promo-code")
public class PromoCodeController {
    private PromoCodeService promoCodeService;

    @Autowired
    public PromoCodeController(PromoCodeService promoCodeService){
        this.promoCodeService = promoCodeService;
    }

    @GetMapping(path="/")
    public @ResponseBody Iterable<PromoCode> getAll() {
        return this.promoCodeService.all();
    }

    @GetMapping(path="/find")
    public @ResponseBody
    List<PromoCode> getFindPromoCode(@RequestParam(value="code", required = true) String code) {
        return this.promoCodeService.find(code);
    }

    @PostMapping(path="/create")
    public @ResponseBody String postCreate(
            @RequestParam(value="code", required = true) String code,
            @RequestParam(value="qty", required = true) int qty
    ) {
        this.promoCodeService.insert(code, qty);
        return "Inserted Succesfully";
    }

    @PatchMapping(path="/update")
    public @ResponseBody String patchCreate(
            @RequestParam(value="code", required = true) String code,
            @RequestParam(value="qty", required = true) int qty
    ) {
        this.promoCodeService.update(code, qty);
        return "Updated Successfully";
    }
}
