package com.epam.demo.templatemethod;

public abstract class Building {

    /**
     * the template method
     */
    protected void build() {
        // step1
        buildFundament();
        // step 2
        buildWalls();
        // step 3
        buildRoof();
    }

    protected abstract void buildRoof();

    protected abstract void buildWalls();

    protected abstract void buildFundament();
}
