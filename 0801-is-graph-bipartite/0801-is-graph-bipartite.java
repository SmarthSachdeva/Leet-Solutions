class Solution {
    int[] vis;
    int[] col;
    public boolean isBipartite(int[][] graph) {
       vis=new int[graph.length];
       col=new int[graph.length];
       int i=0;
       for( i=0;i<graph.length;i++){
           if(vis[i]==0 && graph[i].length!=0){
               if(dfs(i,graph,0)==false)
               return false;
           }
           
       }
       return true;
    }

    public boolean dfs(int v,int[][] graph,int c){
        vis[v]=1;
        col[v]=c;
        System.out.println(graph[v].length);
        for(int i=0;i<graph[v].length;i++){
            if(vis[graph[v][i]]==0){
                if(dfs(graph[v][i],graph,c^1)==false)
                return false;
            }
            else if(col[v]==col[graph[v][i]])
            return false;
        }
        return true;
    }
}