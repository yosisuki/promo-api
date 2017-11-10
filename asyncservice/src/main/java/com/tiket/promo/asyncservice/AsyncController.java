package com.tiket.promo.asyncservice;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rx.Observable;
import rx.Observer;
import rx.Single;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping(path="/async", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AsyncController {

    @RequestMapping(path="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Observable<String> getAll() {
        return Observable.just("item1", "item2", "item3").map( str -> {
            System.out.println("Print out "+ str);
            return str;
        });
    }
}
