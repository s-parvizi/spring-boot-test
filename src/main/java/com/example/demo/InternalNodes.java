package com.example.demo;

import java.util.HashSet;
import java.util.Set;

/*

A tree is an abstract data structure consisting of nodes.
Each node nas only one parent node and zero or more child nodes.
Each tree has one special node, called a root, which has no parent node.
A node is called internal node if it has one or more children.

A tree can be presented by an array P where P[i] is the parent of node i.
For the root r, P[r] equals -1.

Write a function that, efficiently with respect to the time used, counts the number of internal nodes in a given tree.

For example, the tree represented by the array {1, 3, 1, -1, 3} has 5 nodes, 0 to 4,
of which 2 nodes are internal nodes (only nodes 1 and 3 have children).

*/

public class InternalNodes {

    public static int count(int[] tree) {
        Set<Integer> set = new HashSet<>();

        for (int element : tree) {
            if (element != -1) {
                set.add(element);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(InternalNodes.count(new int[]{1, 3, 1, -1, 3}));
    }
}
