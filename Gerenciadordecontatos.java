package Gerenciador_de_Contatos;



import java.util.ArrayList;
import java.util.List;

// Classe Gerenciadordecontatos para gerenciar uma lista de contatos.
public class Gerenciadordecontatos {
    // Lista para armazenar os contatos.
    private List<Contatos> agenda;
    
    // Construtor para inicializar a lista de contatos.
    public Gerenciadordecontatos() {
        agenda = new ArrayList<>();
    }

    // Método para adicionar um contato à lista.
    public boolean adicionar(Contatos contato) {
        agenda.add(contato);
        return true;
    }

    // Método para remover um contato da lista com base no índice.
    public boolean remover(int indice) {
        try {
            agenda.remove(indice);
            return true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: posição inválida.");
            return false;
        }
    }
 
    // Método para buscar um contato pelo nome e retornar uma string com as informações.
    public String buscar(String nome) {
        String resultadoBusca = "";
        
        for (Contatos contato : agenda) {
            if (contato.getNome().equals(nome)) {
                if (contato instanceof ContatoProfissional) {
                    ContatoProfissional contatoProfissional = (ContatoProfissional) contato;
                    resultadoBusca = "\nNome: " + contatoProfissional.getNome() + " // Telefone: " + contatoProfissional.getNumero() + " // Email: "+ contatoProfissional.getEmail() + " // Empresa: " + contatoProfissional.getEmpresa() + " // Cargo: " + contatoProfissional.getCargo();
                } else if (contato instanceof ContatoPessoal) {
                    ContatoPessoal contatoPessoal = (ContatoPessoal) contato;
                    resultadoBusca = "\nNome: " + contatoPessoal.getNome() + " // Telefone: " + contatoPessoal.getNumero() + " // Email: "+ contatoPessoal.getEmail() + " // Endereço: " + contatoPessoal.getEndereco() + " // Data de Aniversário: " + contatoPessoal.getData_aniversario();
                }
                break;
            }
        }
        return resultadoBusca;
    }

    // Método para listar os contatos de acordo com o tipo especificado.
    public void listar(int tipoContato) {
        if (tipoContato == 1) {
            for (int i = 0; i < agenda.size(); i++) {
                Contatos contato = agenda.get(i);
                if (contato instanceof ContatoProfissional) { 
                    ContatoProfissional contatoProfissional = (ContatoProfissional) contato;
                    System.out.println(i + ": " + contatoProfissional.getNome() + " // Telefone: " + contatoProfissional.getNumero() + " // Email: " + contatoProfissional.getEmail() + " // Empresa: " + contatoProfissional.getEmpresa() + " // Cargo: " + contatoProfissional.getCargo());
                }
            }
        } else if (tipoContato == 2) {
            for (int i = 0; i < agenda.size(); i++) {
                Contatos contato = agenda.get(i);
                if (contato instanceof ContatoPessoal) {
                    ContatoPessoal contatoPessoal = (ContatoPessoal) contato;
                    System.out.println(i + ": " + contatoPessoal.getNome() + " // Telefone: " + contatoPessoal.getNumero() + " // Email: " + contatoPessoal.getEmail() + " // Endereço: " + contatoPessoal.getEndereco() + " // Data de Aniversário: " + contatoPessoal.getData_aniversario());
                }
            }
        } else if(tipoContato == 3){
            listaGeral();
        }
    }
    public void listaGeral(){
        System.out.println("Lista de Contatos: ");
        for(int i = 0; i < agenda.size(); i++){
            Contatos contato = agenda.get(i);
            if (contato instanceof ContatoProfissional) { 
                ContatoProfissional contatoProfissional = (ContatoProfissional) contato;
                System.out.println("\n" + i + ": " + contatoProfissional.getNome() + " // Telefone: " + contatoProfissional.getNumero() + " // Email: " + contatoProfissional.getEmail() + " // Empresa: " + contatoProfissional.getEmpresa() + " // Cargo: " + contatoProfissional.getCargo());
            }   
            else if (contato instanceof ContatoPessoal) {
                ContatoPessoal contatoPessoal = (ContatoPessoal) contato;
                System.out.println("\n" + i + ": " + contatoPessoal.getNome() + " // Telefone: " + contatoPessoal.getNumero() + " // Email: " + contatoPessoal.getEmail() + " // Endereço: " + contatoPessoal.getEndereco() + " // Data de Aniversário: " + contatoPessoal.getData_aniversario());
            }
        }
    }
}