package zebra;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

/*
 * Based on http://www.dcs.gla.ac.uk/~pat/jchoco/zebra/Zebra.java
 * Ported to Choco version 4.0.6
 */
public class Zebra {
    public static void main(final String[] args) {
        final Model m = new Model();

        final IntVar[] color = m.intVarArray("color", 5, 0, 4, true); // red, blue, yellow, green ivory
        final IntVar[] cigarette = m.intVarArray("cigarette", 5, 0, 4, true); // oldGold, Parli, Kools, Lucky, Chest
        final IntVar[] nationality = m.intVarArray("nationality", 5, 0, 4, true); // Norge, Ukr, Eng, Spain, Jap
        final IntVar[] pet = m.intVarArray("pet", 5, 0, 4, true); // zebra, dog, horse, fox, snails
        final IntVar[] drink = m.intVarArray("drink", 5, 0, 4, true); // coffee, tea, h2o, milk, oj

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

        m.allDifferent(color).post();
        m.allDifferent(cigarette).post();
        m.allDifferent(nationality).post();
        m.allDifferent(pet).post();
        m.allDifferent(drink).post();

        red.eq(eng).post();                   // The Englishman lives in the red house.
        spain.eq(dog).post();                 // The Spaniard owns the dog.
        green.eq(coffee).post();              // Coffee is drunk in the green house.
        ukr.eq(tea).post();                   // The Ukrainian drinks tea.
        green.sub(ivory).eq(1).post();        // The green house is immediately to the right of the ivory house.
        oldGold.eq(snails).post();            // The Old Gold smoker owns snails.
        kools.eq(yellow).post();              // Kools are smoked in the yellow house.
        milk.eq(2).post();                    // Milk is drunk in the middle house.
        norge.eq(0).post();                   // The Norwegian lives in the first house.
        chest.sub(fox).abs().eq(1).post();    // The man who smokes Chesterfields lives in the house next to the man with the fox.
        kools.sub(horse).abs().eq(1).post();  // Kools are smoked in the house next to the house where the horse is kept.
        lucky.eq(oj).post();                  // The Lucky Strike smoker drinks orange juice.
        jap.eq(parly).post();                 // The Japanese smokes Parliaments.
        norge.sub(blue).abs().eq(1).post();   // The Norwegian lives next to the blue house.

        final Solver s = m.getSolver();
        System.out.println(s.solve());
        System.out.println();
        System.out.println("Water is drunk by the " + nationalityNames[h2o.getValue()]);
        System.out.println("The zebra is owned by the " + nationalityNames[zebra.getValue()]);
        System.out.println();
        System.out.println("| House        |       1      |       2      |       3      |       4      |       5      |");

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