package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxiOrderTestSuite {

    @Test
    void testVipTaxiWithChildSeatExpressGetCost() {
        //Given
        TaxiOrder theOrder = new ChildSeatDecorator(new VipCarDecorator(new ExpressDecorator(new TaxiNetworkOrderDecorator(new BasicTaxiOrder()))));
        //When
        BigDecimal cost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(57), cost);
    }

    @Test
    void testVipTaxiWithChildSeatExpressGetDescription() {
        //Given
        TaxiOrder theOrder = new ChildSeatDecorator(new VipCarDecorator(new ExpressDecorator(new TaxiNetworkOrderDecorator(new BasicTaxiOrder()))));        //When
        String desc = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network express service variant VIP + child seat", desc);
    }

    @Test
    void testUberWithTwoChildSeatsGetCost() {
        //Given
        TaxiOrder theOrder = new ChildSeatDecorator(new ChildSeatDecorator(new UberNetworkOrderDecorator(new BasicTaxiOrder())));
        //When
        BigDecimal cost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(29), cost);
    }

    @Test
    void testUberWithTwoChildSeatsGetDescription() {
        //Given
        TaxiOrder theOrder = new ChildSeatDecorator(new ChildSeatDecorator(new UberNetworkOrderDecorator(new BasicTaxiOrder())));        //When
        String desc = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Uber Network + child seat + child seat", desc);
    }

    @Test
    void testMyTaxiWithChildSeatGetCost() {
        //Given
        TaxiOrder theOrder = new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder()));
        //When
        BigDecimal cost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(37), cost);
    }

    @Test
    void testMyTaxiWithChildSeatGetDescription() {
        //Given
        TaxiOrder theOrder = new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder()));
        //When
        String desc = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by MyTaxi Network + child seat", desc);
    }

    @Test
    void testTaxiNetworkGetCost() {
        //Given
        TaxiOrder theOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        //When
        BigDecimal cost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(40), cost);
    }

    @Test
    void testTaxiNetworkGetDescription() {
        //Given
        TaxiOrder theOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        //When
        String desc = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network", desc);
    }

    @Test
    void testBasicTaxiOrderGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        //When
        BigDecimal cost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(5), cost);
    }

    @Test
    void testBasicTaxiOrderGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        //When
        String desc = theOrder.getDescription();
        //Then
        assertEquals("Drive a course", desc);
    }
}