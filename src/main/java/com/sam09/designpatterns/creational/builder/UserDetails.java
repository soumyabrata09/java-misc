package com.sam09.designpatterns.creational.builder;

public class UserDetails {
    private final String fName; //Required
    private final String lName; //Required
    private final int age; //Optional
    final Address address; //Optional

    private UserDetails(UserDetailsBuilder builder) {
        this.fName = builder.fname;
        this.lName = builder.lname;
        this.age = builder.age;
        this.address = builder.address;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    @Override
    public String toString() {
        return "UserDetails[ " +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                ", address=" + address +
                ']';
    }

    public static class UserDetailsBuilder {
        private final String fname;
        private final String lname;
        private int age;
        Address address;


        public UserDetailsBuilder(String fname, String lname) {
            this.fname = fname;
            this.lname = lname;
        }
        public UserDetailsBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserDetailsBuilder address(Address address) {
            this.address = address;
            return this;
        }
        public UserDetails build() {
            UserDetails user = new UserDetails(this);
            return user;
        }
    }
}
