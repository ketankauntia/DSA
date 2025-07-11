// built with Binary Search Tree

import java.util.*;
class HashMap<K,V>{
    class HMNode{
        K key;
        V value;

        HMNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    
    // ek array hai named buckets which stores linkedlist. each linkedlist has HMNode ka datastructure within it.
    private LinkedList<HMNode> buckets[];  // N = buckets.length;
    private int size;   // n
    
    public HashMap(){
        initbuckets(4);
        size = 0;
    }

    private void initbuckets(int N){
        buckets = new LinkedList[N];
        //bi = bucket index
        for(int bi=0;bi<buckets.length;bi++){
            buckets[bi] = new LinkedList<>();
        }
    }
    
    public void put(K key, V value){

        //bucket find kiya, bucket me konse index pe h find kiya
        int bi = hashfn(key);
        int di = getIndexWithinBucket(key, bi);

        // index mil gaya, to value find krke value change krdi
        if(di!=-1){
            HMNode node = buckets[bi].get(di);
            node.value = value;
        } else{
            // wrna new node bana ke value put krdi
            HMNode node = new HMNode(key, value);
            buckets[bi].add(node);
            size++; // finally size badha di
        }

        // finally lambda calculate kiya coz ek addition hua h.
        // lambda agar 2 se bada h, to rehash kar diya.
        double lambda = size *1.0 / buckets.length;
        if(lambda>2.0){
            rehash();
        }
    }
    
    public void rehash(){
        // pura jitna content h, usse old bucket array me dala,
        LinkedList<HMNode>[] oba = buckets;

        // init se buckets wale array ka size double hoke size 0
        initbuckets(oba.length*2);
        size = 0;

        // old array me loop laga ke sara data wapas copy kr diya
        for(int i=0;i<oba.length;i++){
            for(HMNode node: oba[i]){
                put(node.key, node.value);
            }
        }
    }

    private int hashfn(K key){
        int hc = key.hashCode();    // hash code
        return Math.abs(hc) % buckets.length;
    }

    private int getIndexWithinBucket(K key, int bi){
        int di = 0;
        for(HMNode node: buckets[bi]){
            if(node.key.equals(key)){
                return di;
            }
            di++;
        }
        return -1;
    }

    public V get(K key){
        // key mili, hash function call kre.
        // ye bata dega key konse bucket me h.
        int bi = hashfn(key);

        //fir uss bucket me jaake uss key ko khoja humne.
        int di = getIndexWithinBucket(key, bi);

        // nahi mila to null, wrna node nikal ke value return karde.
        if(di != -1){
            HMNode node = buckets[bi].get(di);
            return node.value;
        } else{
            return null;
        }
    }
    
    public boolean containsKey(K key){
        int bi = hashfn(key);
        int di = getIndexWithinBucket(key, bi);

        if(di!= -1){
            return true;
        } else{
             return false;
        }
    }
    
    public V remove(K key){
        //key mila to return key else null
        int bi = hashfn(key);
        int di = getIndexWithinBucket(key,bi);

        if(di!=-1){
            HMNode node = buckets[bi].remove(di);
            size--;
            return node.value;
        } else{
            return null;
        }
    }
    
    public ArrayList<K> keySet(){
        ArrayList<K> keys = new ArrayList<>();

        // saare buckets me loop lagaya,
        // sare buckets ke node ko uthaya,
        // unke keys ko add kiya, last me return
        for(int i=0;i<buckets.length; i++){
            for(HMNode node:buckets[i]){
                keys.add(node.key);
            }
        }
        return keys;
    }
    
    public int size(){
        return size();
    }
}


public class Hashmap_Implementation {
    



    // 38:22 ------ summet sir vod.




    
}
