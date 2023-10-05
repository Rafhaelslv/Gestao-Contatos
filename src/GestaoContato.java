import java.util.Scanner;

import javax.swing.JOptionPane;

public class GestaoContato{
    public static final int MAX_SIZE =50;
    private int indice;
    private final Contato[] contatos = new Contato[MAX_SIZE];
    private final Scanner input = new Scanner(System.in);

    public void criar(){
        System.out.println("Cadastro de Fulano");
        if(indice < MAX_SIZE){
            Contato cont = new Contato();
            System.out.println("Digite o nome do sapopembo: ");
            cont.setNome( input.nextLine());

            System.out.println("Digite o numero do telefone do danono");
            long telefone = input.nextLong();
            input.nextLine();
            cont.setTelefone(telefone);

            System.out.println("Digite o email do princeso");
            cont.setEmail( input.nextLine());

            cont.setId(indice);
            contatos[indice] = cont;
            indice++;
        }
    }

    public void atualizar(){
        System.out.println("Atualização beutrano");
        System.out.println("Informe o nome do meliante");
        String nome = input.nextLine();
        int i = pesquisar(nome);
            if(i >= 0){
                Contato cont = contatos[i];
                System.out.println("Digite o novo nome: ");
                cont.setNome(input.nextLine());

                System.out.println("Digite o novo numero de telefone: ");
                long telefone = input.nextLong();
                input.nextLine();
                cont.setTelefone(telefone);

                System.out.println("Digite o novo E-mail: ");
                cont.setEmail(input.nextLine());

                cont.setId(indice);
            }
    }
    

    public int pesquisar(String nome){
        for(int i = 0; i < MAX_SIZE; i++){
            Contato cont = contatos[i];
            if( cont != null){
                if(nome.equals(cont.getNome())){
                    return i;
                }
            }

        }
        return -1;
    }


    public void excluir(){
        System.out.println("Bloqueando a ex");
        System.out.println("Informe o nome da quenga");
        String nome = input.nextLine();
        int i = pesquisar(nome);
        if( i >= 0){
            contatos[i] = null;
        }
    }

    public void listar(){
        System.out.print("****Listagem de Contatinhos****");
        for(int i = 0; i < MAX_SIZE; i++){
            Contato cont = contatos[i];
            if(cont != null){
                System.out.println(cont);
            }
        }
    }

    public void exibir(){
        System.out.println("Exibir detalhes do seu contatinho");
        System.out.println("Digite o nome: ");
        String nome = input.nextLine();
        int i = pesquisar(nome);
        if(i >= 0){
            Contato cont = contatos[i];
            System.out.println("Id: " +cont.getId());
            System.out.println("Nome: "+cont.getNome());
            System.out.println("Telefone: "+cont.getTelefone());
            System.out.println("E-mail: "+cont.getEmail());
            
        }else{
            System.out.println("Contatinho não encontrado");
        }
     }

     public void menu() {
		int opc=0;
		while(opc!=9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Criar \\n 2 - Listar \\n 3 - Excluir \\n 4 - Atualizar \\n 5 - Exibir \\n 9 - Finaliza\""));
		    switch (opc) {
		    case 1: criar();
			    break;
		    case 2: listar();
			    break;
		    case 3: excluir();
			    break;
		    case 4: atualizar();
			    break;
		    case 5: exibir();
			    break;
		    case 9:JOptionPane.showMessageDialog(null,"FINALIZADO");
			    break;
		default:JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA");
		    }
		}
	}
    public static void main(String[] args){
        new GestaoContato().menu();
    }

    
}