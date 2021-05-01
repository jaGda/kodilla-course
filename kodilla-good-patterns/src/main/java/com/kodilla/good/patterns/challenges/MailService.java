package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {

    @Override
    public void inform(User user, Product product) {

        System.out.println("Hi " + user.getName() + ",\n"
                + "congratulations on your purchase.\n"
                + "You bought " + product.getProduct() + "."
        );
    }

}
