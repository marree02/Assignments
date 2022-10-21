package inlämningsuppgift2;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class IO {

    public static List<Person> readData(Path inFile) {
        List<Person> list = new ArrayList<>();
        String firstLine = "";
        String secondLine = "";

        try (Scanner scan = new Scanner(inFile)) {

            while (scan.hasNextLine()) {
                firstLine = scan.nextLine();
                secondLine = scan.nextLine();

                String[] firstArr = firstLine.split(",");
                String[] secondArr = secondLine.split(",");

                Person p = new Person(firstArr[0].trim(), firstArr[1].trim(), secondArr[0].trim());
                list.add(p);

            }


        } catch (IOException e) {
            System.out.println("Fel inträffade vid läsning från fil");
            e.printStackTrace();
            System.exit(0);
        }
        return list;
    }

    public static String searchList() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Sök kund i registret: ");

        return scan.nextLine();
        }


    public static void findPerson(String searchPerson, List<Person> gymPersonList) {


           for (Person person : gymPersonList) {
               if (person.getName().equals(searchPerson) || person.getSecuritynumber().equals(searchPerson)) {
                   System.out.println(" Name: " + person.getName() + " \n Social security number: " + person.getSecuritynumber()
                           + "\n Last paied member ship: " + person.getLastPaied());

                   LocalDate lastPaied = LocalDate.parse(person.getLastPaied());
                   LocalDate oneYear = LocalDate.now().minusYears(1);

                   if (lastPaied.isAfter(oneYear)) {
                       System.out.println("Yearly fee is paied");
                   } else if (lastPaied.isBefore(oneYear)) {
                       System.out.println("Pay the yearly fee");
                   }

               }
           }
    }

    public static void writeData(String writeFile, List<Person> gymPersonList, String searchPerson){
        Path outFilePath = Paths.get(writeFile);
        LocalDate today = LocalDate.now();

       try {
           PrintWriter ut = new PrintWriter(new BufferedWriter(new FileWriter(outFilePath.toFile(),true)));
           for (Person person : gymPersonList) {
               if(person.getName().equals(searchPerson) || person.getSecuritynumber().equals(searchPerson)) {
                   ut.write("Customer Name: " + person.getName() + "\n Last seen " + today);
                   ut.write("\n");
               }
           }

           ut.close();
       }
       catch (IOException e) {
           throw new RuntimeException(e);
       }

    }

}




