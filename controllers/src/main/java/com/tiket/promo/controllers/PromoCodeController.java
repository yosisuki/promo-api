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

    @GetMapping(path="")
    public @ResponseBody List<PromoCode> getAll() {
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
            @RequestParam(value="qty", required = true) int qty,
            @RequestParam(value="discount", required = true) Float discount,
            @RequestParam(value="discount_percent", required = true) Float discountPercent,
            @RequestParam(value="max_discount", required = true) Float maxDiscount,
            @RequestParam(value="start_date", required = true) String startDate,
            @RequestParam(value="end_date", required = true) String endDate
    ) {
        if(this.promoCodeService.insert(code, qty, discount, discountPercent, maxDiscount, startDate, endDate)){
            return "Inserted Succesfully";
        }
        return "There's problem when inserting";

    }

    @PatchMapping(path="/update")
    public @ResponseBody String patchUpdate(
            @RequestParam(value="code", required = true) String code,
            @RequestParam(value="qty", required = true) int qty,
            @RequestParam(value="discount", required = true) Float discount,
            @RequestParam(value="discount_percent", required = true) Float discountPercent,
            @RequestParam(value="max_discount", required = true) Float maxDiscount,
            @RequestParam(value="start_date", required = true) String startDate,
            @RequestParam(value="end_date", required = true) String endDate
    ) {
        this.promoCodeService.update(code, qty, discount, discountPercent, maxDiscount, startDate, endDate);
        return "Updated Successfully";
    }
}
