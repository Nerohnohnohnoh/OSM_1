import java.awt.Color;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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

public class Badania extends GridPane {
	
	CheckBox wynik1;
	TextField wynik2;
	TextField wynik3;
	DatePicker data;
	Button zapisz;
	Button anuluj;
	GridPane przyciski;
	
private Pacjent selectedItem;
private Baza_Danych baza;
	
	public Badania() {
		Label badanie1 = new Label("wystêpowanie AlAT");
		Label badanie2 = new Label("poziom AspAT");
		Label badanie3 = new Label("poziom bilirubiny");
		Label datatext = new Label("data");
		
		 wynik1 = new CheckBox();
		 wynik2 = new TextField("0");
		 wynik3 = new TextField("0");
		
		data = new DatePicker();
		
		zapisz = new Button("Zapisz");
		anuluj = new Button("Anuluj");
		
		przyciski = new GridPane();
		

		this.getChildren().addAll(badanie1,badanie2,badanie3,wynik1,wynik2,wynik3,datatext,data,przyciski);
		this.setConstraints(datatext, 0,0);
		this.setConstraints(data, 1,0);
		this.setConstraints(badanie1, 0,1);
		this.setConstraints(badanie2, 0,2);
		this.setConstraints(badanie3, 0,3);
		this.setConstraints(wynik1, 1,1);
		this.setConstraints(wynik2, 1,2);
		this.setConstraints(wynik3, 1,3);
		this.setConstraints(przyciski, 0,4);
		
		przyciski.getChildren().addAll(zapisz,anuluj);
		przyciski.setConstraints(anuluj, 1,0);
		przyciski.setConstraints(zapisz, 0,0);
		przyciski.setHgap(3);
		
		this.setStyle("-fx-border-color: black");

		this.setVgap(3);
		this.setHgap(8);

		this.setPadding(new Insets(10));
		
		zapisz.setOnAction(e->{
			
			if (Integer.parseInt(wynik2.getText()) > 100 || Integer.parseInt(wynik3.getText()) > 100)
			{
				this.setStyle("-fx-border-color: red");
			}
			else
				{
				this.setStyle("-fx-border-color: black");
				}
			if (getSelectedItem()!=null)
			baza.aktualizuj_badanie(getWynik1(),getWynik2(),getWynik3(),getData(),getSelectedItem());

		});
		
		anuluj.setOnAction(e->{
			if (getSelectedItem()!=null)
			{
				this.setWynik1(getSelectedItem().getBadanie());
				this.setwynik2(getSelectedItem().getWynik2());
				this.setwynik3(getSelectedItem().getWynik3());
				this.setData(getSelectedItem().getData());

			}
		});
		
		// TODO Auto-generated constructor stub
	}
	
	
	public Boolean getWynik1()
	{
		return wynik1.isSelected();
	}

	public String getWynik2()
	{
		return wynik2.getText();
	}
	
	public String getWynik3()
	{
		return wynik3.getText();
	}
	public LocalDate getData()
	{
		return data.getValue();
	}


	public void setWynik1(boolean b) {
		this.wynik1.setSelected(b);
	}


	public void setwynik2(String wynik2) {
		this.wynik2.setText(wynik2);
	}


	public void setwynik3(String wynik3) {
		this.wynik3.setText(wynik3);
	}


	public void setData(LocalDate data) {
		
		this.data.setValue(data);
	}
	
	public void setSelectedItem(Pacjent selectedItem) {
		this.selectedItem=selectedItem;
		
	}
	public Pacjent getSelectedItem(){
		return this.selectedItem;
	}


	public void zaleznosc(Baza_Danych baza) {
		this.baza=baza;
	}
	
	
}
