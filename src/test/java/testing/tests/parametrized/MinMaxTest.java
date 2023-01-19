package testing.tests.parametrized;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import testing.parametrized.MinMax;

class MinMaxTest {
    
    private final MinMax mm = new MinMax();

    // passage en paramétré + sélection de
    // la méthode génératrice
    @ParameterizedTest
    @MethodSource("generator")
    void testMinMax(int[] nums, int expectedMin, int expectedMax) {
        mm.find(nums);
        assertEquals(expectedMin, mm.getMin());
        assertEquals(expectedMax, mm.getMax());
    }
    
    // méthode génératice: fourni 
    // un flux d'arguments en retour
    private static Stream<Arguments> generator(){
        // critères d'acceptations: entrées et sorties attendues
        Arguments ac1 = Arguments.of(new int[]{2, 100, 33, -44}, -44, 100 );
        Arguments ac2 = Arguments.of(new int[]{7, 22, -7, 88}, -7, 88 );
        return Stream.of(ac1, ac2);
    }

}
