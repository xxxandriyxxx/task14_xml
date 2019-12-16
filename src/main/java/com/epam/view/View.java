package com.epam.view;

import com.epam.controller.Controller;
import com.epam.controller.ControllerImpl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private Controller controller;
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public View() {
        controller = new ControllerImpl();
        controller = new ControllerImpl();
        menu = new LinkedHashMap<>();
        menu.put("1", " 1 - parse 'tariffs.xml' using DOM");
        menu.put("2", " 2 - parse 'tariffs.xml' using SAX");
        menu.put("3", " 3 - parse 'tariffs.xml' using StAX");
        menu.put("4", " 4 - validate 'tariffs.xml' using DOM validator");
        menu.put("5", " 5 - validate 'tariffs.xml' using SAX validator");
        menu.put("6", " 6 - validate 'tariffs.xml' using StAX validator");
        menu.put("7", " 7 - transform 'tariffs.xml' to html file");
        menu.put("8", " 8 - transform 'tariffs.xml' to html file sorted by field 'payroll'");
        menu.put("Q", " q - exit");
        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::parseByDOM);
        methodsMenu.put("2", this::parseBySAX);
        methodsMenu.put("3", this::parseByStAX);
        methodsMenu.put("4", this::validateByDOM);
        methodsMenu.put("5", this::validateBySAX);
        methodsMenu.put("6", this::validateByStAX);
        methodsMenu.put("7", this::transformToHtml);
        methodsMenu.put("8", this::transformToHtmlSortedByPayroll);
    }

    private void parseByDOM() {
        controller.parseByDOM();
    }

    private void parseBySAX() {
        controller.parseBySAX();
    }

    private void parseByStAX() {
        controller.parseByStAX();
    }

    private void validateByDOM() {
        controller.validateByDOM();
    }

    private void validateBySAX() {
        controller.validateBySAX();
    }

    private void validateByStAX() {
        controller.validateByStAX();
    }

    private void transformToHtml() {
        controller.transformToHtml();
    }

    private void transformToHtmlSortedByPayroll() {
        controller.transformToHtmlSortedByPayroll();
    }


    private void outputMenu() {
        System.out.println("\n==================== MENU ====================");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("----------------------------------------------");
            System.out.println("Enter the menu point:");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }
}
