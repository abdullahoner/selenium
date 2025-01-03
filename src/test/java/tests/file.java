package tests;

import org.apache.xmlbeans.soap.SOAPArrayType;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class file {

    @Test
    public void test() {


        System.out.println(System.getProperty("user.home"));
        String dosyaYolu = System.getProperty("user.home") + "\\Test\\deneme.txt";

        Boolean result = Files.exists(Paths.get(dosyaYolu));

        if (result) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
    public void test02(){

        //C:\Users\abdul\OneDrive\Masaüstü\abdullahOner\abdullahoner\intellij\seleniumFirstProject\pom.xml
       String dosyaYolu = "C:\\Users\\abdul\\OneDrive\\Masaüstü\\abdullahOner\\abdullahoner\\intellij\\seleniumFirstProject\\pom.xml";
        Boolean result = Files.exists(Paths.get(dosyaYolu));
        if(result){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
    }
}
