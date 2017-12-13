package ru.unn.db.fitnessclub.entities;

import java.util.Date;

public class NewCardFX extends CardFX {

    private boolean isPriceSet;

    public NewCardFX(ClientFX clientFX) {
        super(new Card(new Date(), 0, clientFX.client));
    }

    private boolean isAllSet() {
        return isPriceSet;
    }


    @Override
    public void setPrice(String price) {
        isPriceSet = true;
        if (isAllSet()) super.setPrice(price);
        else card.setPrice(Integer.valueOf(price));
    }
}
