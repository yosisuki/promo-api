package com.tiket.promo.asyncservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rx.Single;
import rx.SingleSubscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


@Controller
@RequestMapping(path="/async", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AsyncController {
    private List<String> result = new ArrayList<String>();

    private NameGenerator nameGenerator = new NameGenerator();

    @RequestMapping(path="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<String> getAll() {
        this.getTvShows()
        .subscribe(new SingleSubscriber<List<String>>() {
            @Override
            public void onSuccess(List<String> tvShows) {
                result = tvShows;
            }
            @Override
            public void onError(Throwable error) {

            }
        });

        return result;
    }

    private Single<List<String>> getTvShows(){
        Single<List<String>> tvShowSingle = Single.fromCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                List<String> shows = new ArrayList<String>();
                for(int a = 0; a < 100; a++){
                    shows.add(nameGenerator.randomIdentifier());
                    TimeUnit.SECONDS.sleep(1);
                }
                return shows;
            }
        });

        return tvShowSingle;
    }
}
