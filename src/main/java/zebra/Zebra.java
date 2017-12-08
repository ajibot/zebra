package zebra;

import minicsp.IntVar;
import minicsp.Model;
import minicsp.Solver;

/*
 * Based on http://www.dcs.gla.ac.uk/~pat/jchoco/zebra/Zebra.java
 */
public class Zebra {
    public static void main(final String[] args) {
        final Model m = new Model();

        final IntVar[] color = m.intVarArray(5, 0, 4);
        final IntVar[] cigarette = m.intVarArray(5, 0, 4);
        final IntVar[] nationality = m.intVarArray(5, 0, 4);
        final IntVar[] pet = m.intVarArray(5, 0, 4);
        final IntVar[] drink = m.intVarArray(5, 0, 4);

        final String[] colorNames = { "Red", "Blue", "Yellow", "Green", "Ivory" };
        final IntVar red = color[0];
        final IntVar blue = color[1];
        final IntVar yellow = color[2];
        final IntVar green = color[3];
        final IntVar ivory = color[4];

        final String[] cigaretteNames = { "Old Gold", "Parliament", "Kools", "Lucky", "Chesterfield" };
        final IntVar oldGold = cigarette[0];
        final IntVar parly = cigarette[1];
        final IntVar kools = cigarette[2];
        final IntVar lucky = cigarette[3];
        final IntVar chest = cigarette[4];

        final String[] nationalityNames = { "Norwegian", "Ukranian", "Englishman", "Spaniard", "Japanese" };
        final IntVar norge = nationality[0];
        final IntVar ukr = nationality[1];
        final IntVar eng = nationality[2];
        final IntVar spain = nationality[3];
        final IntVar jap = nationality[4];

        final String[] petNames = { "Zebra", "Dog", "Horse", "Fox", "Snails" };
        final IntVar zebra = pet[0];
        final IntVar dog = pet[1];
        final IntVar horse = pet[2];
        final IntVar fox = pet[3];
        final IntVar snails = pet[4];

        final String[] drinkNames = { "Coffee", "Tea", "Water", "Milk", "Orange Juice" };
        final IntVar coffee = drink[0];
        final IntVar tea = drink[1];
        final IntVar h2o = drink[2];
        final IntVar milk = drink[3];
        final IntVar oj = drink[4];

        m.allDifferent(color);
        m.allDifferent(cigarette);
        m.allDifferent(nationality);
        m.allDifferent(pet);
        m.allDifferent(drink);

        m.add(eng.eq(red));                   // The Englishman lives in the red house.
        m.add(spain.eq(dog));                 // The Spaniard owns the dog.
        m.add(coffee.eq(green));              // Coffee is drunk in the green house.
        m.add(ukr.eq(tea));                   // The Ukrainian drinks tea.
        m.add(green.sub(ivory).eq(1));        // The green house is immediately to the right of the ivory house.
        m.add(oldGold.eq(snails));            // The Old Gold smoker owns snails.
        m.add(kools.eq(yellow));              // Kools are smoked in the yellow house.
        m.add(milk.eq(2));                    // Milk is drunk in the middle house.
        m.add(norge.eq(0));                   // The Norwegian lives in the first house.
        m.add(chest.sub(fox).abs().eq(1));    // The man who smokes Chesterfields lives in the house next to the man with the fox.
        m.add(kools.sub(horse).abs().eq(1));  // Kools are smoked in the house next to the house where the horse is kept.
        m.add(lucky.eq(oj));                  // The Lucky Strike smoker drinks orange juice.
        m.add(jap.eq(parly));                 // The Japanese smokes Parliaments.
        m.add(norge.sub(blue).abs().eq(1));   // The Norwegian lives next to the blue house.

        final Solver s = new Solver(m);
        System.out.println(s.solve());
        System.out.println();
        System.out.println("Water is drunk by the " + nationalityNames[h2o.getValue()]);
        System.out.println("The zebra is owned by the " + nationalityNames[zebra.getValue()]);
        System.out.println();

        printRow("Color", color, colorNames);
        printRow("Nationality", nationality, nationalityNames);
        printRow("Drink", drink, drinkNames);
        printRow("Smoke", cigarette, cigaretteNames);
        printRow("Pet", pet, petNames);
    }


    static void printRow(final String key, final IntVar[] values, final String[] names) {
        System.out.printf("| %-12s |", key);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (values[j].getValue() == i) {
                    System.out.printf(" %-12s |", names[j]);
                }
            }
        }
        System.out.println();
    }
}
