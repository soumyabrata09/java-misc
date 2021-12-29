package com.sam09.designpatterns.creational.builder;

import java.util.Objects;

public final class Address implements Cloneable{
    private String addressLine1;
    private String addressLine2;
    private String pincode;
    private String landMark;

    public Address(String addressLine1, String addressLine2, String pincode, String landMark) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.pincode = pincode;
        this.landMark = landMark;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getPincode() {
        return pincode;
    }

    public String getLandMark() {
        return landMark;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressLine1, address.addressLine1) && Objects.equals(addressLine2, address.addressLine2)
                && Objects.equals(pincode, address.pincode) && Objects.equals(landMark, address.landMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressLine1, addressLine2, pincode, landMark);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", pincode='" + pincode + '\'' +
                ", landMark='" + landMark + '\'' +
                '}';
    }
}
