package com.sam09.designpatterns.creational.builder;

public class UserDetails {
    private final String fName; //Required
    private final String lName; //Required
    private final int age; //Optional
    final Address address; //Optional

    /**
     *
     * @param builder builder  creates an object of UserDetails set them through the private constructor of the class
     */
    private UserDetails(UserDetailsBuilder builder) {
        this.fName = builder.fname;
        this.lName = builder.lname;
        this.age = builder.age;
        this.address = builder.address;
    }

    /**
     *
     * @return fName field's value
     */
    public String getfName() {
        return fName;
    }

    /**
     *
     * @return lName field's value
     */
    public String getlName() {
        return lName;
    }

    /**
     *
     * @return age field's value
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @return a clone of Address Object
     * @throws CloneNotSupportedException
     */
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

        /**
         *
         * @param fname
         * @param lname sets the required parameters only
         */
        public UserDetailsBuilder(String fname, String lname) {
            this.fname = fname;
            this.lname = lname;
        }

        /**
         *
         * @param age to set the optional age parameter
         * @return
         */
        public UserDetailsBuilder age(int age) {
            this.age = age;
            return this;
        }

        /**
         *
         * @param address to set the optional address parameter
         * @return
         */
        public UserDetailsBuilder address(Address address) {
            this.address = address;
            return this;
        }

        /**
         *
         * @return an UserDetails object upon calling the method
         */
        public UserDetails build() {
            UserDetails user = new UserDetails(this);
            return user;
        }
    }
}
