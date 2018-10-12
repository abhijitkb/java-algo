package sedgewick.basic.problems.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MoveToFrontTest {
    private MoveToFront moveToFront;

    @BeforeEach
    void setup() {
        moveToFront = new MoveToFront();
    }

    @Test
    void testOffer() {
        List<Character> characters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e'));
        characters.forEach(moveToFront::offer);
        Assertions.assertEquals(characters.size(), moveToFront.size());

        Collections.reverse(characters);
        ArrayList<Character> output = new ArrayList<>();
        for(Character character : moveToFront) {
            output.add(character);
        }

        Assertions.assertEquals(output, characters);
    }

    @Test
    void testOfferWithDuplicate() {
        List<Character> characters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'a'));
        List<Character> expected = new ArrayList<>(Arrays.asList('a', 'e', 'd', 'c', 'b'));
        characters.forEach(moveToFront::offer);
        Assertions.assertEquals(expected.size(), moveToFront.size());

        ArrayList<Character> output = new ArrayList<>();
        for(Character character : moveToFront) {
            output.add(character);
        }

        Assertions.assertEquals(expected, output);
    }
}