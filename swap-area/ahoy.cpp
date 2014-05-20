#include <cstdio>
#include <cstdlib>
#include <string>
#include <iostream>

#define MAX 1024005
#define offset 48
using namespace std;


int T[MAX * 4];
string pirates;

inline int left(int n) { return 2*n + 1; }
inline int right(int n) { return 2*(n + 1); }

void build(int n, int i, int j) {
    if (i == j) T[n] = ((int) pirates[i]) - offset;
    else {
        int mid = (i + j) / 2;
        build(left(n), i, mid);
        build(right(n), mid+1, j);
        T[n] = T[left(n)] + T[right(n)];
    }
}
int query(int n, int i, int j, int a, int b) {
    if (j < a || i > b) return 0;
    if (a == b) return pirates[a];
    if (i >= a && j <= b) return T[n];
    int mid = (i + j) / 2;
    int p1 = query(left(n), i, mid, a, b);
    int p2 = query(right(n), mid+1, j, a, b);
    return p1 + p2;
}
void convertTo1(int n, int i, int j, int a, int b) {
    if (j < a || i > b) return;
    if (i == j) T[n] = 1;
    else {
        int mid = (i + j) / 2;
        convertTo1(left(n), i, mid, a, b);
        convertTo1(right(n), mid+1, j, a, b);
        T[n] = T[left(n)] + T[right(n)];
    }
}
void convertTo0(int n, int i, int j, int a, int b) {
    if (j < a || i > b) return;
    if (i == j) T[n] = 0;
    else {
        int mid = (i + j) / 2;
        convertTo0(left(n), i, mid, a, b);
        convertTo0(right(n), mid+1, j, a, b);
        T[n] = T[left(n)] + T[right(n)];
    }
}
void invert(int n, int i, int j, int a, int b) {
    if (j < a || i > b) return;
    if (i == j) T[n] = (T[n] == 1 ? 0 : 1);
    else {
        int mid = (i + j) / 2;
        invert(left(n), i, mid, a, b);
        invert(right(n), mid+1, j, a, b);
        T[n] = T[left(n)] + T[right(n)];
    }
}
int main() {
    int TC, M, Q, t, q, ans;

    int a, b;
    char op;

    int tc = 0;
    scanf("%d", &TC);
    while (TC--) {
        scanf("%d", &M);

        string tmp;
        pirates = "";
        for (int k=0; k < M; k++) {
            scanf("%d", &t);
            cin >> tmp;
            for (int r=0; r < t; r++) pirates += tmp;
        }
        build(0, 0, pirates.size() - 1);

        q = ans = 0;
        printf("Case %d:\n", ++tc);
        scanf("%d", &Q);
        while (Q--) {
            scanf(" %c %d %d", &op, &a, &b);
            if (op == 'F') {
                convertTo1(0, 0, pirates.size()-1, a, b);

            } else if (op == 'E') {
                convertTo0(0, 0, pirates.size()-1, a, b);

            } else if (op == 'I') {
                invert(0, 0, pirates.size()-1, a, b);

            } else {
                ans = query(0, 0, pirates.size() - 1, a, b);
                printf("Q%d: %d\n", ++q, ans);
            }
        }
    }
    return 0;
}
