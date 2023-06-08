package com.cesupa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortProducts {

    public static void sort(List<Produto> produtos) {
        int n = produtos.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(produtos, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            Produto temp = produtos.get(0);
            produtos.set(0, produtos.get(i));
            produtos.set(i, temp);

            // call max heapify on the reduced heap
            heapify(produtos, i, 0);
        }
    }

    private static void heapify(List<Produto> produtos, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && produtos.get(left).getPreco() > produtos.get(largest).getPreco())
            largest = left;

        // If right child is larger than largest so far
        if (right < n && produtos.get(right).getPreco() > produtos.get(largest).getPreco())
            largest = right;

        // If largest is not root
        if (largest != i) {
            Produto swap = produtos.get(i);
            produtos.set(i, produtos.get(largest));
            produtos.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(produtos, n, largest);
        }
    }
    public static List<Produto> teste(List<Produto> produtos){
        List<Produto> ListaContraria = new ArrayList<>();
        for (int i = produtos.size()-1; i >= 0 ; i--) {
            ListaContraria.add(produtos.get(i));
        }
        return ListaContraria;
    }

    public static void binarySort(List<Produto> produtos) {
        produtos.sort(Comparator.comparing(p -> p.getNome().toLowerCase()));
    }


}