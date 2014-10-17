int partition(int *values, int i, int j) {
    return 0;
}
void sort(int *values, int i, int j) {
    if (i == j) return;
    int p = partition(values, i, j);
    sort(values, i, p-1);
    sort(values, p+1, j);
}
bool is_sorted(int *values, int n) {
    for (int i=0; i<n-1; i++) {
        if (values[i] > values[i+1])
            return false;
    }
    return true;
}
