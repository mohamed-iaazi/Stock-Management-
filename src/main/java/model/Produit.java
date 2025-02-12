package model;


public class Produit {
	    private int id;
	    private  String name;
	    private  String description;
	    private  int quantity;
	    private int price;
	    private  String category;


	    public Produit(int id, String name, String description, int quantity, int price, String category) {
	        this.id = id;
	        this.name = name;
	        this.description = description;
	        this.quantity = quantity;
	        this.price = price;
	        this.category = category;
	    }

	    public Produit() {
	    }

		public Produit(String name, String description, int quantity, int price, String category) {
			super();
			this.name = name;
			this.description = description;
			this.quantity = quantity;
			this.price = price;
			this.category = category;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
    
}