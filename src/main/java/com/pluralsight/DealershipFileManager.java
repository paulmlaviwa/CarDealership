package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {


    public static void main(String[] args) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
            String dealershipInfo = bufferedReader.readLine();
            if (dealershipInfo != null){
                String[] dealershipInfoArray = dealershipInfo.split("\\|");
                if (dealershipInfoArray.length == 3){
                    String name = dealershipInfoArray[0];
                    String address = dealershipInfoArray[1];
                    String phone = dealershipInfoArray [2];
                    dealership = 

            }
                String line;
                if ((line = bufferedReader.readLine() != null)
            /*while((userInput = bufferedReader.readLine()) !=null){
                System.out.println(userInput);
            }

             */
            bufferedReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
