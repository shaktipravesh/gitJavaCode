package problems.leetcode.medium;

public class PredictTheWinner486 {
    public static void main(String[] args) {
        PredictTheWinner486 p = new PredictTheWinner486();
        int[] nums = {1,5,2};
        System.out.println(p.predictTheWinner(nums));
        nums = new int[]{1, 5, 233, 7};
        System.out.println(p.predictTheWinner(nums));
    }
    public boolean predictTheWinner(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int sum = 0;
        int player1 = 0;
        int player2 = 0;
        boolean turn = true;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        int playerOneMax = Integer.MIN_VALUE;
        playerOneMax = Math.max(playerOneMax, getPlayer1Max(player1, start, end, nums, turn));
        if(sum %2 == 1) {
            return playerOneMax >= (sum + 1) / 2;
        } else  {
            return playerOneMax >= sum / 2;
        }

    }
    private int getPlayer1Max(int player1, int start, int end, int[] nums, boolean turn) {
        if (start > end)
            return player1;

        if (turn) {
            int left = getPlayer1Max(player1 + nums[start], start + 1, end, nums, false);
            int right = getPlayer1Max(player1 + nums[end], start, end - 1, nums, false);
            return Math.max(left, right);
        } else {
            int left = getPlayer1Max(player1, start + 1, end, nums, true);
            int right = getPlayer1Max(player1, start, end - 1, nums, true);
            return Math.min(left, right);   // <-- important
        }
    }
}
