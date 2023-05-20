package GenericLibraries;

public enum Tabnames {
	
	ORGANIZATIONS("Organizations"),LEADS("Leads"),CONTACTS("Contacts");
	
	private String tabname;
	
	private Tabnames(String tab) {
		this.tabname=tab;
	}
	
	public String getTabName() {
		return tabname;
	}

}
