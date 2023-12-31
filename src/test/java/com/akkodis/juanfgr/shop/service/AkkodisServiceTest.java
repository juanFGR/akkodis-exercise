package com.akkodis.juanfgr.shop.service;


import com.akkodis.juanfgr.shop.model.Price;
import com.akkodis.juanfgr.shop.repo.PriceRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.Optional;
import java.util.function.BooleanSupplier;

@SpringBootTest
class AkkodisServiceTest {

    @Resource
    PriceRepository priceRepository;
    @Autowired
    PriceService priceService;
    @Autowired
    ProductService productService;

    @BeforeEach
    void setMockOutput() {

    }


    @Test
    void getAllPrice() {
        Assertions.assertNotNull(priceRepository.findAll());
        BooleanSupplier condition = () -> 4 <= priceRepository.findAll().size();
        Assertions.assertTrue(condition, "Database was updated, almost 1 new element");
    }

    @Test
    void testCase_1() throws ParseException {
        /**
         * This a test to validate the akkodis test:
         * Price application disambiguator. If two rates coincide in a range of dates, the one with the
         * highest priority (highest numerical value) is applied.
         *
         * */
        Price priceExpected = priceService.getPriceById(1L);
        Price priceCalculated = priceService.searchPriceByProduct(productService.getProductById(35455L), "2020-06-14-10.00.00");

        Assertions.assertEquals(priceExpected.getId(),priceCalculated.getId());
        Assertions.assertEquals(priceExpected.getCost(),priceCalculated.getCost());
        Assertions.assertEquals(priceExpected.getCurrent(),priceCalculated.getCurrent());
        Assertions.assertEquals(priceExpected.getProduct().getName(),priceCalculated.getProduct().getName());
    }

    @Test
    void testCase_2() throws ParseException {
        /**
         * This a test to validate the akkodis test:
         * Price application disambiguator. If two rates coincide in a range of dates, the one with the
         * highest priority (highest numerical value) is applied.
         *
         * */
        Price priceExpected = priceService.getPriceById(2L);
        Price priceCalculated = priceService.searchPriceByProduct(productService.getProductById(35455L), "2020-06-14-16.00.00");

        Assertions.assertEquals(priceExpected.getId(),priceCalculated.getId());
        Assertions.assertEquals(priceExpected.getCost(),priceCalculated.getCost());
        Assertions.assertEquals(priceExpected.getCurrent(),priceCalculated.getCurrent());
        Assertions.assertEquals(priceExpected.getProduct().getName(),priceCalculated.getProduct().getName());

    }

    @Test
    void testCase_3() throws ParseException {
        /**
         * This a test to validate the akkodis test:
         * Price application disambiguator. If two rates coincide in a range of dates, the one with the
         * highest priority (highest numerical value) is applied.
         *
         * */
        Price priceExpected = priceService.getPriceById(1L);
        Price priceCalculated = priceService.searchPriceByProduct(productService.getProductById(35455L), "2020-06-14-21.00.00");

        Assertions.assertEquals(priceExpected.getId(),priceCalculated.getId());
        Assertions.assertEquals(priceExpected.getCost(),priceCalculated.getCost());
        Assertions.assertEquals(priceExpected.getCurrent(),priceCalculated.getCurrent());
        Assertions.assertEquals(priceExpected.getProduct().getName(),priceCalculated.getProduct().getName());

    }

    @Test
    void testCase_4() throws ParseException {
        /**
         * This a test to validate the akkodis test:
         * Price application disambiguator. If two rates coincide in a range of dates, the one with the
         * highest priority (highest numerical value) is applied.
         *
         * */
        Price priceExpected = priceService.getPriceById(3L);
        Price priceCalculated = priceService.searchPriceByProduct(productService.getProductById(35455L), "2020-06-15-10.00.00");

        Assertions.assertEquals(priceExpected.getId(),priceCalculated.getId());
        Assertions.assertEquals(priceExpected.getCost(),priceCalculated.getCost());
        Assertions.assertEquals(priceExpected.getCurrent(),priceCalculated.getCurrent());
        Assertions.assertEquals(priceExpected.getProduct().getName(),priceCalculated.getProduct().getName());

    }

    @Test
    void testCase_5() throws ParseException {
        /**
         * This a test to validate the akkodis test:
         * Price application disambiguator. If two rates coincide in a range of dates, the one with the
         * highest priority (highest numerical value) is applied.
         *
         * */
        Price priceExpected = priceService.getPriceById(4L);
        Price priceCalculated = priceService.searchPriceByProduct(productService.getProductById(35455L), "2020-06-16-21.00.00");

        Assertions.assertEquals(priceExpected.getId(),priceCalculated.getId());
        Assertions.assertEquals(priceExpected.getCost(),priceCalculated.getCost());
        Assertions.assertEquals(priceExpected.getCurrent(),priceCalculated.getCurrent());
        Assertions.assertEquals(priceExpected.getProduct().getName(),priceCalculated.getProduct().getName());

    }




}