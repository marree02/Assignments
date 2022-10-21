package inlämningsuppgift2;

import java.util.List;

public class Person {

    private final String Securitynumber;
    private final String Name;
    private final String lastPaied;

    public Person(String securitynumber, String name, String lastPaied) {
        this.Securitynumber = securitynumber;
        this.Name = name;
        this.lastPaied = lastPaied;
    }


    public String getSecuritynumber() {
        return Securitynumber;
    }

    public String getName() {
        return Name;
    }

    public String getLastPaied() {
        return lastPaied;
    }

    @Override
    public String toString() {
        return "Name: " + Name + " Securitynumber: " + Securitynumber + " \n " + " Last paied " + lastPaied;
    }
}
