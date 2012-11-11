package bera.phonebook;


public class Entry {
    private String name;
    private Integer phoneNumber;

    public Entry(String name, Integer phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }
}
