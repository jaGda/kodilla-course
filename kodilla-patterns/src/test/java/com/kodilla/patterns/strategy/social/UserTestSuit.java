package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTestSuit {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User rachel = new Millennials("Rachel");
        User phoebe = new YGeneration("Phoebe");
        User ross = new ZGeneration("Ross");

        //When
        String rachelUsing = rachel.sharePost();
        System.out.println(rachelUsing);
        String phoebeUsing = phoebe.sharePost();
        System.out.println(phoebeUsing);
        String rossUsing = ross.sharePost();
        System.out.println(rossUsing);

        //Then
        assertEquals("FACEBOOK", rachelUsing);
        assertEquals("TWITTER", phoebeUsing);
        assertEquals("SNAPCHAT", rossUsing);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User rachel = new Millennials("Rachel");

        //When
        String rachelUsing = rachel.sharePost();
        System.out.println(rachelUsing);
        rachel.setSocialPublisher(new TwitterPublisher());
        rachelUsing = rachel.sharePost();
        System.out.println(rachelUsing);

        //Then
        assertEquals("TWITTER", rachelUsing);
    }
}