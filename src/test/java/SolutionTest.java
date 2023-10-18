import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void minimumTimeTest1() {
        int n = 3;
        int[][] relations = {
                {1, 3},
                {2, 3}
        };
        int[] time = {3, 2, 5};
        int expected = 8;
        int actual = new Solution().minimumTime(n, relations, time);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void minimumTimeTest2() {
        int n = 5;
        int[][] relations = {
                {1, 5},
                {2, 5},
                {3, 5},
                {3, 4},
                {4, 5}
        };
        int[] time = {1, 2, 3, 4, 5};
        int expected = 12;
        int actual = new Solution().minimumTime(n, relations, time);

        Assert.assertEquals(actual, expected);
    }
}
