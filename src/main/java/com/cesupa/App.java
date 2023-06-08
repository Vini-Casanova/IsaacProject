package com.cesupa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {


    ListadeProdutos lista = new ListadeProdutos();
    Scanner ler = new Scanner(System.in);
    int menu = 0;

    while (menu != 11) {
      System.out.println("\nMenu");
      System.out.println("Escolha uma das opções:");
      System.out.println("1 - Cadastrar um novo produto");
      System.out.println("2 - Editar um produto");
      System.out.println("3 - Remover um produto");
      System.out.println("4 - Listar todos os produtos");
      System.out.println("5 - Lista de produtos por preço ordem crescente (Heapsort)");
      System.out.println("6 - Lista de produtos por preço ordem decrescente (Heapsort)");
      System.out.println("7 - Lista de produtos por nome ordem crescente (busca binaria)");
      System.out.println("8 - Lista de produtos por nome ordem decrescente (busca binaria)");
      System.out.println("9 - Buscar produto");
      System.out.println("10 - Inserir base de dados Json através do Path Absoluto");
      System.out.println("11 - Sair da aplicação");

      menu = ler.nextInt();

      switch (menu) {
        case 1:
          System.out.println("Cadastro de produto");
          System.out.println("Digite o nome do produto: ");
          String nome = ler.next();
          System.out.println("Digite a descricao do produto: ");
          String descricao = ler.next();
          System.out.println("Digite o preco do produto: ");
          Double preco = ler.nextDouble();
          System.out.println("Digite a quantidade de produto: ");
          int quantidade = ler.nextInt();

          Produto liv = new Produto(nome, descricao, preco, quantidade);

          lista.Adicionar(liv);
          break;

        case 2:
          System.out.println("Editar produto");
          System.out.println("Digite o nome do produto a ser editado");
          String nomeEd = ler.next();

          System.out.println("Digite o novo nome do produto: ");
          String nomeEditado = ler.next();
          System.out.println("Digite a nova descricao do produto: ");
          String descricaoEditada = ler.next();
          System.out.println("Digite o novo preco do produto: ");
          Double precoEditado = ler.nextDouble();
          System.out.println("Digite a nova quantidade de produto: ");
          int quantidadeEditada = ler.nextInt();

          Produto livEditar = new Produto(nomeEditado, descricaoEditada, precoEditado, quantidadeEditada);

          lista.editar(nomeEd, livEditar);
          break;

        case 3:
          System.out.println("Remover produto");
          System.out.println("Digite o nome do produto a ser removido");
          String nomeRm = ler.next();
          lista.remover(nomeRm);
          break;

        case 4:
          System.out.println("Todos os produtos");
          System.out.println(lista.listarProdutos());
          break;

        case 5:
          System.out.println("Lista de produtos por preço ordem crescente (Heapsort)");
          SortProducts.sort(lista.listaProduto);
          System.out.println(lista.listarProdutos());
          break;

        case 6:
          System.out.println("6 - Lista de produtos por preço ordem decrescente (Heapsort)");
          SortProducts.sort(lista.listaProduto);
          SortProducts.teste(lista.listaProduto).forEach(x -> System.out.println(x.Imprimir()));
          break;

        case 7:
          System.out.println("7 - Lista de produtos por nome ordem crescente (busca binaria)");
          SortProducts.binarySort(lista.listaProduto);
          System.out.println(lista.listarProdutos());
          break;

        case 8:
          System.out.println("8 - Lista de produtos por nome ordem decrescente (busca binaria)");
          SortProducts.binarySort(lista.listaProduto);
          SortProducts.teste(lista.listaProduto).forEach(x -> System.out.println(x.Imprimir()));
          break;

        case 9:
          System.out.println("Buscar produto");
          System.out.println("Digite o nome do produto que voce procura: ");
          String nomeBus = ler.next();
          lista.buscarProduto(nomeBus);
          break;
        case 10:
          System.out.println(" ");
          try{
            JsonReader.readFileAndPopulate("C:\\Users\\Vinicius.Santos\\IdeaProjects\\supermarket\\src\\main\\java\\com\\cesupa\\data.json").forEach(p -> lista.Adicionar(p));
          }catch (IOException e) {
            e.printStackTrace();
          }
          System.out.println("Itens que foram adicionados");
          System.out.println(lista.listarProdutos());
          break;
        default:

      }
    }
  }
}
