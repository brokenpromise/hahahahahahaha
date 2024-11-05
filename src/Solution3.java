import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 *
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 *
 */
class Solution3 {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int len = nums.length;  // 修改为 nums.length 而不是 nums.length - 1

        // 如果数组为空，直接返回空集合
        if (len == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);  // 将数组排序，排序后，整除关系更容易找到

        // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
        int[] dp = new int[len];  // dp[i]表示以 nums[i] 为结尾的最大整除子集的大小
        Arrays.fill(dp, 1);  // 初始化 dp 数组，所有元素的子集大小至少为 1
        int maxSize = 1;  // 最大子集的大小，最初是 1
        int maxValIndex = 0;  // 用来记录最大子集的末尾元素的索引

        for (int i = 1; i < len; i++) {  // 从第二个元素开始遍历
            for (int j = 0; j < i; j++) {  // 比较每个元素 nums[i] 和之前的元素 nums[j]
                if (nums[i] % nums[j] == 0) {  // 如果 nums[i] 能被 nums[j] 整除
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // 更新 dp[i]，选择更大的子集
                }
            }

            if (dp[i] > maxSize) {  // 更新最大子集的信息
                maxSize = dp[i];
                maxValIndex = i;  // 记录最大子集末尾元素的索引
            }
        }

        // 第 2 步：倒推获得最大子集
        List<Integer> res = new ArrayList<>();  // 用于存储结果
        while (maxSize > 0) {  // 只要子集的大小不为0，就继续倒推
            if (dp[maxValIndex] == maxSize) {  // 只添加符合子集大小的元素
                res.add(nums[maxValIndex]);  // 将符合条件的元素加入结果
                maxSize--;  // 子集大小减 1
            }
            maxValIndex--;  // 继续倒推
        }

        // 由于倒推时是从后往前添加的，结果需要反转
        Collections.reverse(res);
        return res;  // 返回最大整除子集
    }
}
