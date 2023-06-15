package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.StatusPedido;

public class Pedido {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	
	private StatusPedido status; // associação aqui.
	private Cliente cliente; // associação aqui.
	
	private List <ItemPedido> itens = new ArrayList<>(); // associação "tem muitos" aqui.

	
	public Pedido() {
	}

	public Pedido(Date momento, StatusPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	// O atrituto do tipo Lista não tem get nem set, apenas métodos que adicionam e removem itens na Lista. 
	public void addItem(ItemPedido item) {
		itens.add(item);
	}
	
	public void removeItem(ItemPedido item) {
		itens.remove(item);
	}
	
	public Double total() { // método que soma os subtotais dos itens pedidos.
		Double soma = 0.0;
		for (ItemPedido it : itens) {
			soma += it.subTotal();
		}
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RESUMO DO PEDIDO:\n");
		sb.append("Momento do pedido: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status do pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens do Pedido:\n");
		for (ItemPedido item : itens) {
			sb.append(item + "\n"); // aqui será exibido o objeto da lista Item tipo ItemPedido.
		}
		sb.append("Valor Total: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString(); 
	}
}
