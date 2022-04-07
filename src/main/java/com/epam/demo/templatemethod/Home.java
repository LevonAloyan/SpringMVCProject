package com.epam.demo.templatemethod;

public class Home extends Building {
    @Override
    protected void buildRoof() {

    }

    @Override
    protected void buildWalls() {

    }

    @Override
    protected void buildFundament() {

    }

    public static void main(String[] args) {
        Building home = new Home();

        home.build();
    }
}
