import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Kontroler {

	Stage window;
	BorderPane pane,srodek;
	GridPane lewypanel;
	GridPane dolnypanel;
	Badania badania;
	DanePacjenta danepacjenta;
	ListaPacjentow listapacjentow;
	Baza_Danych baza;
	Dodawanie dodaj;
	
	public Kontroler() {
		
	}

	public Kontroler(Stage primaryStage) {
		
		
		window = primaryStage;
		window.setTitle("Apllikacja");
		pane = new BorderPane();
		lewypanel = new GridPane();
		dolnypanel = new GridPane();
		lewypanel.setVgap(5);
		badania = new Badania();
		danepacjenta = new DanePacjenta();
		listapacjentow =  new ListaPacjentow();
		baza = new Baza_Danych();
		dodaj = new Dodawanie();
		srodek = new BorderPane();
		pane.setCenter(srodek);
		srodek.setCenter(listapacjentow);
		srodek.setBottom(dodaj);
		//srodek.getChildren().addAll(listapacjentow,dodaj);
		lewypanel.getChildren().addAll(badania,danepacjenta);
		lewypanel.setConstraints(danepacjenta,0,0);
		lewypanel.setConstraints(badania,0,1);
		pane.setPadding(new Insets(10,10,10,10));
		pane.setLeft(lewypanel);
		pane.setCenter(srodek);
		pane.setBottom(dolnypanel);
		zaleznosc();
		Scene scena = new Scene(pane,800,500);
		window.setScene(scena);
		window.show();

	}
	void zaleznosc()
	{
		listapacjentow.zaleznosc(baza,badania,danepacjenta, dodaj);
		dodaj.zaleznosc(baza,danepacjenta,badania,listapacjentow);
		danepacjenta.zaleznosc(baza,listapacjentow);
		baza.zaleznosc(listapacjentow);
		badania.zaleznosc(baza);

	}
	

}
