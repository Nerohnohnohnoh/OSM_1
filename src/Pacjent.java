import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pacjent {

	String imie;
	String nazwisko;
	String pes;
	String ubezpieczenie;
	Boolean badanie;
	Boolean plec;
	String wynik2,wynik3;
	LocalDate data;
	
	
	public Pacjent(String imie, String nazwisko,String pesel,String ubezpieczenie,boolean badanie, boolean plec, String wynik2, String wynik3, LocalDate data) {
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.pes=pesel;
		this.ubezpieczenie=ubezpieczenie;
		this.badanie=badanie;
		this.plec=plec;
		this.wynik2=wynik2;
		this.wynik3=wynik3;
		this.data=data;

		// TODO Auto-generated constructor stub
	}

	public String getImie() {
		return imie;
	}


	public void setImie(String imie) {
		this.imie=imie;
	}


	public String getNazwisko() {
		return nazwisko;
	}


	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}


	public String getPes() {
		return pes;
	}


	public void setPes(String pes) {
		this.pes = pes;
	}


	public String getUbezpieczenie() {
		return ubezpieczenie;
	}


	public void setUbezpieczenie(String ubezpieczenie) {
		this.ubezpieczenie = ubezpieczenie;
	}


	public boolean getBadanie() {
		return badanie;
	}


	public void setBadanie(Boolean badanie) {
		this.badanie = badanie;
	}


	public boolean getPlec() {
		return plec;
	}


	public void setPlec(Boolean plec) {
		this.plec = plec;
	}


	public String getWynik2() {
		return wynik2;
	}


	public void setWynik2(String wynik2) {
		this.wynik2 = wynik2;
	}


	public String getWynik3() {
		return wynik3;
	}


	public void setWynik3(String wtnik3) {
		this.wynik3 = wtnik3;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pes == null) ? 0 : pes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacjent other = (Pacjent) obj;
		if (pes == null) {
			if (other.pes != null)
				return false;
		} else if (!pes.equals(other.pes))
			return false;
		return true;
	}

	


}

