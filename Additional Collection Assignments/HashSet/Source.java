import java.util.*;


public class Source {
    public Set<Integer> union(Set<Integer> a, Set<Integer> b){
        Set<Integer> union = new HashSet<Integer>(a);  
        union.addAll(b);  
        return union;
    }
    public Set<Integer> subtract(Set<Integer> a, Set<Integer> b){
        Set<Integer> difference = new HashSet<Integer>(a);  
        difference.removeAll(b);   
        return difference;
    }
    public Set<Integer> intersect(Set<Integer> a, Set<Integer> b){
        Set<Integer> intersection = new HashSet<Integer>(a);  
        intersection.retainAll(b);  
        return intersection;
    }
}
