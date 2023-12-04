package com.rap.microservices.Currency_Ex_Service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Logger logger= LoggerFactory.getLogger(CurrencyExchangeController.class);
    @Autowired
    private CurrencyExchangeRepository repository;
    @Autowired
    private Environment environment;
    @GetMapping(path="/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retriveExchangeValue(@PathVariable String from,@PathVariable String to ){
        logger.info("retriveExchangeValues called with {} to {}", from, to);
        CurrencyExchange currencyexchange= repository.findByFromAndTo(from,to);
        if(currencyexchange==null){
             throw new RuntimeException("Unable to find data for"+from+"to"+to);
        }

        String port= environment.getProperty("local.server.port");
        currencyexchange.setEnvironment(port);
        return currencyexchange;
    }
}
