import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Gerenciadordecontatos gerenciador = new Gerenciadordecontatos();
        Scanner ler = new Scanner(System.in);

        int escolha;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Listar contatos");
            System.out.println("3 - Buscar contato");
            System.out.println("4 - Remover contato");
            System.out.println("5 - Sair");
            System.out.print("Digite sua escolha: ");
            escolha = ler.nextInt();

        switch (escolha) {
            case 1:
            System.out.println("\nAdicionando contato:");
            System.out.println("1 - Profissional");
            System.out.println("2 - Pessoal");
            System.out.print("Escolha o tipo de contato: ");
            int tipoContato = ler.nextInt();
            ler.nextLine();
            System.out.print("Digite o nome: ");
            String nome = ler.nextLine();
            System.out.print("Digite o telefone: ");
            String numero = ler.nextLine();
            System.out.print("Digite o email: ");
            String email = ler.nextLine();
         
            if (tipoContato == 1) {
                System.out.print("Digite a empresa: ");
                String empresa = ler.nextLine();
                System.out.print("Digite o cargo: ");
                String cargo = ler.nextLine();
                gerenciador.adicionar(new ContatoProfissional(nome, numero, email, empresa, cargo));
            } else if (tipoContato == 2) {
                System.out.print("Digite o endereço: ");
                String endereco = ler.nextLine();
                System.out.print("Digite a data de aniversário (DD/MM/YYYY): ");
                String dataAniversario = ler.nextLine();
                gerenciador.adicionar(new ContatoPessoal(nome, numero, email, endereco, dataAniversario));
            } else {
                System.out.println("Opção inválida.");
            } 
                break;
            case 2:
                System.out.println("Escolha o tipo de contato:");
                System.out.println("1 - Profissional");
                System.out.println("2 - Pessoal");
                System.out.println("3 - Todos os Contatos");
                System.out.print("Digite sua escolha: ");
                int tipoLista = ler.nextInt();
                gerenciador.listar(tipoLista);
                break;
            case 3:
                ler.nextLine(); // Consumir a nova linha pendente no buffer
                System.out.print("Digite o nome do contato para buscar: ");
                nome = ler.next();
                String resultadoBusca = gerenciador.buscar(nome);
                if (!resultadoBusca.isEmpty()) {
                    System.out.println(resultadoBusca);
                } else {
                    System.out.println("Contato não encontrado.");
                }
                break;
            case 4:
                gerenciador.listaGeral(); // Listar contatos com índice
                System.out.print("Digite o índice do contato para remover: ");
                int indice = ler.nextInt();
                if (gerenciador.remover(indice)) {
                    System.out.println("Contato removido com sucesso.");
                } else {
                    System.out.println("Erro ao remover contato.");
                }
                break;
            case 5:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    } while (escolha != 5);

    ler.close();
    }
}
