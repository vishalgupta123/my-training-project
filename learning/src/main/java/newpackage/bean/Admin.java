package newpackage.bean;

public class Admin {
String id;
String password;
String name;
public Admin() {
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Admin(String id, String password) {
	this.id = id;
	this.password = password;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
