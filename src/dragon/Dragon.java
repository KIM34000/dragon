package dragon;

public class Dragon extends ConnectionDB {
	int id;
	String nom;
	String genre;
	int size;
	int scales;
	boolean fire;
	String love;
	 public Dragon(int id, String nom, String genre, int size, int scales, boolean fire, String love)
	    {
	        this.id = id;
	        this.nom = nom;
	        this.genre = genre;
	        this.size = size;
	        this.scales = scales;
	        this.fire = fire;
	        this.love = love;
	    }
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	    public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public int getScales() {
			return scales;
		}
		public void setScales(int scales) {
			this.scales = scales;
		}
		public boolean getFire() {
			return fire;
		}
		public void setFire(boolean fire) {
			this.fire = fire;
		}
		public String getLove() {
			return love;
		}
		public void setLove(String love) {
			this.love = love;
		}
		public void affiche() {
	    	 System.out.println("id is " + id + "name is" + nom);
	    	 }
	    @Override
	    public String toString() {
	        return this.nom + "(" + this.id + this.nom + ")";
	    }
}
