class Solution {
    public List<Integer> findSmallestSetOfVertices(int num, List<List<Integer>> edges) {
        Set<Integer> incomingEdges = edges.stream()
                                          .map(edge -> edge.get(1))
                                          .collect(Collectors.toSet());
        return Stream.iterate(0, n -> n + 1)
                     .limit(num)
                     .filter(n -> !incomingEdges.contains(n))
                     .collect(Collectors.toList());
    }
}