package com.cesupa;

import java.util.ArrayList;

public class ListadeProdutos {
  ArrayList<Produto> listaProduto = new ArrayList<>();

  public void Adicionar(Produto liv){
    listaProduto.add(liv);
  }

  public String listarProdutos(){
    String saida = "";
    for(Produto liv: listaProduto){
      saida += liv.Imprimir();
    }
    return saida;
  }

  public void remover(String nome){
    for(int i = 0; i <listaProduto.size(); i++){
      if(listaProduto.get(i).getNome().equals(nome)){
        listaProduto.remove(i);
      }
    }
  }

  public void editar(String nome, Produto liv){
    for(int i = 0; i < listaProduto.size(); i++){
      if(listaProduto.get(i).getNome().equals(nome)){
        listaProduto.set(i,liv);
      } else {
        System.out.println("Produto nao encontrado");
      }
    }
  }

  public void buscarProduto(String nome){
    for(int i = 0; i < listaProduto.size(); i++){
      if(listaProduto.get(i).getNome().equals(nome)){
        System.out.println("Produto encontado");
        System.out.println("Nome: " + listaProduto.get(i).getNome() + "\nDescricao: " + listaProduto.get(i).getDescription() + "\nPreco: " + listaProduto.get(i).getPreco() + "\nQuantidade: " + listaProduto.get(i).getQuantidade());
      } else {
        System.out.println("Produto nao encontrado");
      }
    }
  }

  public void buscaBinariaCrescente(){
    
  }
}
