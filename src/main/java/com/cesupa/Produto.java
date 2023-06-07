package com.cesupa;

public class Produto {
  private String nome;
  private String description;
  private double preco;
  private int quantidade;

  
  public Produto(String nome, String descrição, double preco, int quantidade) {
    this.nome = nome;
    this.description = descrição;
    this.preco = preco;
    this.quantidade = quantidade;
  }

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public double getPreco() {
    return preco;
  }
  public void setPreco(double preco) {
    this.preco = preco;
  }
  public int getQuantidade() {
    return quantidade;
  }
  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }
  
  public String Imprimir(){
    String saida = "";
    saida += "\n\nProduto \nNome: " + getNome() + "\nDescricao: " + getDescription() + "\nPreco: " + getPreco() + "\nQuantidade: " + getQuantidade() +".";
    return saida;
  }
}