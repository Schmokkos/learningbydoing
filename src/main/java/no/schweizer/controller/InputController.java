package no.schweizer.controller;

import java.util.Scanner;

public class InputController {

    private Scanner scan = new Scanner(System.in);

    public final String simpleInput(String text, String errortext, String rules){
        System.out.print(text);
        String a = scan.nextLine();
        if (!a.matches(rules)){
            System.out.println(errortext);
            return simpleInput(text, errortext, rules);
        }
        return a;
    }
}