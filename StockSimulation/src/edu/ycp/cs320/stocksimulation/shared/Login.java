package edu.ycp.cs320.stocksimulation.shared;

/**
 * Class to represent an inventory item.
 */
public class Login {
		private int id; // This also serves as the account id
		private String username;
		private String password;

		/**
		 * Default constructor.
		 */
		public Login() {
			
		}
		
		/**
		 * Constructor.
		 * 
		 * @param username  login name
		 * @param password  login password
		 */
		public Login(String username, String password) {
			this.username = username;
			this.password = password;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public int getId() {
			return id;
		}
		
		/**
		 * Set the item name.
		 * 
		 * @param name the item name to set
		 */
		public void setUsername(String name) {
			this.username = name;
		}
		
		/**
		 * Get the item name.
		 * 
		 * @return the item name.
		 */
		public String getName() {
			return username;
		}
		
		/**
		 * Set the item quantity.
		 * 
		 * @param quantity the item quantity.
		 */
		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * Get the item quantity.
		 * 
		 * @return the item quantity.
		 */
		public String getPassword() {
			return password;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return username + " - " + password;
		}
}
