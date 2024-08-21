package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import jdbc.AlunoJDBC;


public class Program {

	public static void main(String[] args) {
		
		try {
        	
            int opcao = 0;
            Scanner console = new Scanner(System.in);
            
            do {
            	System.out.println("####### Menu #######"
            						+ "\n1 - Cadastrar"
            						+ "\n2 - Listar"
            						+ "\n3 - Alterar"
            						+ "\n4 - Excluir"
            						+ "\n5 - Sair");
            	System.out.println("\n\tOpção:");
            	opcao = Integer.parseInt(console.nextLine());
            	
            	if (opcao == 1) {
            	
            		Aluno a = new Aluno();
            		AlunoJDBC acao = new AlunoJDBC();
            		
            		System.out.println("\n ### Cadastrar Aluno ### \n\r");
            		
            		System.out.print("Nome: ");
            		a.setNome(console.nextLine());
            		
            		System.out.print("Sexo: ");
            		a.setSexo(console.nextLine());
            	
            		System.out.print("Data de Nascimento (dd-mm-aaaa): ");
            		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            		a.setDt_nasc( LocalDate.parse(console.nextLine(), formato) );
            		
            		acao.salvar(a);
            		console.nextLine();
            		System.out.println("\n\n\n\n");
            	}
            	
            	if (opcao == 2) {
            	    AlunoJDBC acao = new AlunoJDBC();
            	    List<Aluno> alunos = acao.listar();
            	    
            	    System.out.println("\n ### Lista de Alunos ### \n\r");
            	    
            	    for (Aluno a : alunos) {
            	        System.out.println("ID: " + a.getId());
            	        System.out.println("Nome: " + a.getNome());
            	        System.out.println("Sexo: " + a.getSexo());
            	        System.out.println("Data de Nascimento: " + a.getDt_nasc().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            	        System.out.println("------------------------------");
            	    }
            	    console.nextLine();
            	}
            	
            	if (opcao == 3) {
            	    AlunoJDBC acao = new AlunoJDBC();
            	    Aluno a = new Aluno();
            	    
            	    System.out.println("\n ### Alterar Aluno ### \n\r");
            	    
            	    System.out.print("ID do Aluno: ");
            	    a.setId(Integer.parseInt(console.nextLine()));
            	    
            	    System.out.print("Nome: ");
            	    a.setNome(console.nextLine());
            	    
            	    System.out.print("Sexo: ");
            	    a.setSexo(console.nextLine());
            	    
            	    System.out.print("Data de Nascimento (dd/mm/aaaa): ");
            	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            	    a.setDt_nasc(LocalDate.parse(console.nextLine(), formato));
            	    
            	    acao.alterar(a);
            	    console.nextLine();
            	    System.out.println("\n\n\n\n");
            	}
            	
            	if (opcao == 4) {
            	    AlunoJDBC acao = new AlunoJDBC();
            	    
            	    System.out.println("\n ### Excluir Aluno ### \n\r");
            	    
            	    System.out.print("ID do Aluno: ");
            	    int id = Integer.parseInt(console.nextLine());
            	    
            	    acao.apagar(id);
            	    console.nextLine();
            	    System.out.println("\n\n\n\n");
            	}
            	
            } while(opcao != 5);
            
        } catch (Exception e){
            System.out.println("Erro: " + e); 
        }
	} 
}