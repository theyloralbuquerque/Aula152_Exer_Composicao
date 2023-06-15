package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import entities.enums.StatusPedido;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // modelo de recebimento do date.
		
		System.out.println("Digite os dados do cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Data de anivers�rio (DD/MM/YYYY): ");
		Date dataAniversario = sdf.parse(sc.next()); /* a vari�vel "dataAviversario" do tipo Date recebe o que o 
													  * usu�rio digitar convertido no formato sdf.
													  * .parse() converte o que o usu�rio digita em formato sdf.
													  */
		Cliente cliente = new Cliente(nome, email, dataAniversario);
	
// PARTE 2 -------------------------------------------------------------------------
		
		System.out.println("Digite os dados do pedido: ");
		System.out.print("Status: ");
		StatusPedido status = StatusPedido.valueOf(sc.next()); // converte a String que o usu�rio digitar em tipo Enum.
		
		Pedido pedido = new Pedido(new Date(), status, cliente); // new Date() passa um instante de data e hora atual como par�metro.
		
		System.out.print("Quantos itens tem o pedido? ");
		Integer quantidadeItens = sc.nextInt();
		for (int i=1; i<= quantidadeItens; i++) {
			System.out.println("Digite os dados do item " + i + "#:");
			System.out.print("Nome do produto: ");
			sc.nextLine(); // consome a quebra de linha da entrada de dados anterior.
			String nomeProduto = sc.nextLine();
			System.out.print("Pre�o do produto: ");
			Double precoProduto = sc.nextDouble();
			System.out.print("Quantidade: ");
			Integer quantidade = sc.nextInt();
			
			/* Agora eu vou ter que instanciar o objeto da classe Produto, passando como par�metro
			 * o nomeProduto e o precoProduto. 
			 */
			Produto produto = new Produto (nomeProduto, precoProduto);
			
			/* Agora eu vou ter que instanciar o objeto da classe ItemPedido, passando como par�metro
			 * quantidade, nomeProduto e o objeto de produto. 
			 */
			ItemPedido itemPedido = new ItemPedido(quantidade, precoProduto, produto);
			
			pedido.addItem(itemPedido); /* itemPedido � uma lista e o que est� sendo passado � s�o os 
										 * itens dessa lista que est�o na repeti��o atual.
										 * 
										 */	
		}
		
		System.out.println();
		System.out.println(pedido);
		
	}

}
