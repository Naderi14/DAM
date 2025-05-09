package daxbnb.model;

/**
 * Clase que ens donarà informació d'una característica en concret que poden tenir els Stays/Estàncies
 * @author Javier Tolosana &lt;<b>tolosanabernad12@alumnes.ilerna.com</b>&gt;
 * @since 0.1v
 */
public class Feature {

	 /** Id único de la característica*/
	private int idFeature;
	
	 /** Información de las característica */
	private String featureInfo;
	
	/**
     * Constructor con todos los atributos
     * @param idFeature			ID único de la característica
     * @param featureInfo		Información de la característica
     */
	public Feature(int idFeature, String featureInfo) {
		this.idFeature = idFeature;
		this.featureInfo = featureInfo;
	}

	/**
	 * Constructor con todos los atributos sin su ID
	 * @param featureInfo		Información de la característica
	 */
	public Feature(String featureInfo) {
		this.featureInfo = featureInfo;
	}

	/** @return el ID de la característica. */
	public int getIdFeature() {
		return idFeature;
	}

	/** @param idFeature establece el ID de la característica. */
	public void setIdFeature(int idFeature) {
		this.idFeature = idFeature;
	}

	/** @return la información de la característica. */
	public String getFeatureInfo() {
		return featureInfo;
	}

	/** @param featureInfo establece la información de la característica. */
	public void setFeatureInfo(String featureInfo) {
		this.featureInfo = featureInfo;
	}

	/** @return la información del constructor de la característica. */
	@Override
	public String toString() {
		return "Feature [idFeature=" + idFeature + ", featureInfo=" + featureInfo + "]";
	}
	
	
}
