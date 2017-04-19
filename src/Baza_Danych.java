import java.awt.Color;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Baza_Danych {
	
	 Set <Pacjent> kolekcja = new HashSet();
	private ListaPacjentow listapacjentow;;
	//ObservableList<Pacjent> data;
	public Baza_Danych() {
	    // data = FXCollections.observableArrayList();
}
	
public  void Dodaj(String imie, String nazwisko, String pesel,String ubezpieczenie,boolean badanie,boolean plec, String wynik2, String wynik3, LocalDate data)
{
	kolekcja.add(new Pacjent(imie, nazwisko, pesel, ubezpieczenie, badanie,plec,wynik2,wynik3,data));	
//	System.out.print(data);
}

public  void Usun(Pacjent pacjent)
{
	kolekcja.remove(pacjent);
	//System.out.print(data);
}


public Set getData() {
	return kolekcja;
}

public void setData(Set kolekcja) {
	this.kolekcja = kolekcja;
}

public int Size()
{
	return kolekcja.size();
}

public void aktualizuj_dane_pacjenta(String imie, String nazwisko, String pesel,String ubezpieczenie, Boolean plec, Pacjent pacjent){
	Boolean badanie = pacjent.getBadanie();
	String wynik2 = pacjent.getWynik2();
	String wynik3 = pacjent.getWynik3();
	LocalDate data = pacjent.getData();
	kolekcja.remove(pacjent);
	kolekcja.add(new Pacjent(imie,nazwisko,pesel,ubezpieczenie,badanie,plec,wynik2,wynik3,data));
	System.out.print(kolekcja);
	listapacjentow.ZaladujTabele(kolekcja);
	
}

public void aktualizuj_badanie(Boolean badanie, String wynik2, String wynik3, LocalDate data, Pacjent pacjent){
		String imie = pacjent.getImie();
		String nazwisko = pacjent.getNazwisko();
		String pesel = pacjent.getPes();
		String ubezpieczenie = pacjent.getUbezpieczenie();
		Boolean plec = pacjent.getPlec();
		kolekcja.remove(pacjent);
		kolekcja.add(new Pacjent(imie,nazwisko,pesel,ubezpieczenie,badanie,plec,wynik2,wynik3,data));
		System.out.print(kolekcja);
		listapacjentow.ZaladujTabele(kolekcja);
}

public void zaleznosc(ListaPacjentow listapacjentow) {
	this.listapacjentow=listapacjentow;
	// TODO Auto-generated method stub
	
}
}
