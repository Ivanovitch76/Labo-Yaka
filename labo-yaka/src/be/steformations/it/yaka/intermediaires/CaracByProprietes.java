package be.steformations.it.yaka.intermediaires;

import be.steformations.it.yaka.beans.CaracteristiqueImpl;
import be.steformations.it.yaka.beans.ProprieteImpl;

public class CaracByProprietes {

	ProprieteImpl prop;
	java.util.List<CaracteristiqueImpl> carac;
	
	public ProprieteImpl getProp() {
		return prop;
	}
	public void setProp(ProprieteImpl prop) {
		this.prop = prop;
	}
	public java.util.List<CaracteristiqueImpl> getCarac() {
		return carac;
	}
	public void setCarac(java.util.List<CaracteristiqueImpl> carac) {
		this.carac = carac;
	}
		
}
