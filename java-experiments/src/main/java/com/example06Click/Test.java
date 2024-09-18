package com.example06Click;

public class Test {
    public static void main(String[] args) {
        Button buttonA = new Button("ButtonA");
        buttonA.setClick(new Click() {
            @Override
            public void onClick() {
                System.out.println("ButtonA");
            }
        });
        Button buttonB = new Button("ButtonB");
        buttonB.setClick(new Click() {
            @Override
            public void onClick() {
                System.out.println("ButtonB");
            }
        });
        buttonA.click();
        buttonB.click();
    }
}