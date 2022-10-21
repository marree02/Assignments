package inlämningsuppgift2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Main {


    public Main() {
        Path inFile = Paths.get("src/inlämningsuppgift2/Customers.txt");
        Path outFile = Paths.get("src/inlämningsuppgift2/CustomersLastSeen.txt");

        String searchPerson = IO.searchList();
        List<Person> gymPersonList = IO.readData(inFile);
        IO.findPerson(searchPerson, gymPersonList);
        IO.writeData(String.valueOf(outFile),gymPersonList, searchPerson);
    }

    public static void main(String[] args) {
        Main m = new Main();

    }
}
