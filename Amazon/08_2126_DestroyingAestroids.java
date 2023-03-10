class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {     
        List<Integer> sorted = Arrays.stream(asteroids)
            .sorted()
            .boxed()
            .collect(Collectors.toList());
        long currentMass = mass;
        for (int x : sorted) {
            if (x > currentMass) {
                return false;
            }
            currentMass += x;
        }
        return true;
    }
}
