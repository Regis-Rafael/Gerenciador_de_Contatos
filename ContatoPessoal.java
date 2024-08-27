package Gerenciador_de_Contatos;



public class ContatoPessoal extends Contatos {
    private String endereco;
    private String data_aniversario;

    public ContatoPessoal(String nome, String numero, String email, String endereco, String data_aniversario) {
        super(nome, numero, email);
        this.endereco = endereco;
        this.data_aniversario= data_aniversario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData_aniversario() {
        return data_aniversario;
    }

    public void setData_aniversario(String data_aniversario) {
        this.data_aniversario = data_aniversario;
    }
    
}
