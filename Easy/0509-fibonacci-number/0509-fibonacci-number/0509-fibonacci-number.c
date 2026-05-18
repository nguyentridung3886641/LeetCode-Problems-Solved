int memo[31] = {[0 ... 30] = - 1};

int solve(int n) {
    if (n <= 1) return n;
    if (memo[n] != -1) return memo[n];
    return memo[n] = solve(n - 1) + solve(n - 2);
}

int fib(int n){
    return solve(n);
}
