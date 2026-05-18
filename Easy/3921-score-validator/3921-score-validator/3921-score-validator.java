class Solution {
    public int[] scoreValidator(String[] events) {
        int length = events.length;
        int count = 0;
        int score = 0;
        int i = 0;
        while (i < length && count < 10) {
            switch (events[i]) {
                case "0":
                    break;
                case "1":
                    ++score;
                    break;
                case "2":
                    score += 2;
                    break;
                case "3":
                    score += 3;
                    break;
                case "4":
                    score += 4;
                    break;
                case "6":
                    score += 6;
                    break;
                case "W":
                    ++count;
                    break;
                case "WD":
                    ++score;
                    break;
                case "NB":
                    ++score;
                    break;
            }
            i++;
        }
        return new int[]{score, count};
    }
}