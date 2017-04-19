import java.awt.Color;
import javafx.application.Application;
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

public class Dodawanie extends GridPane {
	private DanePacjenta pacjent;
	private Baza_Danych baza;
	private Badania badanie;
	private ListaPacjentow listapacjentow;
	private Pacjent selectedIndex;

	public Dodawanie() {
		
		Button dodawanie = new Button("dodaj");
		Button usun = new Button("usun");
		
		this.getChildren().addAll(dodawanie,usun);
		this.setConstraints(dodawanie,0,0);
		this.setConstraints(usun,60,0);

		dodawanie.setOnAction(e->{
			if (pacjent.getNazwisko() != "" || pacjent.getPesel() != "")
			{
				baza.Dodaj(pacjent.getImie(), pacjent.getNazwisko(), pacjent.getPesel(),pacjent.getUbezpieczenie(),badanie.getWynik1(),pacjent.getPlec(),badanie.getWynik2(),badanie.getWynik3(),badanie.getData());
				listapacjentow.ZaladujTabele(baza.kolekcja);
				System.out.print(baza.kolekcja);
				
			}
		});
		
		usun.setOnAction(e->{		
			if(baza.Size() != 0)
			{
					baza.Usun(getSelectedItem());
					listapacjentow.ZaladujTabele(baza.kolekcja);
					
			}
			
		});
		
	}

	public void zaleznosc(Baza_Danych baza2, DanePacjenta danepacjenta, Badania badania, ListaPacjentow listapacjentow) {

			this.pacjent=danepacjenta;
			this.baza=baza2;
			this.badanie=badania;
			this.listapacjentow=listapacjentow;
	}


	public void setSelectedItem(Pacjent pacjent2) {
		this.selectedIndex = pacjent2;
	}

	public Pacjent getSelectedItem() {
		return selectedIndex;
	}
	



}
