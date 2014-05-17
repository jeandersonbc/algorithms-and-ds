#include <cstdio>

#define NIL -1
#define MAXN 100

int A[MAXN], T[MAXN*2];
inline int left(int n) { return 2*n + 1; }
inline int right(int n) { return 2*(n + 1); }

int min(int a, int b) {
    if (a == NIL) return b;
    if (b == NIL) return a;
    return a < b ? a : b;
}

void build(int n, int i, int j) {
    if (i == j) {
        T[n] = A[i];

    } else {
        int mid = (i+j) / 2;
        build(left(n), i, mid);
        build(right(n), mid+1, j);
        T[n] = min(T[left(n)], T[right(n)]);
    }
}

int query(int n, int i, int j, int a, int b) {
    if (j < a || i > b) return NIL;
    if (a == b) return A[a];
    if (i >= a && j <= b) return T[n];
    int mid = (i + j)/2;
    int p1 = query(left(n), i, mid, a, b);
    int p2 = query(right(n), mid+1, j, a, b);
    return min(p1, p2);
}

int main() {
    // Dummy data
    int N = 10;
    for (int i=0; i < N; i++) {
        A[i] = i;
    }
    build(0, 0, N-1);

    int TC, a, b;
    scanf("%d", &TC);
    while(TC--) {
        scanf("%d %d", &a, &b);
        printf("%d\n", query(0, 0, N-1, a, b));
    }
    return 0;
}
