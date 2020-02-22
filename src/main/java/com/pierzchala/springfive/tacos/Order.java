package com.pierzchala.springfive.tacos;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Order {

    @Length(min = 1, max = 15, message = "Pole nie może być puste")
    @NotBlank(message = "Podanie imienia i nazwiska jest obowiązkowe.")
    private String name;

    @NotBlank(message = "Podanie ulicy jest obowiązkowe.")
    private String street;

    @NotBlank(message = "Podanie miejscowości jest obowiązkowe.")
    private String city;

    @NotBlank(message = "Podanie województwa jest obowiązkowe.")
    private String state;

    @NotBlank(message = "Podanie kodu pocztowego jest obowiązkowe.")
    private String zip;

    @CreditCardNumber(message = "To nie jest prawidłowy numer karty kredytowej.")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Wartość musi być w formacie MM/RR.")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Nieprawidłowy kod CVV.")
    private String ccCVV;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }
}
