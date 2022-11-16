module com.mycompany.trabalho_final_poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.trabalho_final_poo to javafx.fxml;
    exports com.mycompany.trabalho_final_poo;
}
