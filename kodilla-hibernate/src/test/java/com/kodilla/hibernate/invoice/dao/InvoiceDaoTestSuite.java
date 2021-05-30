package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product iPhone = new Product("Apple iPhone 12");
        Product appleWatch = new Product("Apple Watch 6");

        Item phone1 = new Item(10, new BigDecimal(2500));
        phone1.setProduct(iPhone);

        Item phone2 = new Item(5, new BigDecimal(2500));
        phone2.setProduct(iPhone);

        Item watch1 = new Item(4, new BigDecimal(2000));
        watch1.setProduct(appleWatch);

        Item watch2 = new Item(2, new BigDecimal(2000));
        watch2.setProduct(appleWatch);

        Invoice invoice1 = new Invoice("2021/05/143");
        Invoice invoice2 = new Invoice("2021/05/144");

        phone1.setInvoice(invoice1);
        watch1.setInvoice(invoice1);
        phone2.setInvoice(invoice2);
        watch2.setInvoice(invoice2);

        iPhone.getItems().add(phone1);
        iPhone.getItems().add(phone2);
        appleWatch.getItems().add(watch1);
        appleWatch.getItems().add(watch2);

        invoice1.getItems().add(phone1);
        invoice1.getItems().add(watch1);

        invoice2.getItems().add(phone2);
        invoice2.getItems().add(watch2);

        //When
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);

        int invoice1Id = invoice1.getId();
        System.out.println("First invoice id: " + invoice1Id);

        int invoice2Id = invoice2.getId();
        System.out.println("Second invoice id: " + invoice2Id);

        int iPhoneId = iPhone.getId();
        System.out.println("iPhone id: " + iPhoneId);

        int appleWatchId = iPhone.getId();
        System.out.println("Apple Watch id: " + appleWatchId);

        int phone1Id = phone1.getId();
        System.out.println("First item id: " + phone1Id);

        int phone2Id = phone2.getId();
        System.out.println("Second item id: " + phone2Id);

        int watch1Id = watch1.getId();
        System.out.println("Third item id: " + watch1Id);

        int watch2Id = watch2.getId();
        System.out.println("Fourth item id: " + watch2Id);

        //Then
        assertAll(
                () -> assertEquals(2, iPhone.getItems().size()),
                () -> assertEquals(2, appleWatch.getItems().size()),
                () -> assertEquals(2, invoice1.getItems().size()),
                () -> assertEquals(2, invoice2.getItems().size()),
                () -> assertNotEquals(0, invoice1Id),
                () -> assertNotEquals(0, invoice2Id),
                () -> assertNotEquals(0, iPhoneId),
                () -> assertNotEquals(0, appleWatchId),
                () -> assertNotEquals(0, phone1Id),
                () -> assertNotEquals(0, phone2Id),
                () -> assertNotEquals(0, watch1Id),
                () -> assertNotEquals(0, watch2Id)
        );

        //CleanUp
        try {
            invoiceDao.deleteById(invoice1Id);
            invoiceDao.deleteById(invoice2Id);
        } catch (Exception e) {
            //do nothing
        }
    }
}