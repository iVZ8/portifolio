package projetosportifolio.crudPessoa;

import projetosportifolio.geral.Leitura;

import java.util.ArrayList;

public class PessoaMain {
    public static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    public static int nextid = 0;

    public static void main(){
        menu();
    }
    public static void menu(){
        boolean app = true;
        int op;
        do {
            op = Leitura.lerInteiro("Menu\n\n1. Adicionar Pessoa\n2. Remover Pessoa\n3. Editar Pessoa\n4. Listar Pessoas\n5. Sair\n\n> ");
            switch (op){
                case 1:
                    adicionarPessoa();
                    break;
                case 2:
                    removerPessoa();
                    break;
                case 3:
                    editarPessoa();
                    break;
                case 4:
                    listarPessoas();
                    break;
                case 5:
                    app = false;
                    break;
            }
        }while (app);
    }
    public static void adicionarPessoa(){
        String nome = Leitura.lerString("Insira um nome para a pessoa: ");
        String email = Leitura.lerString("Insira um endereço de e-mail para "+nome+": ");
        String senha = Leitura.lerString("Insira uma senha para "+nome+": ");
        Pessoa p = new Pessoa(nextid, nome, email, senha);
        pessoas.add(p);
        nextid++;
    }
    public static void removerPessoa(){
        listarPessoas();
        int i = Leitura.lerInteiro("Insira um index válido para remover: ");
        pessoas.remove(i);
    }
    public static void editarPessoa(){
        listarPessoas();
        int i = Leitura.lerInteiro("Insira um index válido para editar: ");
        int idantigo = pessoas.get(i).getId();
        String nome = Leitura.lerString("Insira um novo nome para a pessoa: ");
        String email = Leitura.lerString("Insira um novo endereço de e-mail para "+nome+": ");
        String senha = Leitura.lerString("Insira uma nova senha para "+nome+": ");
        Pessoa p = new Pessoa(idantigo, nome, email, senha);
        pessoas.set(i, p);
    }
    public static void listarPessoas(){
        if(pessoas.isEmpty()){
            System.out.println("Nenhuma pessoa adicionada a lista.");
        }else{
            for (int i = 0; i < pessoas.size(); i++) {
                System.out.println("INDEX: "+i+" NOME: "+pessoas.get(i).getNome()+" E-MAIL: "+pessoas.get(i).getEmail()+" SENHA: "+pessoas.get(i).getSenha());
            }
        }
    }
}