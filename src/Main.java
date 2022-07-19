import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String opcao;

        Clientes clientes = new Clientes();

        if(clientes.LeFicheiro()){
            System.out.println("\n->Ficheiro de clientes aberto!\n");
        }
        else{
            System.out.println("->Erro ao ler ficheiro de clientes!");
        }

        do{
            ListaMenu();

            System.out.print("Escolha uma opcao: ");
            opcao = scanner.next();

            switch (opcao){
                case "1":
                    clientes.ListarClientes();
                    break;
                case "2":
                    try{
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Morada: ");
                        String morada = scanner.nextLine();

                        System.out.print("Localidade: ");
                        String localidade = scanner.nextLine();

                        System.out.print("Codigo Postal: ");
                        String cod_postal = scanner.nextLine();

                        System.out.print("Cidade: ");
                        String cidade = scanner.nextLine();

                        System.out.print("Distrito: ");
                        String distrito = scanner.nextLine();

                        System.out.print("Telefone: ");
                        String telefonestr = scanner.nextLine();
                        int telefone = Integer.parseInt(telefonestr);

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Cartao de Cidadao: ");
                        String cart_cidadaostr = scanner.nextLine();
                        int cart_cidadao = Integer.parseInt(cart_cidadaostr);

                        System.out.print("Nº Contribuinte: ");
                        String num_contribuintestr = scanner.nextLine();
                        int num_contribuinte = Integer.parseInt(num_contribuintestr);

                        System.out.print("Credito maximo: ");
                        String credito_maxstr = scanner.nextLine();
                        credito_maxstr = credito_maxstr.replace(",", ".");
                        double credito_max = Double.parseDouble(credito_maxstr);


                        clientes.AdicionarEscrever(nome, morada, localidade, cod_postal, cidade, distrito, telefone, email, cart_cidadao, num_contribuinte, credito_max);
                        if (!clientes.EscreveFicheiro()){
                            System.out.println("\n-> Erro ao adicionar o cliente\n");
                            break;
                        }
                        System.out.println("\n->Cliente adicionado com sucesso\n");

                    }
                    catch (NumberFormatException e){
                        System.out.println("\n->Valores introduzidos invalidos\n");
                }
                    break;
                case "3":
                    scanner.nextLine();
                    System.out.print("\nIntroduza o número do cliente a remover: ");
                    String numeroRemstr = scanner.nextLine();
                    try{
                        int numeroRem = Integer.parseInt(numeroRemstr);
                        clientes.Eliminar(numeroRem);
                    }
                    catch (NumberFormatException e){
                        System.out.println("\n->Numero introduzido invalido\n");
                }
                    break;
                case "4":
                    try{
                        System.out.print("\nIntroduza o numero do cliente a alterar os dados: ");
                        scanner.nextLine();
                        int numeroAlt = scanner.nextInt();

                        System.out.println("1 - Nome");
                        System.out.println("2 - Morada");
                        System.out.println("3 - Localidade");
                        System.out.println("4 - Codigo Postal");
                        System.out.println("5 - Cidade");
                        System.out.println("6 - Distrito");
                        System.out.println("7 - Telefone");
                        System.out.println("8 - Email");
                        System.out.println("9 - Cartao Cidadao");
                        System.out.println("10 - Nr Contribuinte");
                        System.out.println("11 - Credito maximo");
                        System.out.println("0 - Voltar atras");
                        System.out.print("Introduza a opcao a alterar: ");
                        scanner.nextLine();
                        int dados = scanner.nextInt();
                        if (dados == 1) {
                            System.out.print("Introduza o novo nome para o cliente: ");
                            scanner.nextLine();
                            String novoNome = scanner.nextLine();
                            clientes.AlterarNome(numeroAlt, novoNome);}
                        else if (dados == 2) {
                            System.out.print("Introduza a nova morada para o cliente: ");
                            scanner.nextLine();
                            String novaMorada = scanner.nextLine();
                            clientes.AlterarMorada(numeroAlt, novaMorada);}
                        else if (dados == 3) {
                            System.out.print("Introduza a nova localidade para o cliente: ");
                            scanner.nextLine();
                            String novaLocalidade = scanner.nextLine();
                            clientes.AlterarLocalidade(numeroAlt, novaLocalidade);}
                        else if (dados == 4) {
                            System.out.print("Introduza o novo codigo postal para o cliente: ");
                            scanner.nextLine();
                            String novoCod_postal = scanner.nextLine();
                            clientes.AlterarCod_Postal(numeroAlt, novoCod_postal);}
                        else if (dados == 5) {
                            System.out.print("Introduza a nova cidade para o cliente: ");
                            scanner.nextLine();
                            String novaCidade = scanner.nextLine();
                            clientes.AlterarCidade(numeroAlt, novaCidade);}
                        else if (dados == 6) {
                            System.out.print("Introduza o novo distrito para o cliente: ");
                            scanner.nextLine();
                            String novoDistrito = scanner.nextLine();
                            clientes.AlterarDistrito(numeroAlt, novoDistrito);}
                        else if (dados == 7) {
                            System.out.print("Introduza o novo telefone para o cliente: ");
                            scanner.nextLine();
                            String novoTelefonestr = scanner.nextLine();
                            int novoTelefone = Integer.parseInt(novoTelefonestr);
                            clientes.AlterarTelefone(numeroAlt, novoTelefone);}
                        else if (dados == 8) {
                            System.out.print("Introduza o novo email para o cliente: ");
                            scanner.nextLine();
                            String novoEmail = scanner.nextLine();
                            clientes.AlterarEmail(numeroAlt, novoEmail);}
                        else if (dados == 9) {
                            System.out.print("Introduza o novo numero de cartao de cidadao para o cliente: ");
                            scanner.nextLine();
                            String novoCart_cidadaostr = scanner.nextLine();
                            int novoCart_cidadao = Integer.parseInt(novoCart_cidadaostr);
                            clientes.AlterarCart_Cidadao(numeroAlt, novoCart_cidadao);}
                        else if (dados == 10) {
                            System.out.print("Introduza o novo numero de contribuinte para o cliente: ");
                            scanner.nextLine();
                            String novoNum_Contribuintestr = scanner.nextLine();
                            int novoNum_contribuinte = Integer.parseInt(novoNum_Contribuintestr);
                            clientes.AlterarNum_Contribuinte(numeroAlt, novoNum_contribuinte);}
                        else if (dados == 11) {
                            System.out.print("Introduza o novo credito maximo para o cliente: ");
                            scanner.nextLine();
                            String novoCreditostr = scanner.nextLine();
                            novoCreditostr = novoCreditostr.replace(",", ".");
                            double novoCredito = Double.parseDouble(novoCreditostr);
                            clientes.AlterarCred_Maximo(numeroAlt, novoCredito);
                            clientes.EscreverMovimentos("", numeroAlt, true);
                        }
                        else if (dados == 0){return;}
                        else {
                            System.out.println("\n->Opcao invalida\n");
                            return;}
                    }
                    catch (NumberFormatException e){
                        System.out.println("\n->Valores introduzidos invalidos\n");

                }
                    break;
                case "5":
                    System.out.print("\nInsira o numero do cliente a consultar movimentos: ");
                    int nrclienteler = scanner.nextInt();
                    clientes.LerMovimentos(nrclienteler);
                    break;
                case "6":
                    try{
                        System.out.print("\nInsira o numero do cliente a inserir debito: ");
                        int numeroDeb = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Insira o valor do debito: ");
                        String debitostr = scanner.nextLine();
                        double debito = Double.parseDouble(debitostr);
                        clientes.Upd_Debito(debito, numeroDeb);
                    }
                    catch(NumberFormatException e){
                        System.out.println("\n->Valor introduzido invalido\n");
                }
                    break;
                case "7":
                    try{
                        System.out.print("\nInsira o numero do cliente a inserir credito: ");
                        int numeroCre = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Insira o valor do credito: ");
                        String creditostr = scanner.nextLine();
                        double credito = Double.parseDouble(creditostr);
                        clientes.Upd_Credito(credito, numeroCre);
                    }
                    catch(NumberFormatException e){
                        System.out.println("\n->valor introduzido invalido\n");
                    }
                    break;
                case "8":
                    break;
                default:
                    System.out.println("\n->Opcao Invalida\n");
                    break;
            }
        }
        while(!opcao.equals("8"));
    }


    private static void ListaMenu(){
        System.out.println("#####################################################################");
        System.out.println("1 - Listar clientes ativos");
        System.out.println("2 - Adicionar clientes");
        System.out.println("3 - Eliminar um cliente (torna-lo inativo)");
        System.out.println("4 - Modificar dados de um cliente");
        System.out.println("5 - Consultar movimentos de um cliente e verificar credito disponivel");
        System.out.println("6 - Adicionar compra a um cliente");
        System.out.println("7 - Adicionar pagamento a um cliente");
        System.out.println("8 - Sair do programa");
        System.out.println("#####################################################################");
    }
}
