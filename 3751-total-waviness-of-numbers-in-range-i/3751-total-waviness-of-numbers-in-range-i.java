class Solution {
    // Cấp phát tĩnh một lần duy nhất trên Heap khi khởi tạo Object
    private final long[][][] memo_cnt = new long[20][11][11];
    private final long[][][] memo_sum = new long[20][11][11];
    private final int[][][] memo_cnt_id = new int[20][11][11];
    private final int[][][] memo_sum_id = new int[20][11][11];
    
    private int cnt_call_id = 0;
    private int sum_call_id = 0;
    
    private final int[] digits = new int[20];
    private int n;

    public int totalWaviness(int num1, int num2) {
        return (int) (solve(num2) - solve(num1 - 1));
    }

    private long solve(long num) {
        if (num < 100) {
            return 0L;
        }
        
        // Tối ưu 1: Trích xuất chữ số bằng toán học thuần túy thay vì dùng String
        n = 0;
        long tempNum = num;
        int[] tempDigits = new int[20];
        while (tempNum > 0) {
            tempDigits[n++] = (int) (tempNum % 10);
            tempNum /= 10;
        }
        for (int i = 0; i < n; i++) {
            digits[i] = tempDigits[n - 1 - i];
        }

        // Tối ưu 2: Tăng ID cuộc gọi để xóa cache trong O(1), không dùng vòng lặp xóa mảng
        cnt_call_id++;
        sum_call_id++;

        // Trạng thái bắt đầu: pos=0, prev=10, curr=10 (10 đại diện cho trạng thái trống)
        return getSum(0, 10, 10, true, true);
    }

    // Luồng 1: Đếm số lượng cấu hình hợp lệ (Trả về kiểu primitive long, không sinh Object)
    private long getCnt(int pos, int prev, int curr, boolean isLimit, boolean isLeading) {
        if (pos == n) {
            return 1L;
        }
        
        // Tối ưu 3: Chỉ kiểm tra ID thay vì Arrays.fill, không cần check số âm nhờ State-Shifting
        if (!isLimit && !isLeading && memo_cnt_id[pos][prev][curr] == cnt_call_id) {
            return memo_cnt[pos][prev][curr];
        }

        int up = isLimit ? digits[pos] : 9;
        long ans = 0;

        for (int d = 0; d <= up; d++) {
            boolean nextLeading = isLeading && (d == 0);
            int nextPrev = nextLeading ? 10 : (isLeading ? 10 : curr);
            int nextCurr = nextLeading ? 10 : d;

            ans += getCnt(pos + 1, nextPrev, nextCurr, isLimit && (d == up), nextLeading);
        }

        if (!isLimit && !isLeading) {
            memo_cnt[pos][prev][curr] = ans;
            memo_cnt_id[pos][prev][curr] = cnt_call_id;
        }
        return ans;
    }

    // Luồng 2: Tính tổng độ biến động (Simultaneous DP kết hợp kéo dữ liệu từ Luồng 1)
    private long getSum(int pos, int prev, int curr, boolean isLimit, boolean isLeading) {
        if (pos == n) {
            return 0L;
        }

        if (!isLimit && !isLeading && memo_sum_id[pos][prev][curr] == sum_call_id) {
            return memo_sum[pos][prev][curr];
        }

        int up = isLimit ? digits[pos] : 9;
        long ans = 0;

        for (int d = 0; d <= up; d++) {
            boolean nextLeading = isLeading && (d == 0);
            int nextPrev = nextLeading ? 10 : (isLeading ? 10 : curr);
            int nextCurr = nextLeading ? 10 : d;

            // Tích lũy tổng từ bài toán con
            ans += getSum(pos + 1, nextPrev, nextCurr, isLimit && (d == up), nextLeading);

            // Kiểm tra điểm cực đại / cực tiểu của sóng
            if (!nextLeading && prev != 10 && curr != 10) {
                if ((prev < curr && curr > d) || (prev > curr && curr < d)) {
                    // Gọi Luồng 1 (O(1) từ Cache) để biết điểm này được nhân bản bao nhiêu lần
                    ans += getCnt(pos + 1, nextPrev, nextCurr, isLimit && (d == up), nextLeading);
                }
            }
        }

        if (!isLimit && !isLeading) {
            memo_sum[pos][prev][curr] = ans;
            memo_sum_id[pos][prev][curr] = sum_call_id;
        }
        return ans;
    }
}