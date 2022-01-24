package adventoscode.day13;

import java.util.*;
import java.util.Collections;

public class Main {

/*  Alice would gain 54 happiness units by sitting next to Bob.
    Alice would lose 79 happiness units by sitting next to Carol.
    Alice would lose 2 happiness units by sitting next to David.
    Bob would gain 83 happiness units by sitting next to Alice.
    Bob would lose 7 happiness units by sitting next to Carol.
    Bob would lose 63 happiness units by sitting next to David.
    Carol would lose 62 happiness units by sitting next to Alice.
    Carol would gain 60 happiness units by sitting next to Bob.
    Carol would gain 55 happiness units by sitting next to David.
    David would gain 46 happiness units by sitting next to Alice.
    David would lose 7 happiness units by sitting next to Bob.
    David would gain 41 happiness units by sitting next to Carol*/



    /* Nytt för mig:
    - lägga in data som en textfil*
    - split;
    - if else kan även skrivas som - ? :
    - permutation - man kan få ut alla möjliga kombinationer av string (given a string)


    */


    public static void main(String[] args) {
        HashSet<String> people = new HashSet<>();
        HashMap<String, Integer> happiness = new HashMap<>();
        String[] input = getInput().split(".\n");
        for (String line : input) {
            String[] tokens = line.split(" ");
            int count;
                if (tokens[2].equals("gain")) {
                count = 1;
                    } else {
                    count = -1;
                }
            people.add(tokens[0]);
            people.add(tokens[10]);
            happiness.put(tokens[0] + tokens[10], Integer.parseInt(tokens[3]) * count);
        }

        int max = 0;
        for (List<String> perm : Collections.permutations(people)) {   // hämtar alla möjliga permutations
            int sum = 0;
            for (int i = 0; i < perm.size()-1; i++){
                sum += happiness.get(perm.get(i) + perm.get(i + 1)) + happiness.get(perm.get(i + 1) + perm.get(i));
            }

            sum += happiness.get(perm.get(0) + perm.get(perm.size() - 1)) + happiness.get(perm.get(perm.size() -1) + perm.get(0));
            if (sum > max) {
                max = sum;
            }

        }
        System.out.println("Maximum happines is: " + max);


    }






// Mitt puzzel input

    static String getInput() {
        return "Alice would lose 2 happiness units by sitting next to Bob.\n"
                + "Alice would lose 62 happiness units by sitting next to Carol.\n"
                + "Alice would gain 65 happiness units by sitting next to David.\n"
                + "Alice would gain 21 happiness units by sitting next to Eric.\n"
                + "Alice would lose 81 happiness units by sitting next to Frank.\n"
                + "Alice would lose 4 happiness units by sitting next to George.\n"
                + "Alice would lose 80 happiness units by sitting next to Mallory.\n"
                + "Bob would gain 93 happiness units by sitting next to Alice.\n"
                + "Bob would gain 19 happiness units by sitting next to Carol.\n"
                + "Bob would gain 5 happiness units by sitting next to David.\n"
                + "Bob would gain 49 happiness units by sitting next to Eric.\n"
                + "Bob would gain 68 happiness units by sitting next to Frank.\n"
                + "Bob would gain 23 happiness units by sitting next to George.\n"
                + "Bob would gain 29 happiness units by sitting next to Mallory.\n"
                + "Carol would lose 54 happiness units by sitting next to Alice.\n"
                + "Carol would lose 70 happiness units by sitting next to Bob.\n"
                + "Carol would lose 37 happiness units by sitting next to David.\n"
                + "Carol would lose 46 happiness units by sitting next to Eric.\n"
                + "Carol would gain 33 happiness units by sitting next to Frank.\n"
                + "Carol would lose 35 happiness units by sitting next to George.\n"
                + "Carol would gain 10 happiness units by sitting next to Mallory.\n"
                + "David would gain 43 happiness units by sitting next to Alice.\n"
                + "David would lose 96 happiness units by sitting next to Bob.\n"
                + "David would lose 53 happiness units by sitting next to Carol.\n"
                + "David would lose 30 happiness units by sitting next to Eric.\n"
                + "David would lose 12 happiness units by sitting next to Frank.\n"
                + "David would gain 75 happiness units by sitting next to George.\n"
                + "David would lose 20 happiness units by sitting next to Mallory.\n"
                + "Eric would gain 8 happiness units by sitting next to Alice.\n"
                + "Eric would lose 89 happiness units by sitting next to Bob.\n"
                + "Eric would lose 69 happiness units by sitting next to Carol.\n"
                + "Eric would lose 34 happiness units by sitting next to David.\n"
                + "Eric would gain 95 happiness units by sitting next to Frank.\n"
                + "Eric would gain 34 happiness units by sitting next to George.\n"
                + "Eric would lose 99 happiness units by sitting next to Mallory.\n"
                + "Frank would lose 97 happiness units by sitting next to Alice.\n"
                + "Frank would gain 6 happiness units by sitting next to Bob.\n"
                + "Frank would lose 9 happiness units by sitting next to Carol.\n"
                + "Frank would gain 56 happiness units by sitting next to David.\n"
                + "Frank would lose 17 happiness units by sitting next to Eric.\n"
                + "Frank would gain 18 happiness units by sitting next to George.\n"
                + "Frank would lose 56 happiness units by sitting next to Mallory.\n"
                + "George would gain 45 happiness units by sitting next to Alice.\n"
                + "George would gain 76 happiness units by sitting next to Bob.\n"
                + "George would gain 63 happiness units by sitting next to Carol.\n"
                + "George would gain 54 happiness units by sitting next to David.\n"
                + "George would gain 54 happiness units by sitting next to Eric.\n"
                + "George would gain 30 happiness units by sitting next to Frank.\n"
                + "George would gain 7 happiness units by sitting next to Mallory.\n"
                + "Mallory would gain 31 happiness units by sitting next to Alice.\n"
                + "Mallory would lose 32 happiness units by sitting next to Bob.\n"
                + "Mallory would gain 95 happiness units by sitting next to Carol.\n"
                + "Mallory would gain 91 happiness units by sitting next to David.\n"
                + "Mallory would lose 66 happiness units by sitting next to Eric.\n"
                + "Mallory would lose 75 happiness units by sitting next to Frank.\n"
                + "Mallory would lose 99 happiness units by sitting next to George.\n";
    }


}
