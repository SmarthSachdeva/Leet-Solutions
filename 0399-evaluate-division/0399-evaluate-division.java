class Solution {

    class Exp {
        double val;
        String var;
        public Exp(double val, String var) {
            this.val = val;
            this.var = var;
        }
    }

    HashMap<String, List<Exp>> map;
    double[] res;

    public double[] calcEquation(List<List<String>> eqs, double[] values, List<List<String>> queries) {
        map = new HashMap();
        for (int i = 0; i < eqs.size(); i++) {
            if (!map.containsKey(eqs.get(i).get(0))) map.put(eqs.get(i).get(0), new ArrayList());
            map.get(eqs.get(i).get(0)).add(new Exp(values[i], eqs.get(i).get(1)));

            if (!map.containsKey(eqs.get(i).get(1))) map.put(eqs.get(i).get(1), new ArrayList());
            map.get(eqs.get(i).get(1)).add(new Exp(1 / values[i], eqs.get(i).get(0)));
        }

        res = new double[queries.size()];

        // for (Map.Entry<String, List<Exp>> entry : map.entrySet()) {
        //     System.out.print(entry.getKey() + " -> ");
        //     for (Exp exp : entry.getValue()) {
        //         System.out.print(exp.val + "*" + exp.var + ",");
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String e = queries.get(i).get(1);
            if (!map.containsKey(x) || !map.containsKey(e)) {
                res[i] = -1.0;
                continue;
            }
            myFun(i, new ArrayList(), x, 1.0, e);
            if (res[i] == 0.0) res[i] = -1.0;
        }

        return res;
    }

    public void myFun(int ind, List<String> path, String curr, double c, String end) {
        if (path.contains(curr) || res[ind] != 0.0) return;
        // System.out.println(curr + "," + end);
        if (curr.equals(end) && res[ind] == 0.0) {
            // System.out.println("Inside!!!");
            res[ind] = c;
            return;
        }
        path.add(curr);
        for (Exp exp : map.get(curr)) {
            // if (exp.var == end) {
            //     res[ind] = c*exp.val;
            //     return;
            // }
            myFun(ind, new ArrayList(path), exp.var, c * exp.val, end);
        }
    }
}