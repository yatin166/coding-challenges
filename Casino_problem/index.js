let solution = (N, K) => {
    if(K === 0)
        return N - 1;
    if(K === 1)
        return parseInt((N / 2) + 1);
    let rounds = 0,
    mod = 0;
    while(N >= 1){
        mod += N % 2;
        N = parseInt(N / 2);
        K--;
        rounds++;
        if(K === 0){
            rounds = rounds + mod + (N - 1);
            break;
        }
    }
    return rounds;
}

console.log(solution(8,0));