package ru.netology.javaqadop;

public class Main {
    public static void main(String[] args) {

        BonusService service = new BonusService();
        long bonus = service.calculate(5000, true);
        System.out.println(bonus);
    }
}