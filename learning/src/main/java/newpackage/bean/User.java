package newpackage.bean;


public class User {
    String id;
    String name;
    String address;
    long phoneno;
    String email;
    String password;

    public User() {
    }

    public User(String id, String name, String address,String email, String password,long phoneno) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address=address;
        this.phoneno=phoneno;
    }
	public User(String name, String address, String email, String password, long phoneno) {
		
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
	}    

	public User(String address, String email, String password, long phoneno) {
		this.address = address;
		this.phoneno = phoneno;
		this.email = email;
		this.password = password;
	}

	public User(String email, String password, long phoneno) {
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
	}

	public User(String password,long phoneno) {
		this.phoneno = phoneno;
		this.password = password;
	}

	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
        return id;
    }

   

	public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}



	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}