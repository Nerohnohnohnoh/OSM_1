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
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.*;
import javafx.beans.value.ObservableValue;
import javafx.util.Callback;
import javafx.beans.property.ReadOnlyObjectWrapper;


public class ListaPacjentow extends ScrollPane {
    ObservableList<Pacjent> dane = FXCollections.observableArrayList();
	TableView<Pacjent> table = new TableView<Pacjent>();
	private Badania badania;
	private DanePacjenta danepacjenta;
	private Baza_Danych baza1;
	private Dodawanie dodawanie;


	public ListaPacjentow() {
		
		table.setEditable(true);
            
        TableColumn Imie = new TableColumn("Imie");
        Imie.prefWidthProperty().bind(table.widthProperty().divide(5.5));
        Imie.setCellValueFactory(new PropertyValueFactory<Pacjent, String>("imie"));


        TableColumn Nazwisko = new TableColumn("Nazwisko");
        Nazwisko.prefWidthProperty().bind(table.widthProperty().divide(5));
        Nazwisko.setCellValueFactory(new PropertyValueFactory<Pacjent, String>("nazwisko"));


        TableColumn Pesel = new TableColumn("PESEL");
        Pesel.prefWidthProperty().bind(table.widthProperty().divide(7));
        Pesel.setCellValueFactory(new PropertyValueFactory<Pacjent, String>("pes"));

        TableColumn<Pacjent, String> Ubezpieczenie = new TableColumn<Pacjent, String>("Ubezpieczenie");
        Ubezpieczenie.prefWidthProperty().bind(table.widthProperty().divide(5));
        Ubezpieczenie.setCellValueFactory(new PropertyValueFactory<Pacjent, String>("ubezpieczenie"));

        TableColumn Plec = new TableColumn("Plec");
        Plec.prefWidthProperty().bind(table.widthProperty().divide(6));
        Plec.setCellValueFactory(new Callback<CellDataFeatures<Pacjent, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Pacjent, String> param) {
				return new ReadOnlyObjectWrapper(param.getValue().getPlec() ? "Meszczyzna" : "Kobieta");
			}
		});        
        TableColumn Badania = new TableColumn("Badania");
        Badania.prefWidthProperty().bind(table.widthProperty().divide(8));
      //  Badania.setCellValueFactory(new PropertyValueFactory<Pacjent, Boolean>("badanie"));
		Badania.setCellValueFactory(new Callback<CellDataFeatures<Pacjent, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Pacjent, String> param) {
				return new ReadOnlyObjectWrapper(param.getValue().getBadanie() ? "TAK" : "NIE");
			}
		});
       
       
        
        
        
        table.setOnMouseClicked(e->{
        	if (table.getSelectionModel().getSelectedItem()!=null)
        	{
        		danepacjenta.setImie(table.getSelectionModel().getSelectedItem().getImie());
        		danepacjenta.setNazwisko(table.getSelectionModel().getSelectedItem().getNazwisko());
        		danepacjenta.setPesel(table.getSelectionModel().getSelectedItem().getPes());
        		danepacjenta.setPlec(table.getSelectionModel().getSelectedItem().getPlec());
        		danepacjenta.setUbezpieczenie(table.getSelectionModel().getSelectedItem().getUbezpieczenie());

        		badania.setWynik1(table.getSelectionModel().getSelectedItem().getBadanie());
        		badania.setwynik2(table.getSelectionModel().getSelectedItem().getWynik2());
        		badania.setwynik3(table.getSelectionModel().getSelectedItem().getWynik3());
        		badania.setData(table.getSelectionModel().getSelectedItem().getData());

        		dodawanie.setSelectedItem(table.getSelectionModel().getSelectedItem());
            	danepacjenta.setSelectedItem(table.getSelectionModel().getSelectedItem());
            	badania.setSelectedItem(table.getSelectionModel().getSelectedItem());

        		//System.out.print(table.getSelectionModel().getSelectedItem().getImie());
        	}
        });
 
        table.getColumns().addAll(Imie,Nazwisko,Pesel,Ubezpieczenie,Badania,Plec);
        this.setContent(table);
        table.getSelectionModel().getSelectedItems();
		this.setPadding(new Insets(0, 0, 0, 10));
		
		this.setFitToHeight(true);
		this.setFitToWidth(true);
	}

	
	public void zaleznosc(Baza_Danych baza2, Badania badania, DanePacjenta danepacjenta, Dodawanie dodawanie) {
		this.baza1=baza2;	
		this.badania=badania;
		this.danepacjenta=danepacjenta;
		this.dodawanie=dodawanie;
	}
	
	
	
	public void ZaladujTabele(Set<Pacjent> kolekcja)
	{
		if (dane != null)
		{
			dane.removeAll(dane);
		}
		for (Pacjent pacjent : kolekcja) {
			dane.add(pacjent);
		}
		
		table.setItems(dane);
	}
	


}
