class StockSpanner {
    int[] spans;
    int[] prices;

    public StockSpanner() {
        spans = new int[10005];
        prices = new int[10005];
    }
    
    int peek = -1, curIdx = -1;
    public int next(int price) {
        int span = 1;
        prices[++curIdx] = price;

        while (peek >= 0 && prices[curIdx - span] <= price) {
            span += spans[peek--];
        }

        spans[++peek] = span;

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */