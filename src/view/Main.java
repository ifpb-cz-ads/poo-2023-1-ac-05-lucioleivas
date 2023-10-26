package view;

import model.*;

import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
    	Cliente lucio=new PessoaFisica(1000,new Endereco("rua abraao",164,"cajazeiras"),
    			"111.222.333-00","lucio",LocalDate.of(2003,11,22));
    	Cliente leivas =new PessoaFisica(5000,new Endereco("rua feitosa",300,"Souza"),
    			"112.221.33-00","leivas",LocalDate.of(1996, 10, 18));
    	
    	Conta contacorrente1=new ContaCorrente(30,388,300,LocalDate.now(),lucio,25);    	
    	Conta contacorrente2=new ContaCorrente(31,255,900,LocalDate.now(),leivas,30);
    	int opcao;
    	
    	do {
    		System.out.println("digite 1 para entrar como lucio\ndigite 2 para entrar como leivas\ndigite 0 para sair");
    		opcao=sc.nextInt();
    		
    		switch(opcao) {
    		case 1:System.out.println("voce entrou como lucio!!!");
    		
				do {
    			System.out.println(" Digite:\n1-Sacar\n2-Depositar\n3-Transferir\n4-Ver saldo\n5-Encerrar o programa");
    			opcao=sc.nextInt();
    			double valor;
    			
    			switch(opcao) {
    			
    			case 1:
    				System.out.println("digite o valor para ser sacado:");
    				valor=sc.nextDouble();
    				if(contacorrente1.sacar(valor)) {
    					System.out.println("deu certo");
    				}else {
    					System.out.println("saldo insuficiente");
    				}
    				break;
    				
    			case 2:
    				System.out.println("digite o valor a ser depositado:");
    				valor=sc.nextDouble();
    				if(contacorrente1.depositar(valor)) {
    					System.out.println("deu certo");
    				}else {
    					System.out.println("algo deu errado");
    				}
    				break;
    				
    			case 3:
    				valor=sc.nextDouble();
    				if(contacorrente1.transferir(valor, contacorrente2)) {
    					}
    				break;
    				
    			case 4:
    				System.out.println("seu saldo eh:"+contacorrente1.getSaldo());
    				break;
    				
    			case 5:
    				System.out.println("Saindo!!!");
    				break;
    				
    				default:System.out.println("valor inválido");
    				break;
    			}
    			
    		}while(opcao!=5);
    		break;
    	
    		case 0:
    			System.out.println("Encerrando!!!");
    			break;
    		
    		default:
    			System.out.println("digite um valor válido");
    			break;
    			}
    		
    	}while(opcao!=0);
    }
}