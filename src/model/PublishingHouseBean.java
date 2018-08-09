package model;

public class PublishingHouseBean {
	
	
	String idCasaEditrice, nome, telefono, indirizzo;
	private Boolean valido; 
	
	/**
	 * @return the idCasaEditrice
	 */
	public String getIdCasaEditrice() {
		return idCasaEditrice;
	}

	/**
	 * @param idCasaEditrice the idCasaEditrice to set
	 */
	public void setIdCasaEditrice(String idCasaEditrice) {
		this.idCasaEditrice = idCasaEditrice;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public boolean isValid() { return valido; } 
	
	public void setValid(boolean newValido) { valido = newValido; }	

}
