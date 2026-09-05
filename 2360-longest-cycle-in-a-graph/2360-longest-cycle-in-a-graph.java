class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        // stepTrack[i] mang 3 ý nghĩa trạng thái:
        // 0: Chưa từng thăm (White)
        // > 0: Đang thăm trong nhánh duyệt hiện tại, giá trị là thứ tự bước chân (Gray)
        // < 0: Đã duyệt xong hoàn toàn và không thuộc chu trình nào cần xét lại (Black)
        int[] stepTrack = new int[n];
        int maxCycleLength = -1;
        int currentStep = 1;

        for (int i = 0; i < n; i++) {
            if (stepTrack[i] != 0) {
                continue;
            }

            int startStep = currentStep;
            int curr = i;

            // 1. Duyệt xuôi theo cạnh duy nhất
            while (curr != -1 && stepTrack[curr] == 0) {
                stepTrack[curr] = currentStep++;
                curr = edges[curr];
            }

            // 2. Kiểm tra chu trình: 
            // Nếu curr != -1 và stepTrack[curr] >= startStep 
            // nghĩa là curr được gán bước chân trong CHÍNH LẦN DUYỆT NÀY -> Bắt được chu trình!
            if (curr != -1 && stepTrack[curr] >= startStep) {
                int cycleLength = currentStep - stepTrack[curr];
                maxCycleLength = Math.max(maxCycleLength, cycleLength);
            }

            // 3. Đánh dấu toàn bộ nhánh vừa duyệt thành trạng thái đã chốt (Black)
            // Bằng cách gán giá trị âm để các lần duyệt sau bỏ qua ngay lập tức
            curr = i;
            while (curr != -1 && stepTrack[curr] > 0) {
                stepTrack[curr] = -1;
                curr = edges[curr];
            }
        }

        return maxCycleLength;
    }
}