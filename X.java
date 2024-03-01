package Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class X {
    private int id;
    private String nome;

    public X(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class XDao {
    private List<X> listaX;

    public XDao() {
        listaX = new ArrayList<>();
    }

    public void inserir(X x) {
        listaX.add(x);
    }

    public void excluir(int id) {
        listaX.removeIf(x -> x.getId() == id);
    }

    public void atualizar(int id, String novoNome) {
        for (X x : listaX) {
            if (x.getId() == id) {
                x.setNome(novoNome);
                break;
            }
        }
    }

    public List<X> listar() {
        return listaX;
    }
}

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XDao xDao = new XDao();

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Listar");
            System.out.println("2. Inserir");
            System.out.println("3. Excluir");
            System.out.println("4. Atualizar");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Listando:");
                    List<X> lista = xDao.listar();
                    for (X x : lista) {
                        System.out.println("ID: " + x.getId() + ", Nome: " + x.getNome());
                    }
                    break;
                case 2:
                    System.out.print("Digite o ID: ");
                    int idInserir = scanner.nextInt();
                    System.out.print("Digite o Nome: ");
                    String nomeInserir = scanner.next();
                    X novoX = new X(idInserir, nomeInserir);
                    xDao.inserir(novoX);
                    System.out.println("X inserido com sucesso.");
                    break;
                case 3:
                    System.out.print("Digite o ID para excluir: ");
                    int idExcluir = scanner.nextInt();
                    xDao.excluir(idExcluir);
                    System.out.println("X excluído com sucesso.");
                    break;
                case 4:
                    System.out.print("Digite o ID para atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.next();
                    xDao.atualizar(idAtualizar, novoNome);
                    System.out.println("X atualizado com sucesso.");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
