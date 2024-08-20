package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private LocalDateTime moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	private Client client;
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	static DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	

	public Order() {
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);

	}

	public Double total() {
		double sum = 0;
		for (OrderItem x : items) {
			sum += x.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		
		sb.append(fmt.format(moment) + "\n");
		
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client.getName() + " ");
		sb.append(fmt2.format(client.getBirthDate()) + " ");
		sb.append(client.getEmail() + "\n");
		sb.append("Ordem Items: \n");
		for (OrderItem x : items) {
			sb.append(x.getProduct().getName() + ", $");
			sb.append(x.getPrice() + ", ");
			sb.append("Quantity: ");
			sb.append(x.getQuantity() + ", ");
			sb.append("Subtotal: $");
			sb.append(x.subTotal() + "\n");
		}
		sb.append("Total price: $");
		sb.append(total());
		return sb.toString();

	}

}
