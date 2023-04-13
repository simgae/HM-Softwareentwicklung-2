package edu.hm.gaertner.simon.lab23.a22;

import edu.hm.cs.rs.se.ss23.a22.ThinLine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TheThinLineTest {
    @Test
    public void lastAt(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        final int want = -1;


        assertEquals(want, many.lastAt());
    }

    @Test
    public void lastAtWithValue(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.replace(1, 1);

        final int want = 1;


        assertEquals(want, many.lastAt());
    }

    @Test
    public void lastAtWithHighValue(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.replace(10000, 1);

        final int want = 10000;


        assertEquals(want, many.lastAt());
    }

    @Test
    public void defaultCtor(){

        ThinLine<Integer> many = new TheThinLine<>();


        assertEquals(null, many.read(1));
    }

    @Test
    public void insertWithPush(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(2, 1);
        many.insert(2,2);

        final Integer want = 2;


        assertEquals(want, many.read(2));
    }

    @Test
    public void insertWithoutPush(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(2, 1);
        many.insert(3,2);

        final Integer want = 2;


        assertEquals(want, many.read(3));
    }

    @Test
    public void insertWithPushLessThan(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(2, 1);
        many.insert(1,2);

        final Integer want = 1;


        assertEquals(want, many.read(3));
    }

    @Test
    public void insertNoPush(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(2, 1);
        many.insert(3,2);

        final Integer want = 2;


        assertEquals(want, many.read(3));
    }

    @Test
    public void replaceNonDefault(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.replace(2,2);
        final Integer want = 2;


        assertEquals(want, many.read(2));
    }

    @Test
    public void replaceWithDefault(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(2,2);
        many.replace(2,0);
        final Integer want = 0;


        assertEquals(want, many.read(2));
    }

    @Test
    public void replaceInside(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(2,2);
        many.insert(1,2);
        many.insert(2,2);
        many.replace(2,3);
        final Integer want = 3;


        assertEquals(want, many.read(2));
    }

    @Test
    public void delete(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(2,2);
        many.delete(2);
        final Integer want = 0;


        assertEquals(want, many.read(2));
    }

    @Test
    public void deletePullBack(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(2,2);
        many.insert(3,3);
        many.delete(2);
        final Integer want = 3;


        assertEquals(want, many.read(2));
    }

    @Test
    public void deleteTestReturn(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(2,2);
        many.insert(3,3);
        final Integer have = many.delete(2);
        final Integer want = 2;


        assertEquals(want, have);
    }

    @Test
    public void deleteWithoutPullBack(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(2,2);
        many.insert(3,3);
        many.delete(3);
        final Integer want = 2;


        assertEquals(want, many.read(2));
    }

    @Test
    public void deleteInvalidParameter(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(2,2);
        many.insert(3,3);
        many.delete(10);
        final Integer want = 2;


        assertEquals(want, many.read(2));
    }

    @Test
    public void replaceWithDefaultValue(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(2,2);
        many.insert(3,3);
        many.replace(3,0);
        final int want = 2;


        assertEquals(want, many.lastAt());
    }

    @Test
    public void deleteTwoBefore(){

        ThinLine<Integer> many = new TheThinLine<>(0);

        many.insert(1,2);
        many.insert(3,4);
        many.insert(3,4);

        many.delete(2);
        final Integer want = 4;


        assertEquals(want, many.read(3));
    }


}
