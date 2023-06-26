class Solution {
    class P {
        int val;
        int idx;
        
        P(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }

    public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0;
        if(2*candidates >= costs.length){                      // Approach Point 1
            Arrays.sort(costs);
            for(int i=0; i<k; i++){
                ans += costs[i];
            }
            return ans;
        }

        PriorityQueue<P> pq = new PriorityQueue<>((p1,p2)->{                      // Approach Point 2
            if(p1.val == p2.val) return Integer.compare(p1.idx, p2.idx);
            return Integer.compare(p1.val, p2.val);
        });

        int first, last, temp=0;
        for(first=0; first<candidates; first++){             // Approach Point 3
            pq.add(new P(costs[first], first));
        }
        first -= 1;

        for(last=costs.length-1; temp<candidates; last--, temp++){             // Approach Point 4
            if(last <= first) break;
            pq.add(new P(costs[last], last));
        }
        last = costs.length-candidates;

        for(int i=0; i<k; i++)
        {
            P p = pq.poll();
            int val = p.val, idx = p.idx;
            ans += val;

            boolean f = false;

            if(idx <= first){               // Approach Point 5
                first += 1;
                f = true;
            }
            else {
                last -= 1;
            }

            if(first < last){                 // Approach Point 5 & 6
                if(f) pq.add(new P(costs[first], first));
                else pq.add(new P(costs[last], last)); 
            }
        }

        return ans;
    }
}