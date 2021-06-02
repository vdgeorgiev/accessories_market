package com.example.PhoneAccessories.Converter;

import org.joda.money.Money;

import javax.persistence.AttributeConverter;

public class MoneyConverter implements AttributeConverter<Money,String> {
    @Override
    public String convertToDatabaseColumn(Money money) {
        return money.toString();
    }

    @Override
    public Money convertToEntityAttribute(String price) {
        return Money.parse(price);
    }
}
