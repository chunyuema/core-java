package com.chunyue.generics;

public class InheritanceAndSubtypingDemoMain {

    // this is perfectly fine since orange juice extended juice
    Juice j = new OrangeJuice();

    // this is not okay since Glass<Juice> and Glass<OrangeJuice>
    // are treated as a whole, hence they are not the same thing
    // Glass<Juice> juiceGlass = new Glass<OrangeJuice>();

    // Glass<Liquid> wineGlass = new WineGlass<Juice> is not correct => type arguments need to match
}
