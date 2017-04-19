import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DanePacjenta extends GridPane {
	TextField imie;
	TextField nazwisko;
	TextField pesel;
	CheckBox mezczyzna;
	CheckBox kobieta;
	Boolean plec;
	ChoiceBox ubezpieczenie;
	private Baza_Danych baza;
	private ListaPacjentow listapacjentow;
	private Pacjent selectedItem;
	
	
	public DanePacjenta() {
		
		
		Label Imie = new Label("Imie");
		imie = new TextField("");
		this.getChildren().addAll(Imie,imie);
		this.setConstraints(Imie,0,0);
		this.setConstraints(imie,1,0);

		Label Nazwisko = new Label("Nazwisko");
		nazwisko = new TextField();
		this.getChildren().addAll(Nazwisko,nazwisko);
		this.setConstraints(Nazwisko,0,1);
		this.setConstraints(nazwisko,1,1);

		Label PESEL = new Label("PESEL");
		pesel = new TextField();
		this.getChildren().addAll(PESEL,pesel);
		this.setConstraints(PESEL,0,2);
		this.setConstraints(pesel,1,2);
	
		Label Plec = new Label("P³eæ");
		GridPane plec = new GridPane();
		mezczyzna = new CheckBox("Mê¿czyzna");
		mezczyzna.setSelected(true);
		
		mezczyzna.setOnAction(e->{
			
			mezczyzna.setSelected(true);
			kobieta.setSelected(false);
			
	});
		
		kobieta = new CheckBox("Kobieta");
		
		kobieta.setOnAction(e->{
			
				mezczyzna.setSelected(false);
				kobieta.setSelected(true);

		});
		
		this.getChildren().addAll(Plec,plec);
		this.setConstraints(Plec,0,3);
		this.setConstraints(plec,1,3);
		plec.getChildren().addAll(mezczyzna,kobieta);
		plec.setConstraints(kobieta,1,0);
		plec.setHgap(3);
		
		Label Ubezpieczenie = new Label("Ubezpieczenie");
		//ubezpieczenie = new ChoiceBox(FXCollections.observableArrayList("NFZ", "Prywatne", "Brak"));
		ubezpieczenie = new ChoiceBox();
		ubezpieczenie.getItems().addAll("NFZ", "Prywatne", "Brak");

		
		this.getChildren().addAll(Ubezpieczenie,ubezpieczenie);
		this.setConstraints(Ubezpieczenie,0,4);
		this.setConstraints(ubezpieczenie,1,4);


		GridPane przyciski = new GridPane();
		Button zapisz = new Button("Zapisz");
		Button anuluj = new Button("Anuluj");
		przyciski.getChildren().addAll(zapisz,anuluj);
		przyciski.setConstraints(zapisz,0,0);
		przyciski.setConstraints(anuluj,1,0);
		przyciski.setHgap(2);
		this.getChildren().addAll(przyciski);
		this.setConstraints(przyciski,0,5);


		
		this.setPadding(new Insets(10));
		this.setStyle("-fx-border-color: black");
		this.setVgap(3);
		
		zapisz.setOnAction(e->{
			//System.out.print(baza.kolekcja);
			if (getSelectedItem()!=null)
			baza.aktualizuj_dane_pacjenta(getImie(), getNazwisko(), getPesel(), getUbezpieczenie(), getPlec(), getSelectedItem());
		});
		
		anuluj.setOnAction(e->{
			if (getSelectedItem()!=null){
				this.setImie(getSelectedItem().getImie());
				this.setNazwisko(getSelectedItem().getNazwisko());
				this.setPesel(getSelectedItem().getPes());
				this.setUbezpieczenie(getSelectedItem().getUbezpieczenie());
				if (getSelectedItem().getPlec() == true)
				{
					mezczyzna.setSelected(true);
					kobieta.setSelected(false);
				}
				else
				{
					kobieta.setSelected(true);
					mezczyzna.setSelected(false);
				}
			}
		});

		
	}
	
	
	public String getImie()
	{
		return imie.getText();
	}
	
	public String getNazwisko()
	{
		return nazwisko.getText();
	}
	
	public String getPesel()
	{
		return pesel.getText();
	}
	
	public Boolean getPlec()
	{
		if(mezczyzna.isSelected()==true)
		{
			plec=true;
		}
		else
		{
			plec=false;
		}
		return plec;
		
	}
	public String getUbezpieczenie()
	{
		return (String) ubezpieczenie.getValue();
	}
	
	
	public void setUbezpieczenie(String string) {
		this.ubezpieczenie.setValue(string);
	}


	public void setImie(String imie)
	{
		this.imie.setText(imie);
	}
	
	public void setNazwisko(String nazwisko)
	{
		this.nazwisko.setText(nazwisko);
	}
	
	public void setPesel(String pesel)
	{
		this.pesel.setText(pesel);
	}
	
	public void setPlec(boolean plec)
	{
		if (plec==true)
		{
			mezczyzna.setSelected(true);
			kobieta.setSelected(false);
		}
		else
		{
			mezczyzna.setSelected(false);
			kobieta.setSelected(true);
		}
		this.plec=plec;
	}


	public void zaleznosc(Baza_Danych baza, ListaPacjentow listapacjentow) {
		this.baza=baza;
		this.listapacjentow=listapacjentow;
		
	}


	public void setSelectedItem(Pacjent selectedItem) {
		this.selectedItem=selectedItem;
		
	}
	public Pacjent getSelectedItem(){
		return this.selectedItem;
	}
	
	
	
}
