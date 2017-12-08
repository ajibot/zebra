# Zebra Puzzle

Java implementation of the [Zebra Puzzla](https://en.wikipedia.org/wiki/Zebra_Puzzle)

Mini constraint satisfaction library inspired by the [Choco Solver](http://www.choco-solver.org/)

Based on <http://www.dcs.gla.ac.uk/~pat/jchoco/zebra/Zebra.java>

Preview:

```java
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
```
