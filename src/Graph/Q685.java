package Graph;

public class Q685 {
    int[] father = new int[1001];
    public int[] findRedundantDirectedConnection(int[][] edges) {
        init();
        for(int i=0;i<edges.length;i++){
            if(isSame(edges[i][0],edges[i][1])){
                return edges[i];
            }else{
                join(edges[i][0],edges[i][1]);
            }
        }
        return null;
    }

    public void init(){
        for(int i=1;i<father.length;i++){
            father[i]=i;
        }
    }

    public int find(int u){
        if(u==father[u]){
            return u;
        }else{
            father[u]=find(father[u]);
            return father[u];
        }
    }

    public boolean isSame(int u,int v){
       u=find(u);
       v=find(v);
       return u==v;
    }

    public void join(int u,int v){
        u=find(u);
        v=find(v);
        if(u==v) return;
        father[v]=u;
    }

}
