import java.io.*;

public class Cliente {
    boolean estado;
    int numero;
    String nome;
    String morada;
    String localidade;
    String cod_postal;
    String cidade;
    String distrito;
    int telefone;
    String email;
    int cart_cidadao;
    int num_contribuinte;
    double credito_max;
    double credito_disp;
    public boolean getEstado() {
        return estado;
    }

    public int getNumero(){
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public double getCredito_max() {
        return credito_max;
    }

    public String getMorada() {
        return morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public String getCidade() {
        return cidade;
    }

    public String getDistrito() {
        return distrito;
    }

    public String getEmail() {
        return email;
    }

    public int getCart_cidadao() {
        return cart_cidadao;
    }

    public int getNum_contribuinte() {
        return num_contribuinte;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCart_cidadao(int cart_cidadao) {
        this.cart_cidadao = cart_cidadao;
    }

    public void setNum_contribuinte(int num_contribuinte) {
        this.num_contribuinte = num_contribuinte;
    }
    public void setNumero(int numero){ this.numero = numero; }
    public void setEstado(boolean estado){ this.estado = estado; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setCredito_max(double credito_max) {
        this.credito_max = credito_max;
    }
    public void setCredito_disp(double credito_disp) {this.credito_disp = credito_disp; }
    public void setFileMovimentos(String filename){
        try{
            File file = new File("src/" + filename);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.print(getCredito_max() + ";" + getCredito_max() + ";");

            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();

        }
        catch(IOException e){
            System.out.println("Nao foi possível criar o ficheiro de movimentos do cliente.");
        }
    }
}
