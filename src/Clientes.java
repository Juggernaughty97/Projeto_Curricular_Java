import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Clientes {

    private static ArrayList<Cliente> Clientes = new ArrayList<>();

    public boolean LeFicheiro() {

        String linha, numerostr, estadostr, nome, telefonestr, credito_maxstr;
        String morada, localidade, cod_postal, cidade, distrito, email, cart_cidadaostr, num_contribuintestr;

        try {
            File file = new File("src/clientes.csv");

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            if (file.length() == 0){
                System.out.println("\n->Lista de clientes vazia!");
            }

            while ((linha = bufferedReader.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(linha, ";");

                numerostr = st.nextToken();
                estadostr = st.nextToken();
                nome = st.nextToken();
                morada = st.nextToken();
                localidade = st.nextToken();
                cod_postal = st.nextToken();
                cidade = st.nextToken();
                distrito = st.nextToken();
                telefonestr = st.nextToken();
                email = st.nextToken();
                cart_cidadaostr = st.nextToken();
                num_contribuintestr = st.nextToken();
                credito_maxstr = st.nextToken();

                try {
                    int numero = Integer.parseInt(numerostr);
                    boolean estado = Boolean.parseBoolean(estadostr);
                    int telefone = Integer.parseInt(telefonestr);
                    int cart_cidadao = Integer.parseInt(cart_cidadaostr);
                    int num_contribuinte = Integer.parseInt(num_contribuintestr);
                    double credito_max = Double.parseDouble(credito_maxstr);

                    AdicionarLer(numero, estado, nome, morada, localidade, cod_postal, cidade, distrito, telefone, email, cart_cidadao, num_contribuinte, credito_max);
                } catch (NumberFormatException e) {
                    System.out.println("\n->Idade, telefone ou credito com formato errado\n");
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {

            e.printStackTrace();

            return false;
        }
        return true;
    }

    public void ListarClientes() {
        System.out.print("-----------------------------------------\n");
        for (Cliente cliente : Clientes) {
            if (cliente.getEstado()) {
                System.out.println("Numero cliente...... " + cliente.getNumero() +
                        "\nNome................ " + cliente.getNome() +
                        "\nMorada.............. " + cliente.getMorada() +
                        "\nLocalidade.......... " + cliente.getMorada() +
                        "\nCodigo Postal....... " + cliente.getCod_postal() +
                        "\nCidade.............. " + cliente.getCidade() +
                        "\nDistrito............ " + cliente.getDistrito() +
                        "\nTelefone............ " + cliente.getTelefone() +
                        "\nEmail............... " + cliente.getEmail() +
                        "\nCartao de Cidadao... " + cliente.getCart_cidadao() +
                        "\nNr Contribuinte..... " + cliente.getNum_contribuinte() +
                        "\nCredito Maximo...... " + cliente.getCredito_max() +
                        "\n-----------------------------------------");
                return;
            }
        }
        System.out.println("\n->Lista vazia\n");
    }

    public boolean EscreveFicheiro() {
        try {
            File file = new File("src/clientes.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            Clientes.forEach((cliente -> printWriter.println(cliente.getNumero() + ";" +
                    cliente.getEstado() + ";" +
                    cliente.getNome() + ";" +
                    cliente.getMorada() + ";" +
                    cliente.getLocalidade() + ";" +
                    cliente.getCod_postal() + ";" +
                    cliente.getCidade() + ";" +
                    cliente.getDistrito() + ";" +
                    cliente.getTelefone() + ";" +
                    cliente.getEmail() + ";" +
                    cliente.getCart_cidadao() + ";" +
                    cliente.getNum_contribuinte() + ";" +
                    cliente.getCredito_max() + "")));

            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void AdicionarEscrever(String nome, String morada, String localidade, String cod_postal, String cidade, String distrito, int telefone, String email, int cart_cidadao, int num_contribuinte, double credito_max) {
        Cliente cliente = new Cliente();

        if (GetClienteNrMax() == 0){
            cliente.setNumero(1);
        }
        else{
            cliente.setNumero(GetClienteNrMax() + 1);
        }
        cliente.setEstado(true);
        cliente.setNome(nome);
        cliente.setMorada(morada);
        cliente.setLocalidade(localidade);
        cliente.setCod_postal(cod_postal);
        cliente.setCidade(cidade);
        cliente.setDistrito(distrito);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setCart_cidadao(cart_cidadao);
        cliente.setNum_contribuinte(num_contribuinte);
        cliente.setCredito_max(credito_max);

        String FileMovimentos = cliente.getNumero() + ".csv";
        cliente.setFileMovimentos(FileMovimentos);

        Clientes.add(cliente);
    }

    public void AdicionarLer(int numero, boolean estado, String nome, String morada, String localidade, String cod_postal, String cidade, String distrito, int telefone, String email, int cart_cidadao, int num_contribuinte, double credito_max) {
        Cliente cliente = new Cliente();

        cliente.setNumero(numero);
        cliente.setEstado(estado);
        cliente.setNome(nome);
        cliente.setMorada(morada);
        cliente.setLocalidade(localidade);
        cliente.setCod_postal(cod_postal);
        cliente.setCidade(cidade);
        cliente.setDistrito(distrito);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setCart_cidadao(cart_cidadao);
        cliente.setNum_contribuinte(num_contribuinte);
        cliente.setCredito_max(credito_max);

        Clientes.add(cliente);

        EscreveFicheiro();
    }

    private Cliente GetCliente(int numero) {
        for (Cliente cliente : Clientes) {
            if (cliente.getNumero() == numero) {
                return cliente;
            }
        }
        return null;
    }

    public void Eliminar(int numero) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        }
        cliente.setEstado(false);

        if (!EscreveFicheiro()) {
            System.out.println("\n->Erro na eliminação do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Cliente " + numero + " eliminado\n");
        }
    }

    private int GetClienteNrMax() {
        // Da arraylist, encontrar o ultimo cliente (index), ao subtrair 1 do total de clientes.
        // Depois com getNumero() obter o numero de cliente desse index.


        try {
            return Clientes.get(Clientes.size() - 1).getNumero();
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public void AlterarNome(int numero, String novoNome) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
            return;
        }

        cliente.setNome(novoNome);

        if (!EscreveFicheiro()) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Cliente " + numero + " alterado\n");
        }
    }
    public void AlterarMorada(int numero, String novaMorada) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
            return;
        }

        cliente.setMorada(novaMorada);

        if (!EscreveFicheiro()) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Cliente " + numero + " alterado\n");
        }
    }
    public void AlterarLocalidade(int numero, String novaLocalidade) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
            return;
        }

        cliente.setLocalidade(novaLocalidade);

        if (!EscreveFicheiro()) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Cliente " + numero + " alterado\n");
        }
    }
    public void AlterarCod_Postal(int numero, String novoCod_Postal) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
            return;
        }

        cliente.setCod_postal(novoCod_Postal);

        if (!EscreveFicheiro()) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Cliente " + numero + " alterado\n");
        }
    }
    public void AlterarCidade(int numero, String novaCidade) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
            return;
        }

        cliente.setCidade(novaCidade);

        if (!EscreveFicheiro()) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Cliente " + numero + " alterado\n");
        }
    }
    public void AlterarDistrito(int numero, String novoDistrito) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
            return;
        }

        cliente.setDistrito(novoDistrito);

        if (!EscreveFicheiro()) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Cliente " + numero + " alterado\n");
        }
    }

    public void AlterarTelefone(int numero, int novoTelefone) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
            return;
        }

        cliente.setTelefone(novoTelefone);

        if (!EscreveFicheiro()) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Cliente " + numero + " alterado\n");
        }

    }
    public void AlterarEmail(int numero, String novoEmail) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
            return;
        }

        cliente.setEmail(novoEmail);

        if (!EscreveFicheiro()) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Cliente " + numero + " alterado\n");
        }
    }
    public void AlterarCart_Cidadao(int numero, int novoCart_cidadao) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
            return;
        }

        cliente.setCart_cidadao(novoCart_cidadao);

        if (!EscreveFicheiro()) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Cliente " + numero + " alterado\n");
        }
    }
    public void AlterarNum_Contribuinte(int numero, int novoNum_contribuinte) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
            return;
        }

        cliente.setNum_contribuinte(novoNum_contribuinte);

        if (!EscreveFicheiro()) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Cliente " + numero + " alterado\n");
        }
    }

    public void AlterarCred_Maximo(int numero, double novoCredito) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
            return;
        }

        cliente.setCredito_max(novoCredito);

        if (!EscreveFicheiro()) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Cliente " + numero + " alterado\n");
        }

    }

    public void Upd_Credito(double credito, int numero) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
        }

        double cred_disp = cliente.getCredito_max() + credito;

        cliente.setCredito_disp(cred_disp);

        String creditostr = String.valueOf(credito);


        if (!EscreverMovimentos(creditostr, numero, false)) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        } else {
            System.out.println("\n->Transacao do cliente " + numero + " registada\n");
        }
    }

    public void Upd_Debito(double debito, int numero) {
        Cliente cliente = GetCliente(numero);

        if (cliente == null) {
            System.out.println("\n->Cliente " + numero + " inexistente\n");
            return;
        } else if (!cliente.getEstado()) {
            System.out.println("\n->Cliente " + numero + "esta inativo\n");
        }

        double cred_disp = cliente.getCredito_max() - debito;

        cliente.setCredito_disp(cred_disp);

        String debitostr = "-" + debito;

        if (EscreverMovimentos(debitostr, numero, false)) {
            System.out.println("\n->Transacao do cliente " + numero + " registada\n");
        } else if (EscreverMovimentos(debitostr, numero, false)) {
            System.out.println("\n->Erro na alteracao dos dados do cliente " + numero + "\n");
        }
    }

    public boolean EscreverMovimentos(String movimentostr, int numero, boolean new_cred_max) {
        try {
            String linha;
            double movimentos_total, buffer_movimentos = 0;
            StringBuilder buffer = new StringBuilder();

            Cliente cliente = GetCliente(numero);

            File file = new File("src/" + numero + ".csv");

            FileInputStream fis = new FileInputStream("src/" + numero + ".csv");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));


            while ((linha = bufferedReader.readLine()) != null) {
                StringTokenizer ts = new StringTokenizer(linha, ";");

                ts.nextToken();
                ts.nextToken();
                while (ts.hasMoreTokens()){
                    buffer_movimentos += Double.parseDouble(ts.nextToken());
                }
            }

            fis.getChannel().position(0);
            bufferedReader = new BufferedReader(new InputStreamReader(fis));

            while ((linha = bufferedReader.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(linha, ";");

                st.nextToken();
                buffer.append(cliente.getCredito_max()).append(";");

                if (new_cred_max){
                    movimentos_total = cliente.getCredito_max() + buffer_movimentos;
                    buffer.append(movimentos_total).append(";");
                    st.nextToken();
                }
                else{
                    movimentos_total = Double.parseDouble(st.nextToken()) + Double.parseDouble(movimentostr);
                    buffer.append(movimentos_total).append(";");
                }

                while (st.hasMoreTokens()) {
                    buffer.append(st.nextToken()).append(";");
                }
            }
            bufferedReader.close();

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println(buffer + movimentostr);

            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();

            } catch(IOException e){

                e.printStackTrace();
                return false;
            }
            return true;
        }

        public void LerMovimentos(int numero){

        String cred_maxstr, cred_disp, movimentos, linha;
        try{
            File file = new File("src/" + numero + ".csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((linha = bufferedReader.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(linha, ";");

                cred_maxstr = st.nextToken();

                cred_disp = st.nextToken();

                System.out.println("Credito maximo ......" + cred_maxstr + "€");
                System.out.println("Credito disponivel .." + cred_disp + "€");
                System.out.println("Movimentos:");
                while (st.hasMoreTokens()) {
                    movimentos = st.nextToken();

                    System.out.println("    " + movimentos + "€");
                }
            }
            bufferedReader.close();
            fileReader.close();

        }catch(IOException e){
            System.out.println("\n->Nao foi possivel ler o ficheiro\n");
            }
        }
    }