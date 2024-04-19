Given a string with duplicate characters sequence, return the maximum length duplicate contiguous characters , 
aaaabbbbccc' => ['a','b']
abcd' => ['a','b','c','d']

import java.util.*;

class HelloWorld {
    class Pair{
    char c;
    int val;
    public Pair(char c, int val){
        this.c=c;
        this.val=val;
    }
}

public List<Character> findConArray(char[] ch){
    List<Character> res = new ArrayList<>();
    List<Pair> temp = new ArrayList<>();
    for(int i=0;i<ch.length;i++){
       char c = ch[i];
        int count = 1;
        while(i+1<ch.length && ch[i]==ch[i+1]){
            i++;
            count++;
        }
        Pair p = new Pair(c, count);
        temp.add(p);
    }
    int max = 0;
    for(Pair p: temp){
        max = Math.max(p.val, max);
    }
    for(Pair p: temp){
        if(p.val ==max){
            res.add(p.c);
        }
    }
    return res;

}

    public static void main(String[] args) {
        HelloWorld h = new HelloWorld();
        List<Character> res = h.findConArray(new char[]{'a','a','b','b','c'});
        for(char c: res){
            System.out.print(c);
        }
         System.out.println();
       res = h.findConArray(new char[]{'a','a','a','a','b','b','b','b','c','c','c'});
        for(char c: res){
            System.out.print(c);
        }
        System.out.println();
        res = h.findConArray(new char[]{'a','a','a','a','b','b','b','b','c','c','c','d','d','d','d', 'd'});
        for(char c: res){
            System.out.print(c);
        }
        System.out.println();
       res = h.findConArray(new char[]{'a','a','b','b','c'});
        for(char c: res){
            System.out.print(c);
        }
        System.out.println();
         res = h.findConArray(new char[]{'a','a','b','b','c'});
        for(char c: res){
            System.out.print(c);
        }
        System.out.println();
        res = h.findConArray(new char[]{'a','b','c','d'});
        for(char c: res){
            System.out.print(c);
        }
        System.out.println();
    }
}
