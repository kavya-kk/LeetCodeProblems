package leetcode.problems;

import java.util.Arrays;

//https://www.pramp.com/challenge/15oxrQx6LjtQj9JK9XqA
public class CheapestCost {

    public static void main(String[] s){
        Node zero = new Node(0);
        Node five = new Node(5);
        Node three = new Node(3);
        Node six = new Node(6);
        Node[] zeroChildren = {five,three,six};
        zero.children = zeroChildren;

        Node four = new Node(4);
        Node[] fiveChildren = {four};
        five.children = fiveChildren;

        Node sone = new Node(1);
        Node sfive = new Node(5);
        Node[] sChildren = {sone, sfive};
        six.children = sChildren;

        Node ttwo = new Node(2);
        Node tzero = new Node(0);

        Node tone = new Node (1);
        Node oOne = new Node(1);
        Node ten = new Node(10);

        Node[] tTenChi = {ten};
        tzero.children = tTenChi;

        Node[] Ochild = {oOne};
        tone.children = Ochild;
        Node[] tOne = {tone};
        ttwo.children = tOne;

        Node[] f = {ttwo,tzero};
        three.children = f;
        System.out.println(getCheapestCost(zero, Integer.MAX_VALUE));
    }
    public static int getCheapestCost(Node rootNode, int subTreeMin) {

        if(rootNode == null){
            return 0;
        }
        if(rootNode.children == null || rootNode.children.length == 0){
            return rootNode.cost;
        }

        Arrays.sort(rootNode.children,(a,b) -> a.cost-b.cost);
        for(Node child : rootNode.children){
            if(child.cost > subTreeMin){
                continue;
            }
            subTreeMin = Math.min(subTreeMin, getCheapestCost(child,subTreeMin));
        }
        return subTreeMin+rootNode.cost;
    }

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }
}
