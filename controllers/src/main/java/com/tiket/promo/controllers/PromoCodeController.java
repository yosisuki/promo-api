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
    public @ResponseBody List<PromoCode> index() {
        return this.promoCodeService.all();
    }

    @GetMapping(path="/{code}")
    public @ResponseBody
    List<PromoCode> get(@PathVariable(value="code") String code) {
        return this.promoCodeService.find(code);
    }

    @PostMapping(path="")
    public @ResponseBody String create(
            @RequestParam(value="code", required = true) String code,
            @RequestParam(value="qty", required = true) int qty,
            @RequestParam(value="discount", required = true) Double discount,
            @RequestParam(value="discount_percent", required = true) Double discountPercent,
            @RequestParam(value="max_discount", required = true) Double maxDiscount,
            @RequestParam(value="start_date", required = true) String startDate,
            @RequestParam(value="end_date", required = true) String endDate
    ) {
        if(this.promoCodeService.insert(code, qty, discount, discountPercent, maxDiscount, startDate, endDate)){
            return "Inserted Succesfully";
        }
        return "There's problem when inserting";
    }

    @PatchMapping(path="/{code}")
    public @ResponseBody String update(
            @PathVariable(value="code") String code,
            @RequestParam(value="qty", required = true) int qty,
            @RequestParam(value="discount", required = true) Double discount,
            @RequestParam(value="discount_percent", required = true) Double discountPercent,
            @RequestParam(value="max_discount", required = true) Double maxDiscount,
            @RequestParam(value="start_date", required = true) String startDate,
            @RequestParam(value="end_date", required = true) String endDate
    ) {
        this.promoCodeService.update(code, qty, discount, discountPercent, maxDiscount, startDate, endDate);
        return "Updated Successfully";
    }

    @DeleteMapping(path="/{code}")
    public @ResponseBody String destroy(
            @PathVariable(value="code") String code
    ) {
        this.promoCodeService.softDelete(code);
        return "Deleted Successfully";
    }
}
