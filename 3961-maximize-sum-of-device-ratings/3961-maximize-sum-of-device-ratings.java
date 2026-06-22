class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        long[] minVal    = new long[m];
        long[] secMinVal = new long[m];

        for (int i = 0; i < m; i++) {
            int[] row = units[i].clone();
            Arrays.sort(row);
            minVal[i]    = row[0];
            secMinVal[i] = (row.length > 1) ? row[1] : 0;
        }

        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> Long.compare(minVal[a], minVal[b]));

        long[] sortedMin    = new long[m];
        long[] sortedSecMin = new long[m];
        for (int i = 0; i < m; i++) {
            sortedMin[i]    = minVal[idx[i]];
            sortedSecMin[i] = secMinVal[idx[i]];
        }

        long[] prefMin = new long[m + 1];
        for (int i = 0; i < m; i++) prefMin[i + 1] = prefMin[i] + sortedMin[i];
        long[] sufSecMin = new long[m + 1];
        for (int i = m - 1; i >= 0; i--) sufSecMin[i] = sufSecMin[i + 1] + sortedSecMin[i];

        long[] sufMinSecMin = new long[m + 1];
        sufMinSecMin[m] = Long.MAX_VALUE;
        for (int i = m - 1; i >= 0; i--) {
            sufMinSecMin[i] = Math.min(sortedSecMin[i], sufMinSecMin[i + 1]);
        }
        long ans = 0;
        for (int p = 0; p < m; p++) {
            long caseA = prefMin[p] + sortedMin[p] + sufSecMin[p + 1];
            ans = Math.max(ans, caseA);

            if (p + 1 < m && sufMinSecMin[p + 1] != Long.MAX_VALUE) {
                long caseB = prefMin[p]
                           + sortedMin[p] + sortedSecMin[p]
                           + sufSecMin[p + 1]
                           - sufMinSecMin[p + 1];
                ans = Math.max(ans, caseB);
            }
        }

        return ans;
    }
}