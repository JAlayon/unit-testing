package com.alayon.unittesting.models;

public class Item {

	private final int id;
	private final String name;
	private final int price;
	private final int quantity;

	public Item(final int id, final String name, final int price, final int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return String.format("Item[%d, %s, %d, %d]", id, name, price, quantity);
	}
}