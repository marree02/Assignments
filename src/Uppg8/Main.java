package Uppg8;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {



    public Main() throws FileNotFoundException {
        Double[] temp = new Double[30];
        String score;
        int i = 0;
        try (BufferedReader buf = new BufferedReader(new FileReader("src/Uppg8/temp.txt"))){
            while((score = buf.readLine()) != null) {
                temp[i] = Double.valueOf(score);
                i++;
            }
            Arrays.sort(temp);
            for(double i1 : temp){

                score = String.valueOf(i1);
                System.out.println(score);
            }
            double result = 0;
            for(int j = 0; j <= 30 ;j++){
               result = result += temp[j] /= 30;
                System.out.println(result);
            }


        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (RuntimeException | IOException e) {

        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        Main m = new Main();

    }
}
