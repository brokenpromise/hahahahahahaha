import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 测试类：_2022111573_3_Test.java
 * 测试目的：对 Solution3 类中的 largestDivisibleSubset 方法进行单元测试
 *
 * 测试原则：
 * - 等价类划分原则：根据输入的不同情况（例如输入为空数组、包含重复元素、正常情况等）来设计不同的测试用例。
 * - 边界值分析：考虑极端输入，例如只有一个元素的数组、数组中包含最大值等情况。
 * - 逻辑覆盖：确保每个方法的核心逻辑都能被充分测试。
 */

public class _2022111573_3_Test {

    /**
     * 测试目标：
     * 测试普通情况下的最大整除子集。
     * 测试用例：nums = [1, 2, 3]
     */
    @Test
    public void testLargestDivisibleSubset_Normal() {
        // 测试用例设计：正常情况下，数组中有多个元素，求最大整除子集。
        Solution3 solution = new Solution3();
        int[] nums = {1, 2, 3};
        List<Integer> result = solution.largestDivisibleSubset(nums);

        // 预期结果：子集 [1, 2] 或 [1, 3] 都是正确答案。
        assertTrue(result.contains(1));
        assertTrue(result.contains(2) || result.contains(3));
        assertTrue(result.size() == 2);
    }

    /**
     * 测试目标：
     * 测试一个包含重复元素的输入。
     * 测试用例：nums = [1, 2, 4, 8]
     */
    @Test
    public void testLargestDivisibleSubset_DuplicateValues() {
        // 测试用例设计：包含多个整除关系的数字，测试最大的整除子集。
        Solution3 solution = new Solution3();
        int[] nums = {1, 2, 4, 8};
        List<Integer> result = solution.largestDivisibleSubset(nums);

        // 预期结果：子集 [1, 2, 4, 8]
        assertEquals(Arrays.asList(1, 2, 4, 8), result);
    }

    /**
     * 测试目标：
     * 测试数组为空时的情况。
     * 测试用例：nums = []
     */
    @Test
    public void testLargestDivisibleSubset_EmptyArray() {
        // 测试用例设计：数组为空时，返回空数组。
        Solution3 solution = new Solution3();
        int[] nums = {};
        List<Integer> result = solution.largestDivisibleSubset(nums);

        // 预期结果：空数组
        assertTrue(result.isEmpty());
    }

    /**
     * 测试目标：
     * 测试只有一个元素的输入。
     * 测试用例：nums = [5]
     */
    @Test
    public void testLargestDivisibleSubset_SingleElement() {
        // 测试用例设计：只有一个元素的情况，最大整除子集只能是该元素本身。
        Solution3 solution = new Solution3();
        int[] nums = {5};
        List<Integer> result = solution.largestDivisibleSubset(nums);

        // 预期结果：子集 [5]
        assertEquals(Arrays.asList(5), result);
    }

    /**
     * 测试目标：
     * 测试包含大范围数值的情况，确保方法在大数值下的正确性。
     * 测试用例：nums = [1, 100000, 1000000]
     */
    @Test
    public void testLargestDivisibleSubset_LargeValues() {
        // 测试用例设计：数组中包含很大的数值，测试方法是否能正确处理。
        Solution3 solution = new Solution3();
        int[] nums = {1, 100000, 1000000};
        List<Integer> result = solution.largestDivisibleSubset(nums);

        // 预期结果：子集 [1, 100000, 1000000]，因为1000000能被100000整除，100000能被1整除。
        assertTrue(result.contains(1));
        assertTrue(result.contains(100000));
        assertTrue(result.contains(1000000));
    }

    /**
     *
     * 测试目标：
     * 测试数组中有元素无法与其他元素整除的情况。
     * 测试用例：nums = [3, 5, 7]
     */
    @Test
    public void testLargestDivisibleSubset_NoDivisible() {
        Solution3 solution = new Solution3();
        int[] nums = {3, 5, 7};  // 没有整除关系
        List<Integer> result = solution.largestDivisibleSubset(nums);

        // 预期结果：任意一个元素的子集，例如 [3]、[5] 或 [7]，长度为1
        assertEquals(1, result.size());
        // 你也可以根据具体的结果来验证
        assertTrue(result.contains(3) || result.contains(5) || result.contains(7));
}
}
